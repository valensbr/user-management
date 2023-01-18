package com.proj.usermanagement.controller;

import com.proj.usermanagement.entity.TdPegawai;
import com.proj.usermanagement.service.PegawaiService;
import com.proj.usermanagement.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pegawai")
public class PegawaiController {
    @Autowired
    private PegawaiService pegawaiService;

    @GetMapping("/get-data-pegawai")
    public ResponseEntity getDataPegawai(Integer page){
        ResponseEntity responseEntity = pegawaiService.getDataPegawai(page);
        return responseEntity;
    }

    @PostMapping("/insert-data-pegawai")
    public ResponseEntity<MessageModel> simpanPegawai(@RequestBody TdPegawai payload){
        ResponseEntity responseEntity = pegawaiService.simpanPegawai(payload);
        return responseEntity;
    }

    @PutMapping("/update-data-pegawai")
    public ResponseEntity<MessageModel> updatePegawai(@RequestBody TdPegawai payload){
        ResponseEntity responseEntity = pegawaiService.updatePegawai(payload);
        return responseEntity;
    }

    @DeleteMapping("/delete-data-pegawai")
    public ResponseEntity hapusDataPegawai(@RequestParam UUID idPegawai){

        ResponseEntity responseEntity = pegawaiService.deletePegawai(idPegawai);
        return responseEntity;
    }
}
