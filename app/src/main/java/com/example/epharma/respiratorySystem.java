package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.epharma.adapter.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.epharma.adapter.adaptercardivascular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class respiratorySystem extends AppCompatActivity {
RecyclerView recyclerView;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;
    adapterrespiratory adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respiratory_system);
        recyclerView=findViewById(R.id.recy);
        nm=new ArrayList<>();
        cst=new ArrayList<>();
        acd=new ArrayList<>();
        img=new ArrayList<>();

        nm.addAll(Arrays.asList("Kyolic", "Dyflogest", "Paracetamol", "Ceylon", "Metolar 100"));
        cst.addAll(Arrays.asList("10 $", "20 $", "30 $", "40 $", "50 $"));
        acd.addAll(Arrays.asList("Levocytrozin", "Montelucast", "paracyntex", "AlprazaMyx", "Metaxyn"));
        img.addAll(Arrays.asList(R.drawable.kyolic, R.drawable.dyflogest, R.drawable.paracetamol, R.drawable.ceylon, R.drawable.metolar));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new adapterrespiratory(getApplicationContext(),nm,cst,acd,img);
        recyclerView.setAdapter(adapter);


    }

    public void gotomain(View view) {

        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}