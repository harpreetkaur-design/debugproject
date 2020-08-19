package com.example.epharma.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;

public class MyViewHolderMakeup extends RecyclerView.ViewHolder {
    public TextView productCost,productName,productAcid;
    public LinearLayout makeuplayout;
    public MyViewHolderMakeup(@NonNull View itemView) {
        super(itemView);
        productName=itemView.findViewById(R.id.makeupname);

        productAcid=itemView.findViewById(R.id.makeupacid);

        productCost=itemView.findViewById(R.id.makeupcost);


        makeuplayout=itemView.findViewById(R.id.makeuplayout);
    }
}
