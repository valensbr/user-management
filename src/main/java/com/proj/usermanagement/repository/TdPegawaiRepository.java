package com.proj.usermanagement.repository;

import com.proj.usermanagement.entity.TdPegawai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public interface TdPegawaiRepository extends JpaRepository<TdPegawai, UUID>{

    @Query(value = "SELECT count(*) from td_pegawai", nativeQuery = true)
    Integer totalPegawai();


    @Query(value = "select * from td_pegawai " +
            "WHERE id_pegawai=:idPegawai", nativeQuery = true)
    TdPegawai getPegawai(UUID idPegawai);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM td_pegawai WHERE id_pegawai=:idPegawai", nativeQuery = true)
    void deletePegawai(@Param("idPegawai") UUID idPegawai);

}
