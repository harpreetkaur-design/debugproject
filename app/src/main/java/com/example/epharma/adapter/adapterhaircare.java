package com.example.epharma.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;

import java.util.List;

public class adapterhaircare extends RecyclerView.Adapter<adapterhaircare.ViewHolder>{
  Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;


    public adapterhaircare(Context context,  List<String> nm,List<String> cst,List<String> acd,List<Integer> img) {
    this.context=context;
        this.nm=nm;
        this.cst=cst;
        this.acd=acd;
        this.img=img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.itemshaircare, parent, false);

    ViewHolder holder=new ViewHolder(listItem);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.haircarename.setText(nm.get(position));
        holder.haircarecost.setText(cst.get(position));
        holder.haircareacid.setText(acd.get(position));
        holder.haircareimage.setImageResource(img.get(position));




    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView haircareimage;
        TextView haircarename,haircareacid,haircarecost;
        LinearLayout haircarelayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            haircareimage=itemView.findViewById(R.id.haircareimage);
            haircarename=itemView.findViewById(R.id.haircarename);
            haircareacid=itemView.findViewById(R.id.haircareacid);
            haircarecost=itemView.findViewById(R.id.haircarecost);
            haircarelayout=itemView.findViewById(R.id.haircarelayout);
        }
    }
}
