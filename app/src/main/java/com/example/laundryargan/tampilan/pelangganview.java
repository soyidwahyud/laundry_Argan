package com.example.laundryargan.tampilan;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laundryargan.R;
import com.example.laundryargan.adapters.PersonItemAdapter;
import com.example.laundryargan.model_class.pelanggan;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.laundryargan.R.id.pelanggan_list;

public class pelangganview extends AppCompatActivity {
    @BindView(pelanggan_list)
    ListView pelangganList;

    List<pelanggan> pelangganItemList;
    PersonItemAdapter personItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelangganview);
        ButterKnife.bind(this);

    }
}
