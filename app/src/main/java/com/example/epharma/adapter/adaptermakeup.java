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

public class adaptermakeup extends RecyclerView.Adapter<adaptermakeup.ViewHolder>{

    Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    public adaptermakeup(Context context,  List<String> nm,List<String> cst,List<String> acd,List<Integer> img) {
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
        View listItem= layoutInflater.inflate(R.layout.itemsmakeup, parent, false);

        ViewHolder holder=new ViewHolder(listItem);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.makeupname.setText(nm.get(position));
        holder.makeupcost.setText(cst.get(position));
        holder.makeupacid.setText(acd.get(position));
        holder.makeupimage.setImageResource(img.get(position));

        holder.makeuplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context.getApplicationContext(), productOpened.class);
                intent.putExtra("pname",holder.makeupname.getText().toString());
                intent.putExtra("pacid",holder.makeupacid.getText().toString());
                intent.putExtra("pcost",holder.makeupcost.getText().toString());
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView makeupimage;
        TextView makeupname,makeupacid,makeupcost;
LinearLayout makeuplayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            makeupimage=itemView.findViewById(R.id.makeupimage);
            makeupname=itemView.findViewById(R.id.makeupname);
            makeupacid=itemView.findViewById(R.id.makeupacid);
            makeupcost=itemView.findViewById(R.id.makeupcost);
            makeuplayout=itemView.findViewById(R.id.makeuplayout);

        }
    }
}
