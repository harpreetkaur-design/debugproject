package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.epharma.adapter.adaptermakeup;
import com.example.epharma.adapter.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class hairCare extends AppCompatActivity {
RecyclerView recyclerView;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;
    adapterhaircare adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_care);
        recyclerView=findViewById(R.id.recy);

        nm=new ArrayList<>();
        cst=new ArrayList<>();
        acd=new ArrayList<>();
        img=new ArrayList<>();

        nm.addAll(Arrays.asList("Boston Round", "Tresemme", "Kerastase", "Tricovit", "John Masters"));
        cst.addAll(Arrays.asList("10 $", "20 $", "30 $", "40 $", "50 $"));
        acd.addAll(Arrays.asList("Levocytrozin", "Montelucast", "paracyntex", "AlprazaMyx", "Metaxyn"));
        img.addAll(Arrays.asList(R.drawable.bostonround, R.drawable.tresemme, R.drawable.kerastase, R.drawable.tricovit, R.drawable.johnmasters));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new adapterhaircare(getApplicationContext(),nm,cst,acd,img);
        recyclerView.setAdapter(adapter);



    }

    public void gotomain(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}