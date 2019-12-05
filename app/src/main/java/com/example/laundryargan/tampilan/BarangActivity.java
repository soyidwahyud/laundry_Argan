package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laundryargan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BarangActivity extends AppCompatActivity implements View.OnClickListener{

    Barang b = new Barang();
    TableLayout tableLayout;
    Button buttonTambahBarang;
    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button>buttonDelete = new ArrayList<Button>();
    JSONArray arrayBiodata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang);


        // Jika SDK Android diatas API Ver.9
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        // Mendapatkan data widget dari XML Activity melalui ID
        tableLayout = (TableLayout) findViewById(R.id.tableBarang);
        buttonTambahBarang = (Button) findViewById(R.id.buttonTambahBarang);
        buttonTambahBarang.setOnClickListener(this);

        // Menambahkan baris untuk tabel
        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.WHITE);

        // Menambahkan tampilan teks untuk judul pada tabel
        TextView viewHeaderidbarang = new TextView(this);
        TextView viewHeadernama_barang = new TextView(this);
        TextView viewHeaderharga = new TextView(this);
        TextView viewHeadernama_barang2 = new TextView(this);
        TextView viewHeaderharga2 = new TextView(this);
        TextView viewHeadernama_barang3 = new TextView(this);
        TextView viewHeaderharga3 = new TextView(this);
        TextView viewHeaderAction = new TextView(this);

        viewHeaderidbarang.setText("ID");
        viewHeadernama_barang.setText("Nama Barang 1");
        viewHeaderharga.setText("Harga 1");
        viewHeadernama_barang2.setText("Nama Barang 2");
        viewHeaderharga2.setText("Harga 2");
        viewHeadernama_barang3.setText("Nama Barang 3");
        viewHeaderharga3.setText("Harga 3");
        viewHeaderAction.setText("Action");

        viewHeaderidbarang.setPadding(5, 1, 6, 1);
        viewHeadernama_barang.setPadding(5, 1, 6, 1);
        viewHeaderharga.setPadding(5, 1, 6, 1);
        viewHeadernama_barang2.setPadding(5, 1, 6, 1);
        viewHeaderharga2.setPadding(5, 1, 6, 1);
        viewHeadernama_barang3.setPadding(5, 1, 6, 1);
        viewHeaderharga3.setPadding(5, 1, 6, 1);
        viewHeaderAction.setPadding(5, 1, 6, 1);

        barisTabel.addView(viewHeaderidbarang);
        barisTabel.addView(viewHeadernama_barang);
        barisTabel.addView(viewHeaderharga);
        barisTabel.addView(viewHeadernama_barang2);
        barisTabel.addView(viewHeaderharga2);
        barisTabel.addView(viewHeadernama_barang3);
        barisTabel.addView(viewHeaderharga3);
        barisTabel.addView(viewHeaderAction);

        // Menyusun ukuran dari tabel
        tableLayout.addView(barisTabel, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

        try {
            // Mengubah data dari BiodataActivity yang berupa String menjadi array
            arrayBiodata = new JSONArray(b.tampilBarang());
            for (int i = 0; i < arrayBiodata.length(); i++) {
                JSONObject jsonChildNode = arrayBiodata.getJSONObject(i);
                String idbarang = jsonChildNode.optString("idbarang");
                String namabarang = jsonChildNode.optString("namabarang");
                String harga = jsonChildNode.optString("harga");
                String namabarang2 = jsonChildNode.optString("namabarang2");
                String harga2 = jsonChildNode.optString("harga2");
                String namabarang3 = jsonChildNode.optString("namabarang3");
                String harga3 = jsonChildNode.optString("harga3");

                System.out.println("ID      : " + idbarang);
                System.out.println("Nama    : " + namabarang);
                System.out.println("Harga   : " + harga);
                System.out.println("Nama2    : " + namabarang2);
                System.out.println("Harga2   : " + harga2);
                System.out.println("Nama3    : " + namabarang3);
                System.out.println("Harga3   : " + harga3);

                barisTabel = new TableRow(this);

                // Memberi warna pada baris tabel
                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewId = new TextView(this);
                viewId.setText(idbarang);
                viewId.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewId);

                TextView viewNama = new TextView(this);
                viewNama.setText(namabarang);
                viewNama.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama);

                TextView viewHarga = new TextView(this);
                viewHarga.setText(harga);
                viewHarga.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewHarga);

                TextView viewNama2 = new TextView(this);
                viewNama2.setText(namabarang2);
                viewNama2.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama2);

                TextView viewHarga2 = new TextView(this);
                viewHarga2.setText(harga2);
                viewHarga2.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewHarga2);

                TextView viewNama3= new TextView(this);
                viewNama3.setText(namabarang3);
                viewNama3.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama3);

                TextView viewHarga3 = new TextView(this);
                viewHarga3.setText(harga3);
                viewHarga3.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewHarga3);


                // Menambahkan button Edit
                buttonEdit.add(i, new Button(this));
                buttonEdit.get(i).setId(Integer.parseInt(idbarang));
                buttonEdit.get(i).setTag("Edit");
                buttonEdit.get(i).setText("Edit");
                buttonEdit.get(i).setOnClickListener(this);
                barisTabel.addView(buttonEdit.get(i));

                // Menambahkan tombol Delete
                buttonDelete.add(i, new Button(this));
                buttonDelete.get(i).setId(Integer.parseInt(idbarang));
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
        if (view.getId() == R.id.buttonTambahBarang) {
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
        }
    }
    public void deleteBarang (int idbarang) {
        b.deleteBarang(idbarang);
        finish();
        startActivity(getIntent());
    }

    // Mendapatkan Biodata melalui ID
    public void getDataByID (int idbarang) {
        String namaEdit = null;
        String hargaEdit = null;
        String namaEdit2 = null;
        String hargaEdit2 = null;
        String namaEdit3 = null;
        String hargaEdit3 = null;
        JSONArray arrayPersonal;

        try {
            arrayPersonal = new JSONArray(b.getBiodataById(idbarang));
            for (int i  = 0; i < arrayPersonal.length(); i++) {
                JSONObject jsonChildNode = arrayPersonal.getJSONObject(i);
                namaEdit = jsonChildNode.optString("namabarang");
                hargaEdit = jsonChildNode.optString("harga");
                namaEdit2 = jsonChildNode.optString("namabarang2");
                hargaEdit2 = jsonChildNode.optString("harga2");
                namaEdit3 = jsonChildNode.optString("namabarang3");
                hargaEdit3 = jsonChildNode.optString("harga3");
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        LinearLayout layoutInput = new LinearLayout(this);
        layoutInput.setOrientation(LinearLayout.VERTICAL);

        // Membuat id tersembunyi pada AlertDialog
        final TextView viewId = new TextView(this);
        viewId.setText(String.valueOf(idbarang));
        viewId.setTextColor(Color.TRANSPARENT);
        layoutInput.addView(viewId);

        final EditText editNama = new EditText(this);
        editNama.setText(namaEdit);
        layoutInput.addView(editNama);

        final EditText editHarga = new EditText(this);
        editHarga.setText(hargaEdit);
        layoutInput.addView(editHarga);

        final EditText editNama2 = new EditText(this);
        editNama2.setText(namaEdit2);
        layoutInput.addView(editNama2);

        final EditText editHarga2 = new EditText(this);
        editHarga2.setText(hargaEdit2);
        layoutInput.addView(editHarga2);

        final EditText editNama3 = new EditText(this);
        editNama3.setText(namaEdit3);
        layoutInput.addView(editNama3);

        final EditText editHarga3 = new EditText(this);
        editHarga3.setText(hargaEdit3);
        layoutInput.addView(editHarga3);


        // Membuat AlertDialog untuk mengubah data di Biodata
        AlertDialog.Builder builderEditBiodata = new AlertDialog.Builder(this);
        builderEditBiodata.setIcon(R.drawable.refresh);
        builderEditBiodata.setTitle("Update Barang");
        builderEditBiodata.setView(layoutInput);
        builderEditBiodata.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nama = editNama.getText().toString();
                String harga = editHarga.getText().toString();
                String nama2 = editNama2.getText().toString();
                String harga2 = editHarga2.getText().toString();
                String nama3 = editNama3.getText().toString();
                String harga3 = editHarga3.getText().toString();
                System.out.println("Nama : " + nama + "Harga : " + harga + "Nama2 : " + nama2 + "Harga 2 : " +harga2 + "Nama 3 : " + nama3 + " Harga 3 : " + harga3);

                String laporan = b.updateBarang(viewId.getText().toString(), editNama.getText().toString(),
                        editHarga.getText().toString(),editNama2.getText().toString(),editHarga2.getText().toString(),
                        editNama3.getText().toString(),editHarga3.getText().toString());

                Toast.makeText(BarangActivity.this, laporan, Toast.LENGTH_SHORT).show();

                finish();
                startActivity(getIntent());
            }
        });

        // Jika tidak ingin mengubah data pada Biodata
        builderEditBiodata.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builderEditBiodata.show();
    }

    public void tambahBarang() {
        LinearLayout layoutInput = new LinearLayout(this);
        layoutInput.setOrientation(LinearLayout.VERTICAL);

        final EditText editNama = new EditText(this);
        editNama.setHint("Nama");
        layoutInput.addView(editNama);

        final EditText editHarga = new EditText(this);
        editHarga.setHint("Harga");
        layoutInput.addView(editHarga);

        final EditText editNama2 = new EditText(this);
        editNama2.setHint("Nama 2");
        layoutInput.addView(editNama2);

        final EditText editHarga2 = new EditText(this);
        editHarga2.setHint("Harga 2");
        layoutInput.addView(editHarga2);

        final EditText editNama3 = new EditText(this);
        editNama3.setHint("Nama 3");
        layoutInput.addView(editNama3);

        final EditText editHarga3 = new EditText(this);
        editHarga3.setHint("Harga 3");
        layoutInput.addView(editHarga3);


        // Membuat AlertDialog untuk menambahkan data pada Biodata
        AlertDialog.Builder builderInsertBiodata= new AlertDialog.Builder(this);
        builderInsertBiodata.setIcon(R.drawable.input);
        builderInsertBiodata.setTitle("Insert Barang");
        builderInsertBiodata.setView(layoutInput);
        builderInsertBiodata.setPositiveButton("Insert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nama = editNama.getText().toString();
                String harga = editHarga.getText().toString();
                String nama2 = editNama2.getText().toString();
                String harga2 = editHarga2.getText().toString();
                String nama3 = editNama3.getText().toString();
                String harga3 = editHarga3.getText().toString();
                System.out.println("Nama : " + nama + "Harga : " + harga + "Nama2 : " + nama2 + "Harga 2 : " +harga2 + "Nama 3 : " + nama3 + " Harga 3 : " + harga3);

                String laporan  = b.insertBarang(nama, harga, nama2,harga2,nama3,harga3);
                Toast.makeText(BarangActivity.this, laporan, Toast.LENGTH_SHORT).show();

                finish();
                startActivity(getIntent());
            }
        });

        builderInsertBiodata.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builderInsertBiodata.show();
    }
}
