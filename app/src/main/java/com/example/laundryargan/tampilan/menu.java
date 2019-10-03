package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.laundryargan.MainActivity;
import com.example.laundryargan.R;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void clickdapel(View view) {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void keluar(View view) {
        finish();
    }
}
