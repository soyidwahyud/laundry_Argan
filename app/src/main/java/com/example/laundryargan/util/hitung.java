package com.example.laundryargan.util;

public class hitung {
    public static final int biasa = 0;
    public static final int kilat = 0;

    private int berat;
    private int jumlahbaju;
    private int total;

    public hitung(int jumlahbaju, int berat){
        this.berat = berat;
        this.jumlahbaju = jumlahbaju;
        this.total = calculate();
    }
    public int getJumlahbaju() {return jumlahbaju;}

    public int getTotal() {return  total;}

    private int calculate() {
        switch (berat){
            case 0: return (jumlahbaju * 3500);
            case 1: return (jumlahbaju * 5000);
            default:return 0;
        }
    }
}
