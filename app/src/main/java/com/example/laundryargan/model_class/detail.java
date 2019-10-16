package com.example.laundryargan.model_class;

public class detail {
    private int iddetail, jumlah, pdalam;
    private float beratbaju;
    private barang b = new barang();

    public detail(int iddetail, int jumlah, int pdalam, float beratbaju, barang b) {
        this.iddetail = iddetail;
        this.jumlah = jumlah;
        this.pdalam = pdalam;
        this.beratbaju = beratbaju;
        this.b = b;
    }

    public int getIddetail() {
        return iddetail;
    }

    public void setIddetail(int iddetail) {
        this.iddetail = iddetail;
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

    public float getBeratbaju() {
        return beratbaju;
    }

    public void setBeratbaju(float beratbaju) {
        this.beratbaju = beratbaju;
    }

    public barang getB() {
        return b;
    }

    public void setB(barang b) {
        this.b = b;
    }
}
