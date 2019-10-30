package com.example.laundryargan.tampilan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.laundryargan.Adapters.PelangganItemAdapter;
import com.example.laundryargan.R;
import com.example.laundryargan.model_class.pelanggan;
import com.example.laundryargan.response.ApiEndPoint;
import com.example.laundryargan.response.ReadResponse;
import com.example.laundryargan.services.ApiClient;

import java.security.SecureRandom;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pelangganActivity extends AppCompatActivity {

    @BindView(R.id.lv_pelanggan_list)
    ListView lvPersonList;

    List<pelanggan> pelangganItemList;
    PelangganItemAdapter pelangganItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelanggan);
        ButterKnife.bind(this);

        pelangganItemAdapter = new PelangganItemAdapter(this,pelangganItemList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllPelanggan(generateToken());
        pelangganItemAdapter.notifyDataSetChanged();
    }
    private String generateToken() {

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        return bytes.toString();
    }
    public void getAllPelanggan(final String token) {

        ApiEndPoint apiEndPoint = ApiClient.gettClient().create(ApiEndPoint.class);
        Call<ReadResponse> call = apiEndPoint.readRequest(token);

        call.enqueue(new Callback<ReadResponse>() {
            @Override
            public void onResponse(Call<ReadResponse> call, Response<ReadResponse> response) {

                final ReadResponse readResponse = response.body();

                if (readResponse != null) {
                    Log.d("Response Data ", "Total Data" + readResponse.getStatus());
                    if (readResponse.getStatus()) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                pelangganItemList = readResponse.getPelanggans();

                                lvPersonList.setAdapter(new PelangganItemAdapter(getApplicationContext(), pelangganItemList));
                                pelangganItemAdapter.notifyDataSetChanged();
                            }
                        });

                    } else {
                        Toast.makeText(getApplicationContext(), "Data Kosong", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Log.d("Login : ", "Data Null");
                }
            }

            @Override
            public void onFailure(Call<ReadResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Koneksi Bermasalah", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
