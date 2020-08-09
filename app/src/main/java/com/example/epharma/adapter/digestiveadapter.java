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

import java.util.List;

public class digestiveadapter extends RecyclerView.Adapter<digestiveadapter.ViewHolder>{
Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    public digestiveadapter(Context context, List<String> nm,List<String> cst,List<String> acd,List<Integer> img) {
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
        View listItem= layoutInflater.inflate(R.layout.itemsdigestive, parent, false);

        ViewHolder holder=new ViewHolder(listItem);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

holder.digestmedicinename.setText(nm.get(position));
holder.digestmedicinecost.setText(cst.get(position));
holder.digestmedicineacid.setText(acd.get(position));
        holder.digestmedicineimage.setImageResource(img.get(position));

        holder.diglayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(),productOpened.class);
                intent.putExtra("pname",holder.digestmedicinename.getText().toString());
                intent.putExtra("pacid",holder.digestmedicineacid.getText().toString());
                intent.putExtra("pcost",holder.digestmedicinecost.getText().toString());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView digestmedicinename,digestmedicineacid,digestmedicinecost;
        ImageView digestmedicineimage;
        LinearLayout diglayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

    digestmedicineimage=itemView.findViewById(R.id.medimage);
           digestmedicinename=itemView.findViewById(R.id.dmedicinename);
            digestmedicinecost=itemView.findViewById(R.id.dmedicinecost);
            digestmedicineacid=itemView.findViewById(R.id.dmedicineacid);
            diglayout=itemView.findViewById(R.id.diglayout);

        }
    }
}
