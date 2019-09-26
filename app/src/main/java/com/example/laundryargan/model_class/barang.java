package com.example.laundryargan.model_class;

import java.sql.ResultSet;

class barang {

    private int idbarang, jumlah, pdalam;
    private double beratbaju;
    private jenis_barang  jb = new jenis_barang();

    public barang()
    {

    }

    public barang(int idbarang, int jumlah, int pdalam, double beratbaju, jenis_barang jb) {
        this.idbarang = idbarang;
        this.jumlah = jumlah;
        this.pdalam = pdalam;
        this.beratbaju = beratbaju;
        this.jb = jb;
    }

    public int getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(int idbarang) {
        this.idbarang = idbarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getPdalam() {
        return pdalam;
    }

    public void setPdalam(int pdalam) {
        this.pdalam = pdalam;
    }

    public double getBeratbaju() {
        return beratbaju;
    }

    public void setBeratbaju(double beratbaju) {
        this.beratbaju = beratbaju;
    }

    public jenis_barang getJb() {
        return jb;
    }

    public void setJb(jenis_barang jb) {
        this.jb = jb;
    }
}
