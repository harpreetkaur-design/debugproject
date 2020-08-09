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

public class skinCare extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;
    adapterskincare adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_care);
        recyclerView=findViewById(R.id.recy);

        nm=new ArrayList<>();
        cst=new ArrayList<>();
        acd=new ArrayList<>();
        img=new ArrayList<>();

        nm.addAll(Arrays.asList("Ernest", "FaceHero", "Monat", "Sulwhasoo", "Versed"));
        cst.addAll(Arrays.asList("10 $", "20 $", "30 $", "40 $", "50 $"));
        acd.addAll(Arrays.asList("Levocytrozin", "Montelucast", "paracyntex", "AlprazaMyx", "Metaxyn"));
        img.addAll(Arrays.asList(R.drawable.ernest, R.drawable.facehero, R.drawable.monat, R.drawable.sulwhasoo, R.drawable.versed));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new adapterskincare(getApplicationContext(),nm,cst,acd,img);
        recyclerView.setAdapter(adapter);


    }

    public void gotomain(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}