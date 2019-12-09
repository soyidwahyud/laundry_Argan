package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laundryargan.R;
import com.example.laundryargan.util.ModelBarang;
import com.example.laundryargan.util.ModelHeader;
import com.example.laundryargan.util.ModelPelanggan;
import com.example.laundryargan.util.ModelUser;
import com.example.laundryargan.util.Server;
import com.example.laundryargan.util.ServiceHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class DataCuciMasuk extends AppCompatActivity {
    private EditText jmlpd, jmlbj, jmlsel, jmlbs;
    private EditText np, ntlp, alamt;
    private String namaP = "Nama Pelanggan";
    private String nohp = "Nomor HP";
    private String almt = "Alamat Pelanggan";
    private int jumlahP;
    private int jumlahPaDal;
    private int jumlahSeli;
    private int jumlahBedSp;

    // private Button btnHitung, btnSave;
    private TextView txtHasil;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tgl_masuk, tgl_masuk2;
    private TextView tgl_keluar, tgl_keluar2;
    private EditText getidpel, getiduser;
    private Button btDatePicker;
    private Button btDatePickers;
    private RadioGroup radioGroupNb;
    private RadioButton radioButtonNb;
    private RadioButton radioBiasa;
    private RadioButton radioKilat;
    private Button buttonHitung;
    private Button buttonSave;
    private Spinner pelanggan,  user, transaksi;

    //nama pelanggan
    private Button get_namapelanggan;
    private Spinner namapel;


    //nama user
    private Button get_namauser;
    private Spinner namauser;

    //idbarang
    private Button get_idbarang;
    private Spinner idbarang;
    private EditText getIdbarang;

    JSONArray JsonArrayPelanggan = null;
    JSONArray JsonArrayuser = null;
    JSONArray JsonArrayTransaksi = null;
    JSONArray JsonArrayBarang = null;
    List<String> valueIdPelanggan = new ArrayList<String>();
    List<String> valueNamaPelanggan = new ArrayList<String>();
    List<String> valueIduser = new ArrayList<String>();
    List<String> valueNamaUser = new ArrayList<String>();
    List<String> valueIdTransaksi = new ArrayList<String>();
    List<String> valueIdBarang = new ArrayList<String>();


    ProgressDialog pDialog;
    private Button p, u, t;

    Detail d = new Detail();
    PelangganActivity2 pe = new PelangganActivity2();
    Header h = new Header();
    private Button go1, go2;
    private EditText getidTransaksi;

    //Barang
    private Button save3;
    Barang b = new Barang();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_cuci_masuk);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        jmlbj = (EditText) findViewById(R.id.perkg);


        txtHasil = (TextView) findViewById(R.id.totHarga);
        tgl_masuk = findViewById(R.id.tgl_masuk);
        tgl_keluar = findViewById(R.id.tgl_keluar);
        tgl_masuk2 = findViewById(R.id.tgl_masuk2);
        tgl_keluar2 = findViewById(R.id.tgl_keluar2);
        getidpel = findViewById(R.id.getidpel);
        getidpel.setEnabled(false);
        getiduser = findViewById(R.id.getiduser);
        getiduser.setEnabled(false);
        jmlpd = (EditText) findViewById(R.id.editTextPCS);
        getidTransaksi = findViewById(R.id.getidTransaksi);
        getidTransaksi.setEnabled(false);

        btDatePicker = findViewById(R.id.bt_datepicker);
        btDatePickers = findViewById(R.id.bt_datepickers);
        radioGroupNb = findViewById(R.id.radioGroupNb);
        np = findViewById(R.id.input_nama);
        ntlp = findViewById(R.id.input_no_hp);
        alamt = findViewById(R.id.input_alamat);

        pelanggan = findViewById(R.id.spinner_pelanggan);
        //idpelanggan = findViewById(R.id.spinner_nama_pelanggan);
        user = findViewById(R.id.spinner_user);
        transaksi = findViewById(R.id.spinner_transaksi);


        buttonHitung = (Button) findViewById(R.id.buttonHitung);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String berat = jmlbj.getText().toString();
                    int jumlah = Integer.parseInt(berat);
                    String pcs = jmlpd.getText().toString();
                    int jmlPakaianDalam = Integer.parseInt(pcs);
                    String jumlahSel = jmlsel.getText().toString();
                    int pcsSelimut = Integer.parseInt(jumlahSel);
                    String jumlahBS = jmlbs.getText().toString();
                    int pcsBS = Integer.parseInt(jumlahBS);


                    int jumlahPakaianDalam = 0;
                    if (jmlPakaianDalam <= 3){
                        jumlahPakaianDalam = 0;
                    } else if (jmlPakaianDalam >= 3){
                        jumlahPakaianDalam = jmlPakaianDalam * 500;
                    }

                    int hargaSel = pcsSelimut * 8000;
                    int hargaBS = pcsBS * 10000;

                    int selected = radioGroupNb.getCheckedRadioButtonId();
                    int kg;
                    radioButtonNb = (RadioButton) findViewById(selected);
                    if (radioButtonNb.getText().equals("Biasa")){
                        kg = jumlah * 3500;
                    } else {
                        kg = jumlah * 5000;
                    }
                    int hasTot = hargaTotal(hargaBS, jumlahPakaianDalam, hargaSel, kg);
                    String output = String.valueOf(hasTot);
                    txtHasil.setText(output);
