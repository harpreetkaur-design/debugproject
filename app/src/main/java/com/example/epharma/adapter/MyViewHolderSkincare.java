package com.example.epharma.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;

public class MyViewHolderSkincare extends RecyclerView.ViewHolder {
    public TextView productCost,productName,productAcid;
    public LinearLayout skincarelayout;
    public MyViewHolderSkincare(@NonNull View itemView) {
        super(itemView);
        productName=itemView.findViewById(R.id.skincarename);

        productAcid=itemView.findViewById(R.id.skincareacid);

        productCost=itemView.findViewById(R.id.skincarecost);


        skincarelayout=itemView.findViewById(R.id.skinlayout);
    }
}
