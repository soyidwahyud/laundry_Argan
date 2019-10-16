package com.example.laundryargan;

public class Api {
    private static final String root_url = "http://10.0.2.3:3306/laundryAPI/v1/Api.php?apicall=";

    public static final String url_create_pelanggan = root_url +"createPelanggan";
    public static final String url_create_jenis_barang = root_url +"createJbarang";
    public static final String url_create_barang = root_url +"createBarang";
    public static final String url_create_transaksi = root_url +"createtransaksi";

    public static final String url_read_pelanggan = root_url +"getpelanggan";
    public static final String url_read_jenis_barang = root_url +"getJbarang";
    public static final String url_read_barang = root_url +"getBarang";
    public static final String url_read_transaksi = root_url +"gettransaksi";
    public static final String url_read_laporan = root_url +"getlaporan";

    public static final String url_delete_pelanggan = root_url +"deletePelanggan";
    public static final String url_delete_jenis_pelanggan = root_url +"deleteJbarang";
    public static final String url_delete_barang = root_url +"deleteBarang";
    public static final String url_delete_transaksi = root_url +"deletetransaksi";
    public static final String url_delete_laporan = root_url +"deletelaporan";
}
