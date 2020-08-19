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

    public class MyViewHolder extends RecyclerView.ViewHolder{
public TextView productCost,productName,productAcid;
public LinearLayout diglayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productCost=itemView.findViewById(R.id.dmedicinecost);
            productName=itemView.findViewById(R.id.dmedicinename);
            productAcid=itemView.findViewById(R.id.dmedicineacid);
            diglayout=itemView.findViewById(R.id.diglayout);

        }
    }
