package com.example.epharma.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;

public class MyViewHolderAllergic extends RecyclerView.ViewHolder {

    public TextView productCost,productName,productAcid;
    public LinearLayout allergiclayout;
    public MyViewHolderAllergic(@NonNull View itemView) {
        super(itemView);
        productName=itemView.findViewById(R.id.allergicmedicinename);
        productAcid=itemView.findViewById(R.id.allergicmedicineacid);
        productCost=itemView.findViewById(R.id.allergicmedicinecost);
        allergiclayout=itemView.findViewById(R.id.allergiclayout);


    }
}
