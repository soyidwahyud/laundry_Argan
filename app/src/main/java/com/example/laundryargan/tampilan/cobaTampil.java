package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import com.example.laundryargan.R;

public class cobaTampil extends DataCuciMasuk {

    TextView textOutput;
    private String nama;
    private String alamat;
    private String nohape;
    private String namaP = "Nama Pelanggan";
    private String nohp = "Nomor HP";
    private String almt = "Alamat Pelanggan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba_tampil);

        textOutput = (TextView) findViewById(R.id.textOutput);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(namaP);
        nohape = extras.getString(nohp);
        alamat = extras.getString(almt);

        textOutput.setText("Nama Pelanggan : " + namaP);
        textOutput.setText("No. HP : " + nohp);
        textOutput.setText("Alamat : " + almt);
    }
}
