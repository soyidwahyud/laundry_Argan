package com.example.laundryargan.tampilan;

public class User extends Koneksi {
    String URL = "http://192.168.65.93/proyek/server5.php";
    String url = "";
    String response = "";

    public String tampilUser() {
        try {
            url = URL + "?operasi=viewUser";
            System.out.println("URL Tampil Detail : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String insertUser(String iduser, String username,String password, String nama) {
        try {
            url = URL + "?operasi=insertUser&iduser=" + iduser + "&username=" + username + "&password=" + password + "&nama=" +nama;
            System.out.println("URL Insert User : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return  response;
    }
    public String getUserById (int id) {
        try {
            url = URL + "?operasi=get_user_by_id&iduser=" + id;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String updateUser (String iduser, String username, String password,String nama) {
        try {
            url = URL + "?operasi=updateUser&iduser=" + iduser + "&username=" + username + "&password=" + password + "&nama=" + nama;
            System.out.println("URL Insert Pelanggan : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
    public String deleteUser (int id) {
        try {
            url = URL + "?operasi=deleteUser&iduser=" + id;
            System.out.println("URL Insert Biodata : " + url);
            response = call(url);
        }
        catch (Exception e) {
        }
        return response;
    }
}
