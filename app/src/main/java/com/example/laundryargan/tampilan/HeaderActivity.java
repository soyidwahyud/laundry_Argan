package com.example.laundryargan.tampilan;

import java.sql.Date;

public class HeaderActivity extends Koneksi {
    String URL = "http://192.168.66.144/proyek/server.php";
    String url = "";
    String response = "";

    public String tampilHeader() {
        try {
            url = URL + "?operasi=viewHeader";
            System.out.println("URL Tampil Header : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String insertHeader(int idpelanggan, Date tanggal_masuk,Date tanggalambil, int iduser) {
        try {
            url = URL + "?operasi=insertHeader&idpelanggan=" + idpelanggan + "&tanggal_masuk=" + tanggal_masuk + "&tanggalambil=" + tanggalambil + "&iduser=" + iduser;
            System.out.println("URL Insert Header : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return  response;
    }
    public String getHeaderById (int id) {
        try {
            url = URL + "?operasi=get_header_by_id&idtransaksi=" + id;
            System.out.println("URL Insert Header : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String updateHeader (int idpelanggan, Date tanggal_masuk,Date tanggalambil, int iduser, int idtransaksi) {
        try {
            url = URL + "?operasi=updateHeader&idtransaksi"+ idtransaksi + "&idpelanggan=" + idpelanggan + "&tanggal_masuk=" + tanggal_masuk + "&tanggalambil=" + tanggalambil + "&iduser"+ iduser;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String deleteHeader (int id) {
        try {
            url = URL + "?operasi=deleteHeader&idtransaksi=" + id;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
}
