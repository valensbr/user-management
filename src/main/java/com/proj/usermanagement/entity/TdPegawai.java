package com.proj.usermanagement.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "td_pegawai", schema = "pegawai")
public class TdPegawai implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(name = "id_pegawai",length = 36, nullable = false)
    private UUID idPegawai;
    @Column(name = "nama", nullable = true)
    private String nama;
    @Column(name = "jenis_kelamin",length = 1, nullable = true)
    private String jenisKelamin;
    @Column(name = "tanggal_lahir", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date tanggalLahir;
    @Column(name = "tempat_lahir", length = 25, nullable = true)
    private String tempatLahir;
    @Column(name = "agama",length = 7, nullable = true)
    private String agama;
    @Column(name = "alamat",length = 1000, nullable = true)
    private String alamat;
    @Column(name = "created_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @Column(name = "updated_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date updatedDate;
}
