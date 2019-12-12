package com.example.laundryargan.tampilan;

import com.example.laundryargan.util.Server;

public class Barang extends Koneksi{
    String URL = Server.URL +  "server2.php";
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
    public String insertBarang(String selimut, String sprei) {
        try {
            url = URL + "?operasi=insertBarang&selimut=" + selimut + "&sprei=" + sprei;
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
    public String updateBarang (String id, String selimut, String sprei) {
        try {
            url = URL + "?operasi=updateBarang&idbarang=" + id + "&selimut=" + selimut + "&sprei=" + sprei;
            System.out.println("URL Update Pelanggan : " + url);
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
