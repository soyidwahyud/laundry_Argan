package com.example.laundryargan.tampilan;

import java.sql.Date;

public class DetailActivity extends Koneksi {
    String URL = "http://192.168.66.144/proyek/server.php";
    String url = "";
    String response = "";

    public String tampilDetail() {
        try {
            url = URL + "?operasi=viewDetail";
            System.out.println("URL Tampil Detail : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String insertDetail(int idbarang, int jumlah, float beratbaju, int pdalam, int idtransaksi, int harga) {
        try {
            url = URL + "?operasi=insertDetail&idbarang=" + idbarang + "&jumlah=" + jumlah + "&beratbaju=" + beratbaju + "&pdalam=" + pdalam+ "&idtransaksi=" + idtransaksi+ "&harga=" + harga;
            System.out.println("URL Insert Detail : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return  response;
    }
    public String getDetailById (int id) {
        try {
            url = URL + "?operasi=get_Detail_by_id&iddetail=" + id;
            System.out.println("URL Insert Detail : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String updateDetail (int iddetail,int idbarang, int jumlah, float beratbaju, int pdalam, int idtransaksi, int harga) {
        try {
            url = URL + "?operasi=updateDetail&iddetail"+ iddetail + "&idbarang=" + idbarang + "&jumlah=" + jumlah + "&beratbaju=" + beratbaju + "&pdalam"+ pdalam + "&idtransaksi"+ idtransaksi + "&harga"+ harga;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String deleteDetail (int id) {
        try {
            url = URL + "?operasi=deleteDetail&iddetail=" + id;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
}
