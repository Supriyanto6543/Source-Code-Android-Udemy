package com.app.android.myadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.android.R;
import com.app.android.mymodal.MyModal;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<MyModal> myModals;
    View view;

    public MyAdapter(Context context, ArrayList<MyModal> myModals) {
        this.context = context;
        this.myModals = myModals;
    }

    class MyAdapterKu extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView textView;

        public MyAdapterKu(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.adapter_image);
            textView = itemView.findViewById(R.id.adapter_text);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        view = LayoutInflater.from(context).inflate(R.layout.adapter_user, viewGroup, false);

        return new MyAdapterKu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((MyAdapterKu) viewHolder).textView.setText(myModals.get(i).getName());
        Picasso.get().load(myModals.get(i).getImage()).into(((MyAdapterKu) viewHolder).image);

    }

    @Override
    public int getItemCount() {
        return myModals.size();
    }
}
