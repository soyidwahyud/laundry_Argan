package com.example.laundryargan.tampilan;

public class Barang extends Koneksi{
    String URL = "http://192.168.10.251/proyek/server2.php";
    String url = "";
    String response = "";

    public String tampilBarang() {
        try {
            url = URL + "?operasi=viewBarang";
            System.out.println("URL Tampil Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String insertBarang(String namabarang, String harga) {
        try {
            url = URL + "?operasi=insertBarang&namabarang=" + namabarang + "&harga=" + harga;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return  response;
    }
    public String getBiodataById (int id) {
        try {
            url = URL + "?operasi=get_barang_by_id&idbarang=" + id;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String updateBarang (String id, String nama, String harga) {
        try {
            url = URL + "?operasi=updateBarang&idbarang=" + id + "&namabarang=" + nama + "&harga=" + harga;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String deleteBarang (int id) {
        try {
            url = URL + "?operasi=deleteBarang&idbarang=" + id;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
}
