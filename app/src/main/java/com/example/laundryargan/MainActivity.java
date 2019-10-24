package com.example.laundryargan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laundryargan.model_class.RequestHandler;
import com.example.laundryargan.model_class.pelanggan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private static final int CODE_GET_REQUEST = 1024;
    private static final int CODE_POST_REQUEST = 1025;
    EditText nama, telp,id, alamat;
    ProgressBar progressBar;
    Button tambah;
    boolean isUpdating = false;

    List<pelanggan> pelangganList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText)findViewById(R.id.nama);
        telp = (EditText)findViewById(R.id.telp);
        id = (EditText)findViewById(R.id.id);
        tambah = (Button)findViewById(R.id.tambah);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = (ListView) findViewById(R.id.listView);
        alamat = (EditText)findViewById(R.id.alamaat);

        pelangganList = new ArrayList<>();

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
        String nalamat = alamat.getText().toString();

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
        if(TextUtils.isEmpty(nalamat)){
            nama.setError("masukkan Alamat");
            nama.requestFocus();
            return;
        }
        HashMap<String, String>params = new HashMap<>();

        params.put("nama", String.valueOf(nama));
        params.put("notelp", String.valueOf(telp));
        params.put("alamat", String.valueOf(alamat));

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
    private void readHeroes() {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.url_read_pelanggan, null, CODE_GET_REQUEST);
        request.execute();
    }
    private void refreshPelanggan(JSONArray pelanggan) throws JSONException {
        //clearing previous heroes
        pelangganList.clear();

        //traversing through all the items in the json array
        //the json we got from the response
        for (int i = 0; i < pelanggan.length(); i++) {
            //getting each hero object
            JSONObject obj = pelanggan.getJSONObject(i);

            //adding the hero to the list
            pelangganList.add(new pelanggan(
                    obj.getInt("id"),
                    obj.getString("name"),
                    obj.getString("alamat"),
                    obj.getString("no telp")
            ));
        }

        //creating the adapter and setting it to the listview
        PelangganAdapter adapter = new PelangganAdapter(pelangganList);
        listView.setAdapter(adapter);
    }

    private void deletePelanggan(int id) {
        PerformNetworkRequest request = new PerformNetworkRequest(Api.url_delete_pelanggan + id, null, CODE_GET_REQUEST);
        request.execute();
    }

    class PelangganAdapter extends ArrayAdapter<pelanggan>{
        List<pelanggan> pelangganList;

        public PelangganAdapter(List<pelanggan>pelangganList){
            super(MainActivity.this, R.layout.layout_pelanggan_list, MainActivity.this.pelangganList);
            this.pelangganList = this.pelangganList;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.layout_pelanggan_list, null, true);

            TextView textViewName = listViewItem.findViewById(R.id.textViewName);

            TextView textViewUpdate = listViewItem.findViewById(R.id.textViewUpdate);
            TextView textViewDelete = listViewItem.findViewById(R.id.textViewDelete);

            final pelanggan p = pelangganList.get(position);

            textViewName.setText(p.getNama_pelanggan());

            textViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle("Delete " + p.getNama_pelanggan())
                            .setMessage("Are you sure you want to delete it?")
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    deletePelanggan(p.getIdpelanggan());
                                }
                            })
                            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();

                }
            });
            return listViewItem;
        }
    }
}
