package com.example.laundryargan.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laundryargan.R;
import com.example.laundryargan.model_class.pelanggan;

import java.util.List;

public class PelangganItemAdapter extends ArrayAdapter<pelanggan> {
    private List<pelanggan>listPelanggan;
    private Context context;
    private LayoutInflater layoutInflater;

    public PelangganItemAdapter(@NonNull Context context, List<pelanggan>pelanggans){
        super(context, R.layout.item_pelanggan ,pelanggans);
        this.context=context;
        listPelanggan=pelanggans;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount(){
        return listPelanggan.size();
    }
    @Nullable
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view=convertView;

        if(view==null){

            view=layoutInflater.inflate(R.layout.item_pelanggan,null);
        }
        TextView id = view.findViewById(R.id.tv_id);
        TextView name=view.findViewById(R.id.tv_name);
        TextView alamat=view.findViewById(R.id.tv_alamat);
        TextView notelp=view.findViewById(R.id.tv_notelp);

        pelanggan p=getItem(position);

        //Kasih nilai ke Person_item layout
        id.setText(p.getIdpelanggan());
        name.setText(p.getNama_pelanggan());
        alamat.setText(p.getAlamat());
        notelp.setText(p.getNo_hp());

        return view;
    }

}
