package com.example.epharma.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;

public class MyViewHolderHaircare extends RecyclerView.ViewHolder {
    public TextView productCost,productName,productAcid;
    public LinearLayout haircarelayout;
    public MyViewHolderHaircare(@NonNull View itemView) {
        super(itemView);
        productName=itemView.findViewById(R.id.haircarename);

        productAcid=itemView.findViewById(R.id.haircareacid);

        productCost=itemView.findViewById(R.id.haircarecost);


        haircarelayout=itemView.findViewById(R.id.haircarelayout);
    }
}
