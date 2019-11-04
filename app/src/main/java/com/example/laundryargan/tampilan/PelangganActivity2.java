package com.example.laundryargan.tampilan;



public class PelangganActivity2 extends Koneksi {
    String URL = "http://192.168.66.144/proyek/server.php";
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
            url = URL + "?operasi=insert&nama_pelanggan=" + nama + "&alamat=" + alamat + "&notelp=" + notelp;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return  response;
    }
    public String getBiodataById (int id) {
        try {
            url = URL + "?operasi=get_biodata_by_id&idpelanggan=" + id;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String updateBiodata (String id, String nama, String alamat,String notelp) {
        try {
            url = URL + "?operasi=update&idpelanggan=" + id + "&nama_pelanggan=" + nama + "&alamat=" + alamat+ "&notelp"+ notelp;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String deleteBiodata (int id) {
        try {
            url = URL + "?operasi=delete&idpelanggan=" + id;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
}
