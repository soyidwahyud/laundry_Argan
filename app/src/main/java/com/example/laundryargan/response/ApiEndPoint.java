package com.example.laundryargan.response;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiEndPoint {
    @FormUrlEncoded
    @POST("read.php")
    Call<ReadResponse> readRequest(@Field("key") String key);

    @FormUrlEncoded
    @POST("readPelanggan.php")
    Call<ReadResponse> readPelangganRequest(@Field("key") String key,@Field("idpelanggan") int id);

    @FormUrlEncoded
    @POST("readBarang.php")
    Call<ReadResponse> readBarangRequest(@Field("key") String key,@Field("idbarang") int id);

    @FormUrlEncoded
    @POST("readHeader.php")
    Call<ReadResponse> readHeaderRequest(@Field("key") String key,@Field("idtransaksi") int id);

    @FormUrlEncoded
    @POST("readDetail.php")
    Call<ReadResponse> readDetailRequest(@Field("key") String key,@Field("iddetail") int id);

    @FormUrlEncoded
    @POST("createPelanggan.php")
    Call<statusResponse> createPelangganRequest(@Field("nama") String nama,
                                              @Field("alamat")String alamat,
                                              @Field("notelp")String notelp);

    @FormUrlEncoded
    @POST("createBarang.php")
    Call<statusResponse> createBarangRequest(@Field("idbarang") int idbarang,
                                           @Field("namabarang")String namabarang,
                                           @Field("harga")int notelp);

    @FormUrlEncoded
    @POST("createHeader.php")
    Call<statusResponse> createHeaderRequest(@Field("idpelanggan") int idpelanggan,
                                           @Field("tanggal_masuk") Date tanggal_masuk,
                                           @Field("tanggalambil")Date tanggalambil,
                                           @Field("iduser")int iduser);

    @FormUrlEncoded
    @POST("createDetail.php")
    Call<statusResponse> createDetailRequest(@Field("idbarang") int idbarang,
                                           @Field("jumlah")int jumlah,
                                           @Field("beratbaju")float beratbaju,
                                           @Field("pdalam")int pdalam,
                                           @Field("idtransaksi")int idtransaksi);

    @FormUrlEncoded
    @POST("updatePelanggan.php")
    Call<statusResponse> updatePelangganRequest(@Field("idpelanggan")int idpelanggan,
                                              @Field("nama") String nama,
                                              @Field("alamat")String alamat,
                                              @Field("notelp")String notelp);

    @FormUrlEncoded
    @POST("updateBarang.php")
    Call<statusResponse> updateBarangRequest(@Field("idbarang") int idbarang,
                                           @Field("namabarang")String namabarang,
                                           @Field("harga")int notelp);

    @FormUrlEncoded
    @POST("updateHeader.php")
    Call<statusResponse> updateHeaderRequest(@Field("idtransaksi") int idtransaksi,
                                           @Field("idpelanggan") int idpelanggan,
                                           @Field("tanggal_masuk") Date tanggal_masuk,
                                           @Field("tanggalambil")Date tanggalambil,
                                           @Field("iduser")int iduser);

    @FormUrlEncoded
    @POST("updateDetail.php")
    Call<statusResponse> updateDetailRequest(@Field("iddetail") int iddetail,
                                           @Field("idbarang") int idbarang,
                                           @Field("jumlah")int jumlah,
                                           @Field("beratbaju")float beratbaju,
                                           @Field("pdalam")int pdalam,
                                           @Field("idtransaksi")int idtransaksi);

    @FormUrlEncoded
    @POST("deletePelanggan.php")
    Call<statusResponse> deletePelangganRequest(@Field("idpelanggan") int idpelanggan);

    @FormUrlEncoded
    @POST("deleteBarang.php")
    Call<statusResponse> deleteBarangRequest(@Field("idbarang") int idbarang);

    @FormUrlEncoded
    @POST("deleteHeader.php")
    Call<statusResponse> deleteHeaderRequest(@Field("idtransaksi") int idtransaksi);

    @FormUrlEncoded
    @POST("deleteDetail.php")
    Call<statusResponse> deleteDetailRequest(@Field("iddetail") int iddetail);
}
