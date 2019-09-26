package com.example.laundryargan.model_class;

class jenis_barang {
    private int idjBarang,harga;
    private String namabarang;

    public jenis_barang(int idjBarang, int harga, String namabarang) {
        this.idjBarang = idjBarang;
        this.harga = harga;
        this.namabarang = namabarang;
    }
    public jenis_barang(){

    }

    public int getIdjBarang() {
        return idjBarang;
    }

    public void setIdjBarang(int idjBarang) {
        this.idjBarang = idjBarang;
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
