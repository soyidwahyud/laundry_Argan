package com.example.laundryargan.model_class;

import java.io.Serializable;
class pelanggan {
    private int idpelanggan;
    private String nama_pelanggan, no_hp;

    public pelanggan(int idpelanggan, String nama_pelanggan, String no_hp) {
        this.idpelanggan = idpelanggan;
        this.nama_pelanggan = nama_pelanggan;
        this.no_hp = no_hp;
    }
    public pelanggan(){

    }

    public int getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(int idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public String getNama_pelanggan() {
        return nama_pelanggan;
    }

    public void setNama_pelanggan(String nama_pelanggan) {
        this.nama_pelanggan = nama_pelanggan;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }
}
