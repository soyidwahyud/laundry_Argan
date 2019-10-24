package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.laundryargan.MainActivity;
import com.example.laundryargan.R;
import com.example.laundryargan.database.AppVar;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button btlogin;
    private Context context;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = Login.this;
        user = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        progressDialog = new ProgressDialog(context);
        btlogin = findViewById(R.id.btn_login);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        final String username = user.getText().toString().trim();
        final String password = pass.getText().toString().trim();
        progressDialog.setMessage("Login Process....");
        showDialog();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppVar.LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains(AppVar.LOGIN_SUCCESS)) {
                    hideDialog();
                    Intent intent = new Intent(Login.this, menu.class);
                    startActivity(intent);
                } else {
                    hideDialog();
                    Toast.makeText(context, "Invalid username or password", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                Toast.makeText(context, "The server unreachable", Toast.LENGTH_LONG).show();
            }
        }){
            protected Map<String, String> getParams()throws AuthFailureError{
                Map<String,String> params = new HashMap<>();
                params.put(AppVar.KEY_USERNAME, username);
                params.put(AppVar.KEY_PASSWORD, password);

                return params;
            }
        };
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void hideDialog() {
        if(progressDialog.isShowing())
            progressDialog.dismiss();
    }

    private void showDialog() {
        if(!progressDialog.isShowing())
            progressDialog.show();
    }
}
