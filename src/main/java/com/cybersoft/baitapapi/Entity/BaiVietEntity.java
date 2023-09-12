package com.cybersoft.baitapapi.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "baiviet")

public class BaiVietEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tieude")
    private String tieude;
    @Column(name = "noidung")
    private String noidung;
    @Column(name = "id_tacgia")
    private String Id_tacgia;
    @Column(name = "ngayviet")
    private Date ngayviet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getId_tacgia() {
        return Id_tacgia;
    }

    public void setId_tacgia(String id_tacgia) {
        Id_tacgia = id_tacgia;
    }

    public Date getNgayviet() {
        return ngayviet;
    }

    public void setNgayviet(Date ngayviet) {
        this.ngayviet = ngayviet;
    }
}

