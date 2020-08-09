package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.epharma.adapter.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.epharma.adapter.digestiveadapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cardivascularSystem extends AppCompatActivity {
RecyclerView recyclerView;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;
    adaptercardivascular adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardivascular_system);
        recyclerView=findViewById(R.id.recy);
        nm=new ArrayList<>();
        cst=new ArrayList<>();
        acd=new ArrayList<>();
        img=new ArrayList<>();

        nm.addAll(Arrays.asList("Kyolic", "Ceylon", "Neo 100", "Metolar", "Cardi Better"));
        cst.addAll(Arrays.asList("10 $", "20 $", "30 $", "40 $", "50 $"));
        acd.addAll(Arrays.asList("Levocytrozin", "Montelucast", "paracyntex", "AlprazaMyx", "Metaxyn"));
        img.addAll(Arrays.asList(R.drawable.kyolic, R.drawable.ceylon, R.drawable.neo, R.drawable.metolar, R.drawable.cardibetter));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new adaptercardivascular(getApplicationContext(),nm,cst,acd,img);
        recyclerView.setAdapter(adapter);


    }

    public void gotomain(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}