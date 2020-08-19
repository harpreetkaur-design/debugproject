package com.example.epharma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.epharma.adapter.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.epharma.adapter.*;
import com.example.epharma.pojo.model;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class skinCare extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseRecyclerOptions<model> options;
    private FirebaseRecyclerAdapter<model,MyViewHolderSkincare> adapter;
    DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_care);
        ref= FirebaseDatabase.getInstance().getReference().child("Skincare");
        recyclerView=findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        options=new FirebaseRecyclerOptions.Builder<model>().setQuery(ref,model.class).build();
        adapter= new FirebaseRecyclerAdapter<model, MyViewHolderSkincare>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final MyViewHolderSkincare holder, int i, @NonNull model model) {
                holder.productName.setText(model.getProductname());
                holder.productAcid.setText(model.getProductacid());
                holder.productCost.setText(model.getProductcost());

                holder.skincarelayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(), productOpened.class);
                        intent.putExtra("pname",holder.productName.getText().toString());
                        intent.putExtra("pacid",holder.productAcid.getText().toString());
                        intent.putExtra("pcost",holder.productCost.getText().toString());
                        startActivity(intent);

                    }
                });
            }

            @NonNull
            @Override
            public MyViewHolderSkincare onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsskincare,parent,false);
                return new MyViewHolderSkincare(v);
            }
        };

        adapter.startListening();
        recyclerView.setAdapter(adapter);




    }
    public void gotomain(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}