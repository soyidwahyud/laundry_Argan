package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.laundryargan.MainActivity;
import com.example.laundryargan.R;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button p = findViewById(R.id.b_pelanggan);

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(menu.this, pelangganActivity.class);
                startActivity(intent);
            }
        });
    }
    public void keluar(View view) {
        finish();
    }

    public void datCuci(View view) {
        Intent intent = new Intent(this, DataCuciMasuk.class);
        startActivity(intent);
    }

    public void lap(View view) {
        Intent intent = new Intent(this, Laporan.class);
        startActivity(intent);

    }

    public void barangHandler(View view) {
        Intent intent = new Intent(this, BarangActivity.class);
        startActivity(intent);
    }
}
