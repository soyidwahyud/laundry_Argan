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

public class UserActivity extends AppCompatActivity implements View.OnClickListener{
    User u = new User();
    TableLayout tableLayout;

    ArrayList<Button> buttonEdit = new ArrayList<Button>();
    ArrayList<Button>buttonDelete = new ArrayList<Button>();
    JSONArray arrayUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Jika SDK Android diatas API Ver.9
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        // Menambahkan baris untuk tabel
        TableRow barisTabel = new TableRow(this);
        barisTabel.setBackgroundColor(Color.WHITE);

        tableLayout = (TableLayout) findViewById(R.id.tableUser);

        // Menambahkan tampilan teks untuk judul pada tabel
        TextView viewHeaderiduser = new TextView(this);
        TextView viewHeaderusername = new TextView(this);
        TextView viewHeadernama = new TextView(this);
        TextView viewHeaderAction = new TextView(this);

        viewHeaderiduser.setText("ID");
        viewHeaderusername.setText("username");
        viewHeadernama.setText("Nama Karyawan");
        viewHeaderAction.setText("Action");

        viewHeaderiduser.setPadding(5, 1, 6, 1);
        viewHeaderusername.setPadding(5, 1, 6, 1);
        viewHeadernama.setPadding(5, 1, 6, 1);
        viewHeaderAction.setPadding(5, 1, 6, 1);

        barisTabel.addView(viewHeaderiduser);
        barisTabel.addView(viewHeaderusername);
        barisTabel.addView(viewHeadernama);
        barisTabel.addView(viewHeaderAction);

        // Menyusun ukuran dari tabel
        tableLayout.addView(barisTabel, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

        try {
            // Mengubah data dari BiodataActivity yang berupa String menjadi array
            arrayUser = new JSONArray(u.tampilUser());
            for (int i = 0; i < arrayUser.length(); i++) {
                JSONObject jsonChildNode = arrayUser.getJSONObject(i);
                String iduser = jsonChildNode.optString("iduser");
                String username = jsonChildNode.optString("username");
                String nama = jsonChildNode.optString("nama");


                System.out.println("ID User           : " + iduser);
                System.out.println("Username          : " + username);
                System.out.println("Nama              : " + nama);

                barisTabel = new TableRow(this);

                // Memberi warna pada baris tabel
                if (i % 2 == 0) {
                    barisTabel.setBackgroundColor(Color.LTGRAY);
                }

                TextView viewId = new TextView(this);
                viewId.setText(iduser);
                viewId.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewId);

                TextView viewusername = new TextView(this);
                viewusername.setText(username);
                viewusername.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewusername);

                TextView viewNama = new TextView(this);
                viewNama.setText(nama);
                viewNama.setPadding(5, 1, 6, 1);
                barisTabel.addView(viewNama);

                // Menambahkan button Edit
                buttonEdit.add(i, new Button(this));
                buttonEdit.get(i).setId(Integer.parseInt(iduser));
                buttonEdit.get(i).setTag("Edit");
                buttonEdit.get(i).setText("Edit");
                buttonEdit.get(i).setOnClickListener(this);
                barisTabel.addView(buttonEdit.get(i));

                // Menambahkan tombol Delete
                buttonDelete.add(i, new Button(this));
                buttonDelete.get(i).setId(Integer.parseInt(iduser));
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
        for (int i = 0; i < buttonEdit.size(); i++) {
            // Jika ingin mengedit data pada biodata
            if (view.getId() == buttonEdit.get(i).getId() && view.getTag().toString().trim().equals("Edit")) {
                Toast.makeText(UserActivity.this, "Edit : " + buttonEdit.get(i).getId(), Toast.LENGTH_SHORT).show();
                int id = buttonEdit.get(i).getId();
                getDataByID(id);
            }
            // Menghapus data di Tabel
            else if (view.getId() == buttonDelete.get(i).getId() && view.getTag().toString().trim().equals("Delete")) {
                Toast.makeText(UserActivity.this, "Delete : " + buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
                int id = buttonDelete.get(i).getId();
                deleteUser(id);
            }
        /*if (view.getId() == R.id.buttonTambahBarang) {
            tambahBarang();
        }
        else {

        }*/
        }
    }
    public void deleteUser (int iduser) {
        u.deleteUser(iduser);
        finish();
        startActivity(getIntent());
    }
    public void getDataByID (int iduser) {
        String iduserEdit = null;
        String usernameEdit = null;
        String namaEdit = null;
        String passwordEdit = null;
        JSONArray arrayPersonal;

        try {
            arrayPersonal = new JSONArray(u.getUserById(iduser));
            for (int i  = 0; i < arrayPersonal.length(); i++) {
                JSONObject jsonChildNode = arrayPersonal.getJSONObject(i);
                iduserEdit = jsonChildNode.optString("iduser");
                usernameEdit = jsonChildNode.optString("username");
                passwordEdit = jsonChildNode.optString("password");
                namaEdit = jsonChildNode.optString("nama");
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        LinearLayout layoutInput = new LinearLayout(this);
        layoutInput.setOrientation(LinearLayout.VERTICAL);

        // Membuat id tersembunyi pada AlertDialog


        final EditText editIduser = new EditText(this);
        editIduser.setText(iduserEdit);
        layoutInput.addView(editIduser);

        final EditText editUsername = new EditText(this);
        editUsername.setText(usernameEdit);
        layoutInput.addView(editUsername);

        final EditText editPassword = new EditText(this);
        editPassword.setText(passwordEdit);
        layoutInput.addView(editPassword);

        final EditText editNama = new EditText(this);
        editNama.setText(namaEdit);
        layoutInput.addView(editNama);


        // Membuat AlertDialog untuk mengubah data di Biodata
        AlertDialog.Builder builderEditBiodata = new AlertDialog.Builder(this);
        builderEditBiodata.setIcon(R.drawable.ic_history_48px_512);
        builderEditBiodata.setTitle("Update Biodata");
        builderEditBiodata.setView(layoutInput);
        builderEditBiodata.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String iduser = editIduser.getText().toString();
                String username = editUsername.getText().toString();
                String nama = editNama.getText().toString();
                System.out.println("ID : " + iduser +"Username : "+username  +"Nama : " + nama);

                String laporan = u.updateUser(editIduser.getText().toString(), editUsername.getText().toString(), editPassword.getText().toString(),
                        editNama.getText().toString());

                Toast.makeText(UserActivity.this, laporan, Toast.LENGTH_SHORT).show();

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
}
