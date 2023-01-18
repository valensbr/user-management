package com.proj.usermanagement.repository;

import com.proj.usermanagement.entity.TdPegawai;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@Repository
public class TdPegawaiClassRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<TdPegawai> getDataPegawai(Integer offset){

        StringBuilder qb = new StringBuilder();
        String sisipan = qb.toString();

        Query query = entityManager.createNativeQuery("SELECT cast(id_pegawai as varchar), " +
                "nama, " +
                "jenis_kelamin, " +
                "tanggal_lahir, " +
                "tempat_lahir, " +
                "agama, " +
                "alamat, " +
                "created_date, " +
                "updated_date\n" +
                "FROM td_pegawai\n" +
                "ORDER BY created_date").setFirstResult(offset).setMaxResults(10);
        List hasil = query.getResultList();
        List<TdPegawai> result = new ArrayList<>();

        Iterator itr = hasil.iterator();
        while (itr.hasNext()){
            TdPegawai browse = new TdPegawai();
            Object[] obj = (Object[]) itr.next();
            UUID idPegawai = UUID.fromString(String.valueOf(obj[0]));
            String nama = String.valueOf(obj[1]);
            String jenisKelamin = String.valueOf(obj[2]);
            Date tanggalLahir = Date.valueOf(String.valueOf(obj[3]));
            String tempatLahir = String.valueOf(obj[4]);
            String agama = String.valueOf(obj[5]);
            String alamat = String.valueOf(obj[6]);

            Date createdDate = Date.valueOf(String.valueOf(obj[7]));
            Date updatedDate = Date.valueOf(String.valueOf(obj[8]));

            browse.setIdPegawai(idPegawai);
            browse.setNama(nama);
            browse.setJenisKelamin(jenisKelamin);
            browse.setTanggalLahir(tanggalLahir);
            browse.setTempatLahir(tempatLahir);
            browse.setAgama(agama);
            browse.setAlamat(alamat);
            browse.setCreatedDate(createdDate);
            browse.setUpdatedDate(updatedDate);

            result.add(browse);
        }
        return result;
    }
}
