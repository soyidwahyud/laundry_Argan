package com.example.laundryargan.model_class;

import java.io.Serializable;
public class pelanggan {
    private int idpelanggan;
    private String nama_pelanggan;
    private String no_hp;

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    private String alamat;

    public pelanggan(int idpelanggan, String nama_pelanggan, String no_hp, String alamat) {
        this.idpelanggan = idpelanggan;
        this.nama_pelanggan = nama_pelanggan;
        this.no_hp = no_hp;
        this.alamat = alamat;
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
