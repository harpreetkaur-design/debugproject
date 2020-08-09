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
import com.example.epharma.paymentSection;
import com.example.epharma.productOpened;

import java.util.List;

public class adapternervous extends RecyclerView.Adapter<adapternervous.ViewHolder>{
Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    public adapternervous(Context context,List<String> nm,List<String> cst,List<String> acd,List<Integer> img) {
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
        View listItem= layoutInflater.inflate(R.layout.itemsnervous, parent, false);

        ViewHolder holder=new ViewHolder(listItem);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.nervousmedicinename.setText(nm.get(position));
        holder.nervousmedicinecost.setText(cst.get(position));
        holder.nervousmedicineacid.setText(acd.get(position));
        holder.nervousmedicineimage.setImageResource(img.get(position));

        holder.nervousplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(), productOpened.class);
                intent.putExtra("pname",holder.nervousmedicinename.getText().toString());
                intent.putExtra("pacid",holder.nervousmedicineacid.getText().toString());
                intent.putExtra("pcost",holder.nervousmedicinecost.getText().toString());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nervousmedicinename,nervousmedicineacid,nervousmedicinecost;
        ImageView nervousmedicineimage;
        LinearLayout nervousplayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nervousmedicineimage=itemView.findViewById(R.id.nervousmedimage);
            nervousmedicinename=itemView.findViewById(R.id.nervousmedicinename);
            nervousmedicinecost=itemView.findViewById(R.id.nervousmedicinecost);
            nervousmedicineacid=itemView.findViewById(R.id.nervousmedicineacid);
            nervousplayout=itemView.findViewById(R.id.nervousplayout);
        }
    }
}
