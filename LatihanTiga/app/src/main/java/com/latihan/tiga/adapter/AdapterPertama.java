package com.latihan.tiga.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.latihan.tiga.R;
import com.latihan.tiga.modal.ModalPertama;

import java.util.ArrayList;

public class AdapterPertama extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<ModalPertama> modalArrayList;

    public AdapterPertama(Context context, ArrayList<ModalPertama> modalArrayList) {
        this.context = context;
        this.modalArrayList = modalArrayList;
    }

    class MyCustomView extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView text;

        public MyCustomView(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_activity, null);

        return new MyCustomView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ModalPertama modal = modalArrayList.get(i);
        ((MyCustomView) viewHolder).image.setImageDrawable(modal.getImage());
        ((MyCustomView) viewHolder).text.setText(modal.getTitle());

    }

    @Override
    public int getItemCount() {
        return modalArrayList.size();
    }
}
