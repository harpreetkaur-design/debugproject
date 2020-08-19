package com.example.epharma.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;


public class MyViewHolderNervous extends RecyclerView.ViewHolder {
    public TextView productCost,productName,productAcid;
    public LinearLayout nervouslayout;
    public MyViewHolderNervous(@NonNull View itemView) {
        super(itemView);

        productName=itemView.findViewById(R.id.nervousmedicinename);

        productAcid=itemView.findViewById(R.id.nervousmedicineacid);

        productCost=itemView.findViewById(R.id.nervousmedicinecost);


        nervouslayout=itemView.findViewById(R.id.nervousplayout);
    }
}
