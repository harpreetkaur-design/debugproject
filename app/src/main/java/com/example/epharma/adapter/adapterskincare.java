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

public class adapterskincare extends RecyclerView.Adapter<adapterskincare.ViewHolder>{
Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    public adapterskincare(Context context,  List<String> nm,List<String> cst,List<String> acd,List<Integer> img) {
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
        View listItem= layoutInflater.inflate(R.layout.itemsskincare, parent, false);

       ViewHolder holder=new ViewHolder(listItem);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.skinname.setText(nm.get(position));
        holder.skincost.setText(cst.get(position));
        holder.skinacid.setText(acd.get(position));
        holder.skinimage.setImageResource(img.get(position));

        holder.skinlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(), productOpened.class);
                intent.putExtra("pname",holder.skinname.getText().toString());
                intent.putExtra("pacid",holder.skinacid.getText().toString());
                intent.putExtra("pcost",holder.skincost.getText().toString());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView skinimage;
        TextView skinname,skinacid,skincost;
LinearLayout skinlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            skinimage=itemView.findViewById(R.id.skincareimage);
            skinname=itemView.findViewById(R.id.skincarename);
            skinacid=itemView.findViewById(R.id.skincareacid);
            skincost=itemView.findViewById(R.id.skincarecost);
            skinlayout=itemView.findViewById(R.id.skinlayout);


        }
    }

}
