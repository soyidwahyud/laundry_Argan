package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.laundryargan.MainActivity;
import com.example.laundryargan.R;

public class menu extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    String id, username;
    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);
        Button p = findViewById(R.id.b_pelanggan);
        Button keluar = findViewById(R.id.exit);

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(menu.this, pelangganActivity.class);
                startActivity(intent);
            }
        });
        keluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(Login.session_status, false);
                editor.putString(TAG_ID, null);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(menu.this, Login.class);
                finish();
                startActivity(intent);
            }
        });
    }
    //public void keluar(View view) {
    //    finish();
    //}

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

    public void HeaderClick(View view) {
        Intent intent = new Intent(this, HeaderActivity.class);
        startActivity(intent);
    }

    public void UserClick(View view) {
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
    public void detailClick(View view) {
        Intent intent = new Intent(this, DetailActivity.class);
        startActivity(intent);
    }
}
