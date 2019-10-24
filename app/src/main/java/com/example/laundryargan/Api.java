package com.example.laundryargan;

public class Api {
    private static final String root_url = "http://192.168.65.93:3306/laundryAPI/v1/Api.php?apicall=";

    public static final String url_create_pelanggan = root_url +"createPelanggan";
    public static final String url_create_header = root_url +"createHeader";
    public static final String url_create_barang = root_url +"createBarang";
    public static final String url_create_detail = root_url +"createDetail";

    public static final String url_read_pelanggan = root_url +"getpelanggan";
    public static final String url_read_header = root_url +"getHeader";
    public static final String url_read_barang = root_url +"getBarang";
    public static final String url_read_detail = root_url +"getDetail";
    public static final String url_read_laporan = root_url +"getlaporan";

    public static final String url_delete_pelanggan = root_url +"deletePelanggan";
    public static final String url_delete_header = root_url +"deleteHeader";
    public static final String url_delete_barang = root_url +"deleteBarang";
    public static final String url_delete_detail = root_url +"deleteDetail&id=";

}
