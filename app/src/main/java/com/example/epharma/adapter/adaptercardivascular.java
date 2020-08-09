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

public class adaptercardivascular extends RecyclerView.Adapter<adaptercardivascular.ViewHolder>{
Context context;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    public adaptercardivascular(Context context, List<String> nm,List<String> cst,List<String> acd,List<Integer> img) {
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
        View listItem= layoutInflater.inflate(R.layout.itemscardivascular, parent, false);

      ViewHolder holder=new ViewHolder(listItem);
      return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.cardimedicinename.setText(nm.get(position));
        holder.cardimedicinecost.setText(cst.get(position));
        holder.cardimedicineacid.setText(acd.get(position));
        holder.cardimedicineimage.setImageResource(img.get(position));



    }

    @Override
    public int getItemCount() {
        return nm.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView cardimedicinename,cardimedicineacid,cardimedicinecost;
        ImageView cardimedicineimage;
LinearLayout cardilayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardimedicineimage=itemView.findViewById(R.id.cardimedicineimage);
            cardimedicinename=itemView.findViewById(R.id.cardimedicinename);
            cardimedicinecost=itemView.findViewById(R.id.cardimedicinecost);
            cardimedicineacid=itemView.findViewById(R.id.cardimedicineacid);

            cardilayout=itemView.findViewById(R.id.cardilayout);

        }
    }
}
