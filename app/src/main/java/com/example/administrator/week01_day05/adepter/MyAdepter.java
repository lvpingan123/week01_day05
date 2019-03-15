package com.example.administrator.week01_day05.adepter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.week01_day05.Clazz.Data;
import com.example.administrator.week01_day05.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.MyHolder>{
    List<Data> list=new ArrayList<>();
    Context context;

    public MyAdepter(Context context) {
        this.context = context;
    }

    public void refresh(List<Data> list){
        this.list = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());

        return new MyHolder(inflater.inflate(R.layout.item_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        Picasso.with(context).load(list.get(i).imgPath).into(myHolder.img);
        myHolder.tv.setText(list.get(i).tvText);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tv;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.item_img);
            tv=itemView.findViewById(R.id.item_tv);
        }
    }
}
