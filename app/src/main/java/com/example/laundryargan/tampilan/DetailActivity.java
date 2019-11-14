package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.laundryargan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{
    Detail d = new Detail();
    TableLayout tableLayout;
    //Button buttonTambahDetail;
    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button>buttonDelete = new ArrayList<Button>();
    JSONArray arrayDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Jika SDK Android diatas API Ver.9
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        // Mendapatkan data widget dari XML Activity melalui ID
        tableLayout = (TableLayout) findViewById(R.id.tableDetail);
        //buttonTambahDetail = (Button) findViewById(R.id.buttonTambahDetail);
        //buttonTambahDetail.setOnClickListener(this);

        // Menambahkan baris untuk tabel
        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.WHITE);

        // Menambahkan tampilan teks untuk judul pada tabel
        TextView viewHeaderiddetail = new TextView(this);
        TextView viewHeadernama = new TextView(this);
        TextView viewHeadertanggal_masuk = new TextView(this);
        TextView viewHeadertanggalambil = new TextView(this);
        TextView viewHeadernama_pelanggan = new TextView(this);
        TextView viewHeaderalamat = new TextView(this);
        TextView viewHeadernotelp = new TextView(this);
        TextView viewHeadernamabarang = new TextView(this);
        TextView viewHeaderjumlah = new TextView(this);
        TextView viewHeaderberatbaju = new TextView(this);
        TextView viewHeaderpdalam = new TextView(this);
        TextView viewHeadertotal = new TextView(this);
        TextView viewHeaderAction = new TextView(this);

        viewHeaderiddetail.setText("ID");
        viewHeadernama.setText("Nama Karyawan");
        viewHeadertanggal_masuk.setText("Tanggal Masuk");
        viewHeadertanggalambil.setText("Tanggal Ambil");
        viewHeadernama_pelanggan.setText("Nama Pelanggan");
        viewHeaderalamat.setText("Alamat");
        viewHeadernotelp.setText("Nomor Telfon");
        viewHeadernamabarang.setText("Nama Barang");
        viewHeaderjumlah.setText("Jumlah");
        viewHeaderberatbaju.setText("Berat Baju");
        viewHeaderpdalam.setText("Pakaian Dalam");
        viewHeadertotal.setText("Total");
        viewHeaderAction.setText("Action");

        viewHeaderiddetail.setPadding(5, 1, 6, 1);
        viewHeadernama.setPadding(5, 1, 6, 1);
        viewHeadertanggal_masuk.setPadding(5, 1, 6, 1);
        viewHeadertanggalambil.setPadding(5, 1, 6, 1);
        viewHeadernama_pelanggan.setPadding(5, 1, 6, 1);
        viewHeaderalamat.setPadding(5, 1, 6, 1);
        viewHeadernotelp.setPadding(5, 1, 6, 1);
        viewHeadernamabarang.setPadding(5, 1, 6, 1);
        viewHeaderjumlah.setPadding(5, 1, 6, 1);
        viewHeaderberatbaju.setPadding(5, 1, 6, 1);
        viewHeaderpdalam.setPadding(5, 1, 6, 1);
        viewHeadertotal.setPadding(5, 1, 6, 1);
        viewHeaderAction.setPadding(5, 1, 6, 1);

        barisTabel.addView(viewHeaderiddetail);
        barisTabel.addView(viewHeadernama);
        barisTabel.addView(viewHeadertanggal_masuk);
        barisTabel.addView(viewHeadertanggalambil);
        barisTabel.addView(viewHeadernama_pelanggan);
        barisTabel.addView(viewHeaderalamat);
        barisTabel.addView(viewHeadernotelp);
        barisTabel.addView(viewHeadernamabarang);
        barisTabel.addView(viewHeaderjumlah);
        barisTabel.addView(viewHeaderberatbaju);
        barisTabel.addView(viewHeaderpdalam);
        barisTabel.addView(viewHeadertotal);
        barisTabel.addView(viewHeaderAction);

        // Menyusun ukuran dari tabel
        tableLayout.addView(barisTabel, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

        try {
            // Mengubah data dari BiodataActivity yang berupa String menjadi array
            arrayDetail = new JSONArray(d.tampilDetail());
            for (int i = 0; i < arrayDetail.length(); i++) {
                JSONObject jsonChildNode = arrayDetail.getJSONObject(i);
                String iddetail = jsonChildNode.optString("iddetail");
                String nama = jsonChildNode.optString("nama");
                String tanggal_masuk = jsonChildNode.optString("tanggal_masuk");
                String tanggalambil = jsonChildNode.optString("tanggalambil");
                String nama_pelanggan = jsonChildNode.optString("nama_pelanggan");
                String alamat = jsonChildNode.optString("alamat");
                String notelp = jsonChildNode.optString("notelp");
                String namabarang = jsonChildNode.optString("namabarang");
                String jumlah = jsonChildNode.optString("jumlah");
                String beratbaju = jsonChildNode.optString("beratbaju");
                String pdalam = jsonChildNode.optString("pdalam");
                String total = jsonChildNode.optString("total");

                System.out.println("ID Transaksi      : " + iddetail);
                System.out.println("Tanggal Masuk     : " + tanggal_masuk);
                System.out.println("Tanggal Ambil     : " + tanggalambil);
                System.out.println("Nama Karyawan     : " + nama);
                System.out.println("Nama Pelanggan    : " + nama_pelanggan);
                System.out.println("Alamat            : " + alamat);
                System.out.println("Nomor Telfon      : " + notelp);
                System.out.println("Nama Barang       : " + namabarang);
                System.out.println("jumlah            : " + jumlah);
                System.out.println("beratbaju         : " + beratbaju);
                System.out.println("pdalam            : " + pdalam);
                System.out.println("total             : " + total);

                barisTabel = new TableRow(this);

                // Memberi warna pada baris tabel
                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewId = new TextView(this);
                viewId.setText(iddetail);
                viewId.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewId);

                TextView viewNama = new TextView(this);
                viewNama.setText(nama);
                viewNama.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama);

                TextView viewtanggal_masuk = new TextView(this);
                viewtanggal_masuk.setText(tanggal_masuk);
                viewtanggal_masuk.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewtanggal_masuk);

                TextView viewtanggalambil = new TextView(this);
                viewtanggalambil.setText(tanggalambil);
                viewtanggalambil.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewtanggalambil);


                TextView viewNama_pel = new TextView(this);
                viewNama_pel.setText(nama_pelanggan);
                viewNama_pel.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama_pel);

                TextView viewAlamat = new TextView(this);
                viewAlamat.setText(alamat);
                viewAlamat.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewAlamat);

                TextView viewNotelp = new TextView(this);
                viewNotelp.setText(notelp);
                viewNotelp.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNotelp);

                TextView viewNamabarang = new TextView(this);
                viewNamabarang.setText(namabarang);
                viewNamabarang.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNamabarang);

                TextView viewjumlah = new TextView(this);
                viewjumlah.setText(jumlah);
                viewjumlah.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewjumlah);

                TextView viewberatbaju = new TextView(this);
                viewberatbaju.setText(beratbaju);
                viewberatbaju.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewberatbaju);

                TextView viewpdalam = new TextView(this);
                viewpdalam.setText(pdalam);
                viewpdalam.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewpdalam);

                TextView viewtotal = new TextView(this);
                viewtotal.setText(total);
                viewtotal.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewtotal);

                // Menambahkan button Edit
                //buttonEdit.add(i, new Button(this));
                //buttonEdit.get(i).setId(Integer.parseInt(iddetail));
                //buttonEdit.get(i).setTag("Edit");
                //buttonEdit.get(i).setText("Edit");
                //buttonEdit.get(i).setOnClickListener(this);
                //barisTabel.addView(buttonEdit.get(i));

                // Menambahkan tombol Delete
                buttonDelete.add(i, new Button(this));
                buttonDelete.get(i).setId(Integer.parseInt(iddetail));
                buttonDelete.get(i).setTag("Delete");
                buttonDelete.get(i).setText("Delete");
                buttonDelete.get(i).setOnClickListener(this);
                barisTabel.addView(buttonDelete.get(i));

                tableLayout.addView(barisTabel, new TableLayout.LayoutParams
                        (TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void onClick (View view) {
        /*if (view.getId() == R.id.buttonTambahBarang) {
            tambahBarang();
        }
        else {
            for (int  i= 0; i < buttonEdit.size(); i++) {
                // Jika ingin mengedit data pada biodata
                if (view.getId() == buttonEdit.get(i).getId() && view.getTag().toString().trim().equals("Edit")) {
                    Toast.makeText(BarangActivity.this, "Edit : " + buttonEdit.get(i).getId(), Toast.LENGTH_SHORT).show();
                    int id = buttonEdit.get(i).getId();
                    getDataByID(id);
                }
                // Menghapus data di Tabel
                else if (view.getId() == buttonDelete.get(i).getId() && view.getTag().toString().trim().equals("Delete")){
                    Toast.makeText(BarangActivity.this, "Delete : " + buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
                    int id = buttonDelete.get(i).getId();
                    deleteBarang(id);
                }
            }
        }*/
    }
}
