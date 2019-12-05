package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laundryargan.R;
import com.example.laundryargan.util.hitung;
import com.example.laundryargan.util.jajal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DataCuciMasuk extends AppCompatActivity {
    private EditText jmlpd, jmlbj, jmlsel, jmlbs;
    private EditText np, ntlp, alamat;
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
    private TextView tgl_masuk;
    private TextView tgl_keluar;
    private Button btDatePicker;
    private Button btDatePickers;
    private RadioGroup radioGroupNb;
    private RadioButton radioButtonNb;
    private RadioButton radioBiasa;
    private RadioButton radioKilat;
    private Button buttonHitung;
    private Button buttonSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_cuci_masuk);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        jmlbj = (EditText) findViewById(R.id.perkg);
        jmlpd = (EditText) findViewById(R.id.editTextPCS);
        jmlbs = (EditText) findViewById(R.id.tambahBSPCS);
        jmlsel = (EditText) findViewById(R.id.tambahSelimutPCS);
        txtHasil = (TextView) findViewById(R.id.totHarga);
        tgl_masuk = findViewById(R.id.tgl_masuk);
        tgl_keluar = findViewById(R.id.tgl_keluar);
        btDatePicker = findViewById(R.id.bt_datepicker);
        btDatePickers = findViewById(R.id.bt_datepickers);
        radioGroupNb = findViewById(R.id.radioGroupNb);
        np = findViewById(R.id.input_nama);
        ntlp = findViewById(R.id.input_no_hp);
        alamat = findViewById(R.id.input_alamat);



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
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    String namaPelanggan = np.getText().toString();
//                    String no_hp = ntlp.getText().toString();
//                    String alamatPelanggan = alamat.getText().toString();
//                    String berat = jmlbj.getText().toString();
//                    int jumlah = Integer.parseInt(berat);
//                    String pcs = jmlpd.getText().toString();
//                    int jmlPakaianDalam = Integer.parseInt(pcs);
//                    String jumlahSel = jmlsel.getText().toString();
//                    int pcsSelimut = Integer.parseInt(jumlahSel);
//                    String jumlahBS = jmlbs.getText().toString();
//                    int pcsBS = Integer.parseInt(jumlahBS);
//                    String hargaTotal = txtHasil.getText().toString();
//                    int hasTot = Integer.parseInt(hargaTotal);
//
//                    if(namaPelanggan != null && namaPelanggan != ""){
//                        Intent intent = new Intent(DataCuciMasuk.this, cobaTampil.class);
//                        intent.putExtra(namaP, namaPelanggan);
//                        startActivity(intent);
//                    } else if (no_hp != null && no_hp != ""){
//                        Intent intent = new Intent(DataCuciMasuk.this, cobaTampil.class);
//                        intent.putExtra(nohp, no_hp);
//                        startActivity(intent);
//                    } else if (alamatPelanggan != null && alamatPelanggan != ""){
//                        Intent intent = new Intent(DataCuciMasuk.this, cobaTampil.class);
//                        intent.putExtra(almt, alamatPelanggan);
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME",Toast.LENGTH_SHORT);
//                    }
//
//                } catch (Exception e){
//                    e.printStackTrace();
//                    Toast.makeText(getApplication(), "Error, Try Again!" , Toast.LENGTH_SHORT);
//                }
//
//            }
//        });
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
    }

            private void showDialog2() {
                Calendar newCalendar = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);

                        tgl_keluar.setText("Tanggal Keluar : " + dateFormatter.format(newDate.getTime()));

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

                        tgl_masuk.setText("Tanggal Masuk : " + dateFormatter.format(newDate.getTime()));

                    }
                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }

//    public void buttonSave(View view) {
//        Intent intent = new Intent(DataCuciMasuk.this, DetailActivity.class);
//        startActivity(intent);
//    }
}