//                Toast.makeText(getApplicationContext(), String.valueOf(hargaTotal),
//                Toast.LENGTH_SHORT).show();
            }

            private int hargaTotal(int hargaBS, int jumlahPakaianDalam, int hargaSel, int kg) {
                return (jumlahPakaianDalam + hargaSel + hargaBS + kg);
            }
        });

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtransaksi = getidTransaksi.getText().toString();
                String perkg = jmlbj.getText().toString();
                String pdalam = jmlpd.getText().toString();
                String idbarang = getIdbarang.getText().toString();
                String total = txtHasil.getText().toString();
                System.out.println("Id Transaksi : " + idtransaksi + " Berat Baju : " + perkg + " Pakaian Dalam : " + pdalam+ " Id Barang : " + idbarang+ " Pakaian Dalam : " + pdalam + " Total : " + total);
                String laporan  = d.insertDetail(idtransaksi, perkg,pdalam,idbarang,total);
                Toast.makeText(DataCuciMasuk.this, laporan, Toast.LENGTH_SHORT).show();
            }
        });

        btDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog1();
            }
        });

        btDatePickers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog2();
            }
        });
        p = findViewById(R.id.get_idpelanggan);
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getDataPelanggan().execute();
            }
        });
        u= findViewById(R.id.get_iduser);
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getDataUser().execute();
            }
        });
        t=findViewById(R.id.get_idtransaksi);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getDataTransaksi().execute();
            }
        });
        go1 = findViewById(R.id.save1);
        go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = np.getText().toString();
                String notelp = ntlp.getText().toString();
                String alamat = alamt.getText().toString();
                System.out.println("Nama : " + nama + "Alamat : " + alamat + "Nomor Telfon : " + notelp);
                String laporan  = pe.insertPelanggan(nama, alamat,notelp);
                Toast.makeText(DataCuciMasuk.this, laporan, Toast.LENGTH_SHORT).show();
            }
        });
        go2 = findViewById(R.id.save2);
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idpelanggan = getidpel.getText().toString();
                String iduser = getiduser.getText().toString();
                String tm = tgl_masuk2.getText().toString();
                String tk = tgl_keluar2.getText().toString();
                System.out.println("Id Pelanggan : " + idpelanggan + " Id User : " + iduser + " Tanggal Masuk : " + tm + " Tanggal Keluar : " + tk);
                String laporan  = h.insertHeader(idpelanggan, tm, tk, iduser);
                Toast.makeText(DataCuciMasuk.this, laporan, Toast.LENGTH_SHORT).show();
            }
        });

        //spinner pelanggan
        get_namapelanggan = findViewById(R.id.get_namapelanggan);
        namapel = findViewById(R.id.spinner_nama_pelanggan);
        get_namapelanggan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getDataNamaPelanggan().execute();
            }
        });
        //spinner user
        get_namauser = findViewById(R.id.get_namauser);
        namauser = findViewById(R.id.spinner_nama_user);
        get_namauser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getDataNamaUser().execute();
            }
        });

        //Barang
        jmlbs = (EditText) findViewById(R.id.tambahBSPCS);
        jmlsel = (EditText) findViewById(R.id.tambahSelimutPCS);
        save3 = findViewById(R.id.save3);
        save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selimut = jmlsel.getText().toString();
                String sprei = jmlbs.getText().toString();
                System.out.println("Selimut : " + selimut + " Sprei : " + sprei);
                String laporan  = b.insertBarang(selimut, sprei);
                Toast.makeText(DataCuciMasuk.this, laporan, Toast.LENGTH_SHORT).show();
            }
        });

        //spinner barang
        get_idbarang = findViewById(R.id.get_idbarang);
        getIdbarang = findViewById(R.id.getidBarang);
        getIdbarang.setEnabled(false);
        idbarang = findViewById(R.id.spinner_id_barang);
        get_idbarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new getDataIdBarang().execute();
            }
        });


    }

    private class getDataPelanggan extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DataCuciMasuk.this);
            pDialog.setMessage("Mohon Tunggu...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            //Membuat Service "ServiceHandler"
            ServiceHandler sh = new ServiceHandler();

            // Memanggil URL untuk mendapatkan respon data
            String jsonStr = sh.makeServiceCall(Server.URL + "server4.php?operasi=get_id_pelanggan", ServiceHandler.GET); //siswaManager.php?mode=getAllDataSiswa

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Mendapatkan data Array JSON
                    JsonArrayPelanggan = jsonObj.getJSONArray("values");

                    ArrayList<ModelPelanggan> listDataPelanggan = new ArrayList<ModelPelanggan>();
                    listDataPelanggan.clear();

                    //Melakukan perulangan untuk memecah data
                    for (int i = 0; i < JsonArrayPelanggan.length(); i++) {
                        JSONObject obj = JsonArrayPelanggan.getJSONObject(i);

                        ModelPelanggan p = new ModelPelanggan();
                        p.setIdpelanggan(obj.getString("idpelanggan"));
                        p.setNama_pelanggan(obj.getString("nama_pelanggan"));
                        listDataPelanggan.add(p);

                        System.out.println("data " + p.getIdpelanggan());
                    }
                    valueIdPelanggan = new ArrayList<String>();
                    valueNamaPelanggan = new ArrayList<String>();

                    for (int i = 0; i < listDataPelanggan.size(); i++) {
                        valueIdPelanggan.add(listDataPelanggan.get(i).getIdpelanggan());
                        valueNamaPelanggan.add(listDataPelanggan.get(i).getNama_pelanggan());

                        System.out.println("data 2 " + listDataPelanggan.get(i).getNama_pelanggan());

                    }

                    System.out.println("id pelanggan + " + valueIdPelanggan.get(0));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            // Membuat adapter untuk spinner
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(DataCuciMasuk.this,
                    android.R.layout.simple_spinner_item, valueIdPelanggan);

            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //Mengaitkan adapter spinner dengan spinner yang ada di layout
            pelanggan.setAdapter(spinnerAdapter);
            pelanggan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String idpelanggan = valueIdPelanggan.get(position);
                    //String namapelanggan = valueNamaPelanggan.get(position);
                    String idpel = pelanggan.getSelectedItem().toString();
                    getidpel.setText(idpel);
                    Toast.makeText(DataCuciMasuk.this, "Anda Memilih ID Pelanggan: "+idpelanggan, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });

        }
    }

    private class getDataNamaPelanggan extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DataCuciMasuk.this);
            pDialog.setMessage("Mohon Tunggu...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            //Membuat Service "ServiceHandler"
            ServiceHandler sh = new ServiceHandler();

            // Memanggil URL untuk mendapatkan respon data
            String jsonStr = sh.makeServiceCall(Server.URL + "server4.php?operasi=get_id_pelanggan", ServiceHandler.GET); //siswaManager.php?mode=getAllDataSiswa

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Mendapatkan data Array JSON
                    JsonArrayPelanggan = jsonObj.getJSONArray("values");

                    ArrayList<ModelPelanggan> listDataPelanggan = new ArrayList<ModelPelanggan>();
                    listDataPelanggan.clear();

                    //Melakukan perulangan untuk memecah data
                    for (int i = 0; i < JsonArrayPelanggan.length(); i++) {
                        JSONObject obj = JsonArrayPelanggan.getJSONObject(i);

                        ModelPelanggan p = new ModelPelanggan();
                        p.setIdpelanggan(obj.getString("idpelanggan"));
                        p.setNama_pelanggan(obj.getString("nama_pelanggan"));
                        listDataPelanggan.add(p);

                        System.out.println("data " + p.getIdpelanggan());
                    }
                    valueIdPelanggan = new ArrayList<String>();
                    valueNamaPelanggan = new ArrayList<String>();

                    for (int i = 0; i < listDataPelanggan.size(); i++) {
                        valueIdPelanggan.add(listDataPelanggan.get(i).getIdpelanggan());
                        valueNamaPelanggan.add(listDataPelanggan.get(i).getNama_pelanggan());

                        System.out.println("data 2 " + listDataPelanggan.get(i).getNama_pelanggan());

                    }

                    System.out.println("Nama pelanggan + " + valueNamaPelanggan.get(0));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            // Membuat adapter untuk spinner
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(DataCuciMasuk.this,
                    android.R.layout.simple_spinner_item, valueNamaPelanggan);

            spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //Mengaitkan adapter spinner dengan spinner yang ada di layout
            namapel.setAdapter(spinnerAdapter);
            namapel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String idpelanggan = valueIdPelanggan.get(position);
                    String namapelanggan = valueNamaPelanggan.get(position);

                    Toast.makeText(DataCuciMasuk.this, "Anda Memilih ID Pelanggan: "+idpelanggan + " Nama Pelanggan " + namapelanggan, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });

        }
    }

    private class getDataUser extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DataCuciMasuk.this);
            pDialog.setMessage("Mohon Tunggu...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            //Membuat Service "ServiceHandler"
            ServiceHandler sh = new ServiceHandler();

            // Memanggil URL untuk mendapatkan respon data
            String jsonStr = sh.makeServiceCall(Server.URL + "server4.php?operasi=get_id_user", ServiceHandler.GET); //siswaManager.php?mode=getAllDataSiswa

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Mendapatkan data Array JSON
                    JsonArrayuser = jsonObj.getJSONArray("values");

                    ArrayList<ModelUser> listDataUser = new ArrayList<ModelUser>();
                    listDataUser.clear();

                    //Melakukan perulangan untuk memecah data
                    for (int i = 0; i < JsonArrayuser.length(); i++) {
                        JSONObject obj = JsonArrayuser.getJSONObject(i);

                        ModelUser u = new ModelUser();
                        u.setIduser(obj.getString("iduser"));
                        u.setNama(obj.getString("nama"));
                        listDataUser.add(u);

                        System.out.println("data " + u.getIduser());
                    }
                    valueIduser = new ArrayList<String>();
                    valueNamaUser = new ArrayList<String>();

                    for (int i = 0; i < listDataUser.size(); i++) {
                        valueIduser.add(listDataUser.get(i).getIduser());
                        valueNamaUser.add(listDataUser.get(i).getNama());

                        System.out.println("data 2 " + listDataUser.get(i).getNama());

                    }

                    System.out.println("id user + " + valueIduser.get(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            // Membuat adapter untuk spinner
            ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(DataCuciMasuk.this,
                    android.R.layout.simple_spinner_item, valueIduser);

            spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //Mengaitkan adapter spinner dengan spinner yang ada di layout
            user.setAdapter(spinnerAdapter2);
            user.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    String idUser = user.getSelectedItem().toString();
                    getiduser.setText(idUser);

                    //String namaUser = valueNamaUser.get(position);
                    Toast.makeText(DataCuciMasuk.this, "Anda Memilih ID User: "+idUser, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });

        }
    }

    private class getDataNamaUser extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DataCuciMasuk.this);
            pDialog.setMessage("Mohon Tunggu...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            //Membuat Service "ServiceHandler"
            ServiceHandler sh = new ServiceHandler();

            // Memanggil URL untuk mendapatkan respon data
            String jsonStr = sh.makeServiceCall(Server.URL + "server4.php?operasi=get_id_user", ServiceHandler.GET); //siswaManager.php?mode=getAllDataSiswa

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Mendapatkan data Array JSON
                    JsonArrayuser = jsonObj.getJSONArray("values");

                    ArrayList<ModelUser> listDataUser = new ArrayList<ModelUser>();
                    listDataUser.clear();

                    //Melakukan perulangan untuk memecah data
                    for (int i = 0; i < JsonArrayuser.length(); i++) {
                        JSONObject obj = JsonArrayuser.getJSONObject(i);

                        ModelUser u = new ModelUser();
                        u.setIduser(obj.getString("iduser"));
                        u.setNama(obj.getString("nama"));
                        listDataUser.add(u);

                        System.out.println("data " + u.getIduser());
                    }
                    valueIduser = new ArrayList<String>();
                    valueNamaUser = new ArrayList<String>();

                    for (int i = 0; i < listDataUser.size(); i++) {
                        valueIduser.add(listDataUser.get(i).getIduser());
                        valueNamaUser.add(listDataUser.get(i).getNama());

                        System.out.println("data 2 " + listDataUser.get(i).getNama());

                    }

                    System.out.println("Nama User + " + valueNamaUser.get(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            // Membuat adapter untuk spinner
            ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(DataCuciMasuk.this,
                    android.R.layout.simple_spinner_item, valueNamaUser);

            spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //Mengaitkan adapter spinner dengan spinner yang ada di layout
            namauser.setAdapter(spinnerAdapter2);
            namauser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    //String idUser = user.getSelectedItem().toString();
                    //getiduser.setText(idUser);
                    String idUser = valueIduser.get(position);
                    String namaUser = valueNamaUser.get(position);
                    Toast.makeText(DataCuciMasuk.this, "Anda Memilih ID User: "+idUser + " Nama User : " + namaUser, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });

        }
    }



    private class getDataTransaksi extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DataCuciMasuk.this);
            pDialog.setMessage("Mohon Tunggu...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            //Membuat Service "ServiceHandler"
            ServiceHandler sh = new ServiceHandler();

            // Memanggil URL untuk mendapatkan respon data
            String jsonStr = sh.makeServiceCall(Server.URL + "server4.php?operasi=get_id_transaksi", ServiceHandler.GET); //siswaManager.php?mode=getAllDataSiswa

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Mendapatkan data Array JSON
                    JsonArrayTransaksi = jsonObj.getJSONArray("values");

                    ArrayList<ModelHeader> listDataTransaksi = new ArrayList<ModelHeader>();
                    listDataTransaksi.clear();

                    //Melakukan perulangan untuk memecah data
                    for (int i = 0; i < JsonArrayTransaksi.length(); i++) {
                        JSONObject obj = JsonArrayTransaksi.getJSONObject(i);

                        ModelHeader h = new ModelHeader();
                        h.setIdtransaksi(obj.getString("idtransaksi"));
                        listDataTransaksi.add(h);

                        System.out.println("data " + h.getIdtransaksi());
                    }
                    valueIdTransaksi = new ArrayList<String>();

                    for (int i = 0; i < listDataTransaksi.size(); i++) {
                        valueIdTransaksi.add(listDataTransaksi.get(i).getIdtransaksi());

                        System.out.println("data 2 " + listDataTransaksi.get(i).getIdtransaksi());

                    }

                    System.out.println("id transaksi + " + valueIdTransaksi.get(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            // Membuat adapter untuk spinner
            ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(DataCuciMasuk.this,
                    android.R.layout.simple_spinner_item, valueIdTransaksi);

            spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //Mengaitkan adapter spinner dengan spinner yang ada di layout
            transaksi.setAdapter(spinnerAdapter3);
            transaksi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    //String idTransaksi = valueIdTransaksi.get(position);
                    String idTransaksi = transaksi.getSelectedItem().toString();
                    getidTransaksi.setText(idTransaksi);
                    Toast.makeText(DataCuciMasuk.this, "Anda Memilih ID Transaksi: "+idTransaksi, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });

        }
    }

    private class getDataIdBarang extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(DataCuciMasuk.this);
            pDialog.setMessage("Mohon Tunggu...");
            pDialog.setCancelable(false);
            pDialog.show();
        }
        @Override
        protected Void doInBackground(Void... arg0) {
            //Membuat Service "ServiceHandler"
            ServiceHandler sh = new ServiceHandler();

            // Memanggil URL untuk mendapatkan respon data
            String jsonStr = sh.makeServiceCall(Server.URL + "server4.php?operasi=get_id_barang", ServiceHandler.GET); //siswaManager.php?mode=getAllDataSiswa

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Mendapatkan data Array JSON
                    JsonArrayBarang = jsonObj.getJSONArray("values");

                    ArrayList<ModelBarang> listDataBarang = new ArrayList<ModelBarang>();
                    listDataBarang.clear();

                    //Melakukan perulangan untuk memecah data
                    for (int i = 0; i < JsonArrayBarang.length(); i++) {
                        JSONObject obj = JsonArrayBarang.getJSONObject(i);

                        ModelBarang b = new ModelBarang();
                        b.setIdbarang(obj.getString("idbarang"));
                        listDataBarang.add(b);

                        System.out.println("data " + b.getIdbarang());
                    }
                    valueIdBarang = new ArrayList<String>();

                    for (int i = 0; i < listDataBarang.size(); i++) {
                        valueIdBarang.add(listDataBarang.get(i).getIdbarang());

                        System.out.println("data 2 " + listDataBarang.get(i).getIdbarang());

                    }

                    System.out.println("id barang + " + valueIdBarang.get(0));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


            // Membuat adapter untuk spinner
            ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(DataCuciMasuk.this,
                    android.R.layout.simple_spinner_item, valueIdBarang);

            spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            //Mengaitkan adapter spinner dengan spinner yang ada di layout
            idbarang.setAdapter(spinnerAdapter3);
            idbarang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                    //String idTransaksi = valueIdTransaksi.get(position);
                    String idBarang = idbarang.getSelectedItem().toString();
                    getIdbarang.setText(idBarang);
                    Toast.makeText(DataCuciMasuk.this, "Anda Memilih ID Barang: "+idBarang, Toast.LENGTH_LONG).show();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parentView) {
                    // your code here
                }

            });

        }
    }


            private void showDialog2() {
                Calendar newCalendar = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        tgl_keluar2.setText(dateFormatter.format(newDate.getTime()));

                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();

            }

            private void showDialog1() {
                Calendar newCalendar = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        tgl_masuk2.setText(dateFormatter.format(newDate.getTime()));

                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }

//    public void buttonSave(View view) {
//        Intent intent = new Intent(DataCuciMasuk.this, DetailActivity.class);
//        startActivity(intent);
//    }
}
