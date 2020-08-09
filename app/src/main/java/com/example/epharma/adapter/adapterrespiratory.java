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

public class adapterrespiratory extends RecyclerView.Adapter<adapterrespiratory.ViewHolder>{

Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    public adapterrespiratory(Context context, List<String> nm,List<String> cst,List<String> acd,List<Integer> img) {
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
        View listItem= layoutInflater.inflate(R.layout.itemsrespiratory, parent, false);

      ViewHolder holder=new ViewHolder(listItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.respiratorymedicinename.setText(nm.get(position));
        holder.respiratorymedicinecost.setText(cst.get(position));
        holder.respiratorymedicineacid.setText(acd.get(position));
        holder.respiratorymedicineimage.setImageResource(img.get(position));





    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView respiratorymedicinename,respiratorymedicineacid,respiratorymedicinecost;
        ImageView respiratorymedicineimage;
        LinearLayout resplayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            respiratorymedicineimage=itemView.findViewById(R.id.respiratorymedimage);
            respiratorymedicinename=itemView.findViewById(R.id.respiratorymedicinename);
            respiratorymedicinecost=itemView.findViewById(R.id.respiratorymedicinecost);
            respiratorymedicineacid=itemView.findViewById(R.id.respiratorymedicineacid);
            resplayout=itemView.findViewById(R.id.resplayout);
        }
    }
}
