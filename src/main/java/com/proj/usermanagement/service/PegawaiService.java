package com.proj.usermanagement.service;

import com.proj.usermanagement.entity.TdPegawai;
import com.proj.usermanagement.repository.TdPegawaiClassRepository;
import com.proj.usermanagement.repository.TdPegawaiRepository;
import com.proj.usermanagement.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PegawaiService {

    @Autowired
    private TdPegawaiClassRepository tdPegawaiClassRepository;
    @Autowired
    private TdPegawaiRepository tdPegawaiRepository;

    public ResponseEntity getDataPegawai(Integer page){
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try{
            Integer offset = (page - 1) * 10;
            List<TdPegawai> dataRespon = tdPegawaiClassRepository.getDataPegawai(offset);
            Integer totalData = tdPegawaiRepository.totalPegawai();
            if(dataRespon.isEmpty()){
                msg.setStatus(true);
                msg.setMessage("Data Tidak Ditemukan");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                msg.setStatus(true);
                msg.setMessage("Success");
                result.put("total", totalData);
                result.put("data", dataRespon);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }
        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }

    }

    public ResponseEntity simpanPegawai(TdPegawai payload) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();

        try {
            payload.setCreatedDate(new Date());
            payload.setUpdatedDate(new Date());
            System.out.println("test 1"+payload);
            tdPegawaiRepository.save(payload);
            System.out.println("test 2");
            msg.setStatus(true);
            msg.setMessage("Data Tersimpan");
            result.put("Data:", payload);
            msg.setData(result);
            return ResponseEntity.ok().body(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }

    public ResponseEntity updatePegawai(TdPegawai payload) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {


            if (payload != null) {

                TdPegawai data = tdPegawaiRepository.getPegawai(payload.getIdPegawai());
                payload.setCreatedDate(data.getCreatedDate());
                payload.setUpdatedDate(new Date());
                tdPegawaiRepository.save(payload);

                msg.setStatus(true);
                msg.setMessage("Data Berhasil Diupdate");
                result.put("Data:", payload);
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            } else {
                msg.setStatus(false);
                msg.setMessage("Data tidak ditemukan");
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }

    public ResponseEntity deletePegawai(UUID idPegawai) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try{

            tdPegawaiRepository.deletePegawai(idPegawai);
            msg.setStatus(true);
            msg.setMessage("Data Berhasil Dihapus");
            result.put("Terhapus id :", idPegawai);
            msg.setData(result);
            return ResponseEntity.ok().body(msg);
        }catch (Exception e){
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.ok().body(msg);
        }
    }


}
