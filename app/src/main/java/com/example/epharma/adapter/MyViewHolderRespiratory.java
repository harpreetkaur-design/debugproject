package com.example.epharma.adapter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.epharma.R;

public class MyViewHolderRespiratory extends RecyclerView.ViewHolder {
    public TextView productCost,productName,productAcid;
    public LinearLayout resplayout;
    public MyViewHolderRespiratory(@NonNull View itemView) {
        super(itemView);


        productName=itemView.findViewById(R.id.respiratorymedicinename);

        productAcid=itemView.findViewById(R.id.respiratorymedicineacid);

        productCost=itemView.findViewById(R.id.respiratorymedicinecost);


        resplayout=itemView.findViewById(R.id.resplayout);
    }
}
