package com.example.laundryargan.model_class;

public class laporan {
    private int idlaporan, jmltransaksi;
    private transaksi t = new transaksi();

    public laporan(int idlaporan, int jmltransaksi, transaksi t) {
        this.idlaporan = idlaporan;
        this.jmltransaksi = jmltransaksi;
        this.t = t;
    }

    public int getIdlaporan() {
        return idlaporan;
    }

    public void setIdlaporan(int idlaporan) {
        this.idlaporan = idlaporan;
    }

    public int getJmltransaksi() {
        return jmltransaksi;
    }

    public void setJmltransaksi(int jmltransaksi) {
        this.jmltransaksi = jmltransaksi;
    }

    public transaksi getT() {
        return t;
    }

    public void setT(transaksi t) {
        this.t = t;
    }
}
