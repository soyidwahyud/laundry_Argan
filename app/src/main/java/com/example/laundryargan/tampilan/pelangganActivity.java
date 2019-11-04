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
import com.example.laundryargan.tampilan.PelangganActivity2;
import com.example.laundryargan.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class pelangganActivity extends AppCompatActivity implements View.OnClickListener {
    PelangganActivity2 p = new PelangganActivity2();

    TableLayout tableLayout;
    Button buttonTambahPelanggan;
    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button>buttonDelete = new ArrayList<Button>();
    JSONArray arrayBiodata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelanggan);

        // Jika SDK Android diatas API Ver.9
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        // Mendapatkan data widget dari XML Activity melalui ID
        tableLayout = findViewById(R.id.tablePelanggan);
        buttonTambahPelanggan =findViewById(R.id.buttonTambahPelanggan);
        buttonTambahPelanggan.setOnClickListener(this);

        // Menambahkan baris untuk tabel
        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.CYAN);

        // Menambahkan tampilan teks untuk judul pada tabel
        TextView viewHeaderId = new TextView(this);
        TextView viewHeaderNama = new TextView(this);
        TextView viewHeaderAlamat = new TextView(this);
        TextView viewHeadernotelp = new TextView(this);
        TextView viewHeaderAction = new TextView(this);

        viewHeaderId.setText("ID");
        viewHeaderNama.setText("Nama");
        viewHeaderAlamat.setText("Alamat");
        viewHeadernotelp.setText("Nomor Telfon");
        viewHeaderAction.setText("Action");

        viewHeaderId.setPadding(5, 1, 5, 1);
        viewHeaderNama.setPadding(5, 1, 5, 1);
        viewHeaderAlamat.setPadding(5, 1, 5, 1);
        viewHeadernotelp.setPadding(5,1,5,1);
        viewHeaderAction.setPadding(5, 1, 5, 1);

        // Menampilkan tampilan TextView ke dalam tabel
        barisTabel.addView(viewHeaderId);
        barisTabel.addView(viewHeaderNama);
        barisTabel.addView(viewHeaderAlamat);
        barisTabel.addView(viewHeadernotelp);
        barisTabel.addView(viewHeaderAction);

        // Menyusun ukuran dari tabel
        tableLayout.addView(barisTabel, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));

        try {
            // Mengubah data dari BiodataActivity yang berupa String menjadi array
            arrayBiodata = new JSONArray(p.tampilPelanggan());
            for (int i = 0; i < arrayBiodata.length(); i++) {
                JSONObject jsonChildNode = arrayBiodata.getJSONObject(i);
                String nama = jsonChildNode.optString("nama");
                String alamat = jsonChildNode.optString("alamat");
                String notelp = jsonChildNode.optString("notelp");
                String id = jsonChildNode.optString("id");

                System.out.println("Nama         : " + nama );
                System.out.println("Alamat       : " + alamat);
                System.out.println("Nomor Telfon : " + notelp);
                System.out.println("ID           : " + id);

                barisTabel = new TableRow(this);

                // Memberi warna pada baris tabel
                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewId = new TextView(this);
                viewId.setText(id);
                viewId.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewId);

                TextView viewNama = new TextView(this);
                viewNama.setText(nama);
                viewNama.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewNama);

                TextView viewAlamat = new TextView(this);
                viewAlamat.setText(alamat);
                viewAlamat.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewAlamat);

                TextView viewnotelp = new TextView(this);
                viewnotelp.setText(notelp);
                viewnotelp.setPadding(5, 1, 5, 1);
                barisTabel.addView(viewnotelp);

                // Menambahkan button Edit
                buttonEdit.add(i, new Button(this));
                buttonEdit.get(i).setId(Integer.parseInt(id));
                buttonEdit.get(i).setTag("Edit");
                buttonEdit.get(i).setText("Edit");
                buttonEdit.get(i).setOnClickListener(this);
                barisTabel.addView(buttonEdit.get(i));

                // Menambahkan tombol Delete
                buttonDelete.add(i, new Button(this));
                buttonDelete.get(i).setId(Integer.parseInt(id));
                buttonDelete.get(i).setTag("Delete");
                buttonDelete.get(i).setText("Delete");
                buttonDelete.get(i).setOnClickListener(this);
                barisTabel.addView(buttonDelete.get(i));

                tableLayout.addView(barisTabel, new TableLayout.LayoutParams
                        (TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT));
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonTambahPelanggan) {
            tambahPelanggan();
        }
        else {
            for (int  i= 0; i < buttonEdit.size(); i++) {
                // Jika ingin mengedit data pada biodata
                if (v.getId() == buttonEdit.get(i).getId() && v.getTag().toString().trim().equals("Edit")) {
                    Toast.makeText(this, "Edit : " + buttonEdit.get(i).getId(), Toast.LENGTH_SHORT).show();
                    int id = buttonEdit.get(i).getId();
                    getDataByID(id);
                }
                // Menghapus data di Tabel
                else if (v.getId() == buttonDelete.get(i).getId() && v.getTag().toString().trim().equals("Delete")){
                    Toast.makeText(this, "Delete : " + buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
                    int id = buttonDelete.get(i).getId();
                    deleteBiodata(id);
                }
            }
        }
    }
    public void deleteBiodata (int id) {
        p.deleteBiodata(id);
        finish();
        startActivity(getIntent());
    }
    public void getDataByID (int id) {
        String namaEdit = null, alamatEdit = null, notelpEdit = null;
        JSONArray arrayPersonal;

        try {
            arrayPersonal = new JSONArray(p.getBiodataById(id));
            for (int i = 0; i < arrayPersonal.length(); i++) {
                JSONObject jsonChildNode = arrayPersonal.getJSONObject(i);
                namaEdit = jsonChildNode.optString("nama");
                alamatEdit = jsonChildNode.optString("alamat");
                notelpEdit = jsonChildNode.optString("notelp");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        LinearLayout layoutInput = new LinearLayout(this);
        layoutInput.setOrientation(LinearLayout.VERTICAL);

        // Membuat id tersembunyi pada AlertDialog
        final TextView viewId = new TextView(this);
        viewId.setText(String.valueOf(id));
        viewId.setTextColor(Color.TRANSPARENT);
        layoutInput.addView(viewId);



        final EditText editNama = new EditText(this);
        editNama.setText(namaEdit);
        layoutInput.addView(editNama);

        final EditText editAlamat = new EditText(this);
        editAlamat.setText(alamatEdit);
        layoutInput.addView(editAlamat);

        final EditText editNotelp = new EditText(this);
        editNotelp.setText(notelpEdit);
        layoutInput.addView(editNotelp);

        // Membuat AlertDialog untuk mengubah data di Biodata
        AlertDialog.Builder builderEditBiodata = new AlertDialog.Builder(this);
        builderEditBiodata.setIcon(R.drawable.ic_history_48px_512);
        builderEditBiodata.setTitle("Update Biodata");
        builderEditBiodata.setView(layoutInput);
        builderEditBiodata.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nama = editNama.getText().toString();
                String alamat = editAlamat.getText().toString();
                String notelp = editNotelp.getText().toString();
                System.out.println("Nama : " + nama + "Alamat : " + alamat + "Nomor telfon : " + notelp);

                String laporan = p.updateBiodata(viewId.getText().toString(), editNama.getText().toString(),
                        editAlamat.getText().toString(), editNotelp.getText().toString());

                Toast.makeText(pelangganActivity.this, laporan, Toast.LENGTH_SHORT).show();

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
    public void tambahPelanggan() {
        LinearLayout layoutInput = new LinearLayout(this);
        layoutInput.setOrientation(LinearLayout.VERTICAL);

        final EditText editNama = new EditText(this);
        editNama.setHint("Nama");
        layoutInput.addView(editNama);

        final EditText editAlamat = new EditText(this);
        editAlamat.setHint("Alamat");
        layoutInput.addView(editAlamat);

        final EditText editNotelp = new EditText(this);
        editAlamat.setHint("Nomor Telfon");
        layoutInput.addView(editNotelp);

        // Membuat AlertDialog untuk menambahkan data pada Biodata
        AlertDialog.Builder builderInsertBiodata= new AlertDialog.Builder(this);
        builderInsertBiodata.setIcon(R.drawable.ic_history_48px_512);
        builderInsertBiodata.setTitle("Insert Biodata");
        builderInsertBiodata.setView(layoutInput);
        builderInsertBiodata.setPositiveButton("Insert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nama = editNama.getText().toString();
                String alamat = editAlamat.getText().toString();
                String notelp = editNotelp.getText().toString();
                System.out.println("Nama : " + nama + "Alamat : " + alamat + "Nomor Telfon" + notelp);

                String laporan  =  p.insertPelanggan(nama, alamat,notelp);
                Toast.makeText(pelangganActivity.this, laporan, Toast.LENGTH_SHORT).show();

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