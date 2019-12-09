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
        TextView viewHeaderSelimut = new TextView(this);
        TextView viewHeaderSprei = new TextView(this);
        TextView viewHeaderAction = new TextView(this);
        viewHeaderidbarang.setText("ID");
        viewHeaderSelimut.setText("Selimut");
        viewHeaderSprei.setText("Sprei/Bedcover");
        viewHeaderAction.setText("Action");

        viewHeaderidbarang.setPadding(5, 1, 6, 1);
        viewHeaderSelimut.setPadding(5, 1, 6, 1);
        viewHeaderSprei.setPadding(5, 1, 6, 1);
        viewHeaderAction.setPadding(5, 1, 6, 1);

        barisTabel.addView(viewHeaderidbarang);
        barisTabel.addView(viewHeaderSelimut);
        barisTabel.addView(viewHeaderSprei);
        barisTabel.addView(viewHeaderAction);

        // Menyusun ukuran dari tabel
        tableLayout.addView(barisTabel, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

        try {
            // Mengubah data dari BiodataActivity yang berupa String menjadi array
            arrayBiodata = new JSONArray(b.tampilBarang());
            for (int i = 0; i < arrayBiodata.length(); i++) {
                JSONObject jsonChildNode = arrayBiodata.getJSONObject(i);
                String idbarang = jsonChildNode.optString("idbarang");
                String selimut = jsonChildNode.optString("selimut");
                String sprei = jsonChildNode.optString("sprei");

                System.out.println("ID                  : " + idbarang);
                System.out.println("Selimut             : " + selimut);
                System.out.println("Sprei/Bedcover      : " + sprei);

                barisTabel = new TableRow(this);

                // Memberi warna pada baris tabel
                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewId = new TextView(this);
                viewId.setText(idbarang);
                viewId.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewId);

                TextView viewSelimut = new TextView(this);
                viewSelimut.setText(selimut);
                viewSelimut.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewSelimut);

                TextView viewSprei = new TextView(this);
                viewSprei.setText(sprei);
                viewSprei.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewSprei);

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
        String selimutEdit = null;
        String spreiEdit = null;
        JSONArray arrayPersonal;

        try {
            arrayPersonal = new JSONArray(b.getBiodataById(idbarang));
            for (int i  = 0; i < arrayPersonal.length(); i++) {
                JSONObject jsonChildNode = arrayPersonal.getJSONObject(i);
                selimutEdit = jsonChildNode.optString("selimut");
                spreiEdit = jsonChildNode.optString("sprei");

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

        final EditText editSelimut = new EditText(this);
        editSelimut.setText(selimutEdit);
        layoutInput.addView(editSelimut);

        final EditText editSprei = new EditText(this);
        editSprei.setText(spreiEdit);
        layoutInput.addView(editSprei);



        // Membuat AlertDialog untuk mengubah data di Biodata
        AlertDialog.Builder builderEditBiodata = new AlertDialog.Builder(this);
        builderEditBiodata.setIcon(R.drawable.refresh);
        builderEditBiodata.setTitle("Update Barang");
        builderEditBiodata.setView(layoutInput);
        builderEditBiodata.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selimut = editSelimut.getText().toString();
                String sprei = editSprei.getText().toString();

                System.out.println("Selimut : " + selimut + " Sprei/Bedcover : " + sprei);

                String laporan = b.updateBarang(viewId.getText().toString(), editSelimut.getText().toString(),
                        editSprei.getText().toString());

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

        final EditText editSelimut = new EditText(this);
        editSelimut.setHint("Selimut");
        layoutInput.addView(editSelimut);

        final EditText editSprei = new EditText(this);
        editSprei.setHint("Sprei/Bedcover");
        layoutInput.addView(editSprei);


        // Membuat AlertDialog untuk menambahkan data pada Biodata
        AlertDialog.Builder builderInsertBiodata= new AlertDialog.Builder(this);
        builderInsertBiodata.setIcon(R.drawable.input);
        builderInsertBiodata.setTitle("Insert Barang");
        builderInsertBiodata.setView(layoutInput);
        builderInsertBiodata.setPositiveButton("Insert", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String selimut = editSelimut.getText().toString();
                String sprei = editSprei.getText().toString();
                System.out.println("Selimut : " + selimut + "Sprei/Bedcover : " + sprei);

                String laporan  = b.insertBarang(selimut, sprei);
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
