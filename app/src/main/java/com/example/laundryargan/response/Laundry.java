
package com.example.laundryargan.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Laundry {

    @SerializedName("idpelanggan")
    @Expose
    private String idpelanggan;
    @SerializedName("nama_pelanggan")
    @Expose
    private String namaPelanggan;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("notelp")
    @Expose
    private String notelp;
    @SerializedName("idbarang")
    @Expose
    private String idbarang;
    @SerializedName("namabarang")
    @Expose
    private String namabarang;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("idtransaksi")
    @Expose
    private String idtransaksi;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("tanggal_masuk")
    @Expose
    private String tanggalMasuk;
    @SerializedName("tanggalambil")
    @Expose
    private String tanggalambil;
    @SerializedName("iddetail")
    @Expose
    private String iddetail;
    @SerializedName("jumlah")
    @Expose
    private String jumlah;
    @SerializedName("beratbaju")
    @Expose
    private String beratbaju;
    @SerializedName("pdalam")
    @Expose
    private String pdalam;

    public String getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(String idpelanggan) {
        this.idpelanggan = idpelanggan;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getIdtransaksi() {
        return idtransaksi;
    }

    public void setIdtransaksi(String idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getTanggalambil() {
        return tanggalambil;
    }

    public void setTanggalambil(String tanggalambil) {
        this.tanggalambil = tanggalambil;
    }

    public String getIddetail() {
        return iddetail;
    }

    public void setIddetail(String iddetail) {
        this.iddetail = iddetail;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getBeratbaju() {
        return beratbaju;
    }

    public void setBeratbaju(String beratbaju) {
        this.beratbaju = beratbaju;
    }

    public String getPdalam() {
        return pdalam;
    }

    public void setPdalam(String pdalam) {
        this.pdalam = pdalam;
    }

}
