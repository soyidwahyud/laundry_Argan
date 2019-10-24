package com.example.laundryargan.model_class;

import java.util.Date;

public class header {
    int idtransaksi;
    Date tanggal_masuk, tanggalambil;
    private pelanggan p = new pelanggan();

    public header(){

    }
    public header(int idtransaksi, Date tanggal_masuk, Date tanggalambil, pelanggan p) {
        this.idtransaksi = idtransaksi;
        this.tanggal_masuk = tanggal_masuk;
        this.tanggalambil = tanggalambil;
        this.p = p;
    }

    public int getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(int idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public Date getTanggal_masuk() {
        return tanggal_masuk;
    }

    public void setTanggal_masuk(Date tanggal_masuk) {
        this.tanggal_masuk = tanggal_masuk;
    }

    public Date getTanggalambil() {
        return tanggalambil;
    }

    public void setTanggalambil(Date tanggalambil) {
        this.tanggalambil = tanggalambil;
    }

    public pelanggan getP() {
        return p;
    }

    public void setP(pelanggan p) {
        this.p = p;
    }
}
