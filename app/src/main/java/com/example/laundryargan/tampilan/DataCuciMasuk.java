package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.laundryargan.R;

public class DataCuciMasuk extends AppCompatActivity {
    private EditText bj, pd, bd, sel;
   // private Button btnHitung, btnSave;
    private TextView txtHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_cuci_masuk);

        bj = findViewById(R.id.editText7);
        pd = findViewById(R.id.editText8);
        bd = findViewById(R.id.editText9);
        sel = findViewById(R.id.editText10);
       // btnHitung = findViewById(R.id.button7);
       // btnSave = findViewById(R.id.button8);
        txtHasil = findViewById(R.id.textView19);

    }

    public void buttonHitungData(View view) {
        String bajuKg = bj.getText().toString();
        String pakaiandlm = pd.getText().toString();
        String bedsep = bd.getText().toString();
        String Selimut = sel.getText().toString();

        float bj = Float.parseFloat(bajuKg);
        float pd = Float.parseFloat(pakaiandlm);
        float bd = Float.parseFloat(bedsep);
        float sel = Float.parseFloat(Selimut);
        float hasil = hitungTotal(bj, pd, bd, sel);
        String output = String.valueOf(hasil);
        txtHasil.setText(output);

    }

    private float hitungTotal(float bj, float pd, float bd, float sel) {
        return  (bj + pd + bd + sel);
    }

    public void buttonSave(View view) {
    }
}
