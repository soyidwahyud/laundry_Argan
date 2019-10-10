package com.example.laundryargan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.laundryargan.model_class.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;
    EditText nama, telp,id;
    ProgressBar progressBar;
    Button tambah;
    boolean isUpdating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText)findViewById(R.id.nama);
        telp = (EditText)findViewById(R.id.telp);
        id = (EditText)findViewById(R.id.id);
        tambah = (Button)findViewById(R.id.tambah);
        listView = (ListView) findViewById(R.id.listView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isUpdating){

                }
                else{
                    createPelanggan();
                }
            }
        });
    }

    private void createPelanggan() {
        String name = nama.getText().toString().trim();
        String notelp = telp.getText().toString().trim();


        if(TextUtils.isEmpty(name)){
            nama.setError("masukkan nama");
            nama.requestFocus();
            return;
        }

        if(TextUtils.isEmpty(notelp)){
            nama.setError("masukkan no telp");
            nama.requestFocus();
            return;
        }
        HashMap<String, String>params = new HashMap<>();

        params.put("nama", String.valueOf(nama));
        params.put("notelp", String.valueOf(telp));

        PerformNetworkRequest request = new PerformNetworkRequest(Api.url_create_pelanggan,params,CODE_POST_REQUEST);
        request.execute();
    }

        private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;

        int requestCode;

        //constructor to initialize values
        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(GONE);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                    //refreshing the herolist after every operation
                    //so we get an updated list
                    //we will create this method right now it is commented
                    //because we haven't created it yet
                    //refreshHeroList(object.getJSONArray("heroes"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);


            if (requestCode == CODE_GET_REQUEST)
                return requestHandler.sendGetRequest(url);

            return null;
        }
    }


    }
