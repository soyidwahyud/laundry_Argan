package com.example.laundryargan.model_class;

import java.sql.ResultSet;

class barang {

    private int idbarang, harga;
    private String namabarang;

    public barang(int idbarang, int harga, String namabarang) {
        this.idbarang = idbarang;
        this.harga = harga;
        this.namabarang = namabarang;
    }

    public barang() {

    }

    public int getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(int idbarang) {
        this.idbarang = idbarang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }
}
