package com.example.epharma.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;

public class MyViewHolderCardi extends RecyclerView.ViewHolder {

    public TextView productCost,productName,productAcid;
    public LinearLayout cardilayout;

    public MyViewHolderCardi(@NonNull View itemView) {
        super(itemView);
        productName=itemView.findViewById(R.id.cardimedicinename);
        productCost=itemView.findViewById(R.id.cardimedicinecost);
        productAcid=itemView.findViewById(R.id.cardimedicineacid);
        cardilayout=itemView.findViewById(R.id.cardilayout);


    }
}
