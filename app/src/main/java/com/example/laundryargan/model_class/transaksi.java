package com.example.laundryargan.model_class;

import java.util.Date;

class transaksi {
    private int idtransaksi;
    private Date tanggalmasuk, tanggalambil;
    private barang b = new barang();
    private pelanggan p = new pelanggan();

    public transaksi(){

    }
    public transaksi(int idtransaksi, Date tanggalmasuk, Date tanggalambil, barang b, pelanggan p) {
        this.idtransaksi = idtransaksi;
        this.tanggalmasuk = tanggalmasuk;
        this.tanggalambil = tanggalambil;
        this.b = b;
        this.p = p;
    }

    public int getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(int idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public Date getTanggalmasuk() {
        return tanggalmasuk;
    }

    public void setTanggalmasuk(Date tanggalmasuk) {
        this.tanggalmasuk = tanggalmasuk;
    }

    public Date getTanggalambil() {
        return tanggalambil;
    }

    public void setTanggalambil(Date tanggalambil) {
        this.tanggalambil = tanggalambil;
    }

    public barang getB() {
        return b;
    }

    public void setB(barang b) {
        this.b = b;
    }

    public pelanggan getP() {
        return p;
    }

    public void setP(pelanggan p) {
        this.p = p;
    }
}
