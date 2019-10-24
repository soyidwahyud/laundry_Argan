package com.example.laundryargan.adapters;

import android.app.Person;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.laundryargan.R;
import com.example.laundryargan.model_class.pelanggan;

import org.w3c.dom.Text;

import java.util.List;

public class PersonItemAdapter extends ArrayAdapter<pelanggan> {

    private List<pelanggan> pelangganList;
    private Context context;
    private LayoutInflater layoutInflater;

    public PersonItemAdapter(@NonNull Context context, List<pelanggan> pelanggans) {
        super(context, R.layout.item_person, pelanggans);
        this.context = context;
        pelangganList = pelanggans;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return pelangganList.size();
    }

    @Nullable
    @Override
    public pelanggan getItem(int position){
        return pelangganList.get(position);
    }

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view = convertView;

        if(view == null){
            view = layoutInflater.inflate(R.layout.item_person, null);
        }
        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.nama);
        TextView alamat = view.findViewById(R.id.alamat);
        TextView notlp = view.findViewById(R.id.notlp);

        pelanggan pelanggan = getItem(position);

        //memberi nilai ke Person_item layout
        id.setText(pelanggan.getIdpelanggan());
        name.setText(pelanggan.getNama_pelanggan());
        alamat.setText(pelanggan.getAlamat());
        notlp.setText(pelanggan.getNo_hp());

        return view;
    }
}
