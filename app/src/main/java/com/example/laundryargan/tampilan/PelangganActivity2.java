package com.example.laundryargan.tampilan;

public class PelangganActivity2 extends Koneksi {
    String URL = "http://192.168.10.162/proyek/server.php";
    String url = "";
    String response = "";

    public String tampilPelanggan() {
        try {
            url = URL + "?operasi=view";
            System.out.println("URL Tampil Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String insertPelanggan(String nama, String alamat, String notelp) {
        try {
            url = URL + "?operasi=insertPelanggan&nama_pelanggan=" + nama + "&alamat=" + alamat + "&notelp=" + notelp;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return  response;
    }
    public String getBiodataById (int id) {
        try {
            url = URL + "?operasi=get_pelanggan_by_id&idpelanggan=" + id;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String updateBiodata (String id, String nama, String alamat,String notelp) {
        try {
            url = URL + "?operasi=updatePelanggan&idpelanggan=" + id + "&nama_pelanggan=" + nama + "&alamat=" + alamat+ "&notelp="+ notelp;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String deleteBiodata (int id) {
        try {
            url = URL + "?operasi=deletePelanggan&idpelanggan=" + id;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
}
