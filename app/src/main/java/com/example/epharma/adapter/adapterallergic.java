package com.example.epharma.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.epharma.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;
import com.example.epharma.paymentSection;

import java.util.List;

public class adapterallergic extends RecyclerView.Adapter<adapterallergic.ViewHolder>{
Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    public adapterallergic(Context context, List<String> nm, List<String> cst, List<String> acd, List<Integer> img) {
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
        View listItem= layoutInflater.inflate(R.layout.itemsallergic, parent, false);

ViewHolder holder=new ViewHolder(listItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.allergicmedicinename.setText(nm.get(position));
        holder.allergicmedicinecost.setText(cst.get(position));
        holder.allergicmedicineacid.setText(acd.get(position));
        holder.allergicmedicineimage.setImageResource(img.get(position));
        holder.allergiclayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(), productOpened.class);
                intent.putExtra("pname",holder.allergicmedicinename.getText().toString());
                intent.putExtra("pacid",holder.allergicmedicineacid.getText().toString());
                intent.putExtra("pcost",holder.allergicmedicinecost.getText().toString());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView allergicmedicinename,allergicmedicineacid,allergicmedicinecost;
        ImageView allergicmedicineimage;
LinearLayout allergiclayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            allergicmedicineimage=itemView.findViewById(R.id.allergicmedimage);
            allergicmedicinename=itemView.findViewById(R.id.allergicmedicinename);
            allergicmedicinecost=itemView.findViewById(R.id.allergicmedicinecost);
            allergicmedicineacid=itemView.findViewById(R.id.allergicmedicineacid);
            allergiclayout=itemView.findViewById(R.id.allergiclayout);

        }
    }
}
