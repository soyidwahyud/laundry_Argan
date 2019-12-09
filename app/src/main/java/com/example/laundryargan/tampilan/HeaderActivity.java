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
import android.widget.Toast;

import com.example.laundryargan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HeaderActivity extends AppCompatActivity implements View.OnClickListener{

    Header h = new Header();
    TableLayout tableLayout;
    Button buttonTambahHeader;
    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button>buttonDelete = new ArrayList<Button>();
    JSONArray arrayHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        // Jika SDK Android diatas API Ver.9
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        // Mendapatkan data widget dari XML Activity melalui ID
        tableLayout = (TableLayout) findViewById(R.id.tableHeader);
        //buttonTambahHeader = (Button) findViewById(R.id.buttonTambahHeader);
        //buttonTambahHeader.setOnClickListener(this);

        // Menambahkan baris untuk tabel
        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.WHITE);

        // Menambahkan tampilan teks untuk judul pada tabel
        TextView viewHeaderidtransaksi = new TextView(this);
        TextView viewHeadertanggal_masuk = new TextView(this);
        TextView viewHeadertanggalambil = new TextView(this);
        TextView viewHeadernama = new TextView(this);
        TextView viewHeadernama_pelanggan = new TextView(this);
        TextView viewHeaderAction = new TextView(this);

        viewHeaderidtransaksi.setText("ID");
        viewHeadertanggal_masuk.setText("Tanggal Masuk");
        viewHeadertanggalambil.setText("Tanggal Ambil");
        viewHeadernama.setText("Id Pelanggan");
        viewHeadernama_pelanggan.setText("Id User");
        viewHeaderAction.setText("Action");

        viewHeaderidtransaksi.setPadding(5, 1, 3, 1);
        viewHeadertanggal_masuk.setPadding(5, 1, 6, 1);
        viewHeadertanggalambil.setPadding(5, 1, 6, 1);
        viewHeadernama.setPadding(5, 1, 6, 1);
        viewHeadernama_pelanggan.setPadding(5, 1, 6, 1);
        viewHeaderAction.setPadding(5, 1, 6, 1);


        barisTabel.addView(viewHeaderidtransaksi);
        barisTabel.addView(viewHeadertanggal_masuk);
        barisTabel.addView(viewHeadertanggalambil);
        barisTabel.addView(viewHeadernama);
        barisTabel.addView(viewHeadernama_pelanggan);
        barisTabel.addView(viewHeaderAction);

        // Menyusun ukuran dari tabel
        tableLayout.addView(barisTabel, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

        try {
            // Mengubah data dari BiodataActivity yang berupa String menjadi array
            arrayHeader = new JSONArray(h.tampilHeader());
            for (int i = 0; i < arrayHeader.length(); i++) {
                JSONObject jsonChildNode = arrayHeader.getJSONObject(i);
                String idtransaksi = jsonChildNode.optString("idtransaksi");
                String tanggal_masuk = jsonChildNode.optString("tanggal_masuk");
                String tanggalambil = jsonChildNode.optString("tanggalambil");
                String nama = jsonChildNode.optString("idpelanggan");
                String nama_pelanggan = jsonChildNode.optString("iduser");

                System.out.println("ID Transaksi      : " + idtransaksi);
                System.out.println("Tanggal Masuk     : " + tanggal_masuk);
                System.out.println("Tanggal Ambil     : " + tanggalambil);
                System.out.println("Nama Karyawan     : " + nama);
                System.out.println("Nama Pelanggan    : " + nama_pelanggan);

                barisTabel = new TableRow(this);

                // Memberi warna pada baris tabel
                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewId = new TextView(this);
                viewId.setText(idtransaksi);
                viewId.setPadding(5, 1, 3, 1);
                barisTabel.addView(viewId);

                TextView viewtanggal_masuk = new TextView(this);
                viewtanggal_masuk.setText(tanggal_masuk);
                viewtanggal_masuk.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewtanggal_masuk);

                TextView viewtanggalambil = new TextView(this);
                viewtanggalambil.setText(tanggalambil);
                viewtanggalambil.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewtanggalambil);

                TextView viewNama = new TextView(this);
                viewNama.setText(nama);
                viewNama.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama);

                TextView viewNama_pel = new TextView(this);
                viewNama_pel.setText(nama_pelanggan);
                viewNama_pel.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama_pel);



                // Menambahkan button Edit
                //buttonEdit.add(i, new Button(this));
                //buttonEdit.get(i).setId(Integer.parseInt(idtransaksi));
                //buttonEdit.get(i).setTag("Edit");
                //buttonEdit.get(i).setText("Edit");
                //buttonEdit.get(i).setOnClickListener(this);
                //barisTabel.addView(buttonEdit.get(i));

                // Menambahkan tombol Delete
                buttonDelete.add(i, new Button(this));
                buttonDelete.get(i).setId(Integer.parseInt(idtransaksi));
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
    public void deleteHeader (int idtransaksi) {
        h.deleteHeader(idtransaksi);
        finish();
        startActivity(getIntent());
    }
    public void onClick (View view) {
        for (int  i= 0; i < buttonDelete.size(); i++) {
            if (view.getId() == buttonDelete.get(i).getId() && view.getTag().toString().trim().equals("Delete")){
                Toast.makeText(HeaderActivity.this, "Delete : " + buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
                int id = buttonDelete.get(i).getId();
                deleteHeader(id);
            }
        }

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
