package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.epharma.adapter.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class digestiveSystem extends AppCompatActivity {
    RecyclerView recyclerView;
    digestiveadapter digestiveadapter;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digestive_system);
        recyclerView=findViewById(R.id.recy);

        nm=new ArrayList<>();
        cst=new ArrayList<>();
        acd=new ArrayList<>();
        img=new ArrayList<>();

        nm.addAll(Arrays.asList("Montair Lc", "Montair Fx", "ParacetaMol", "Alprazamol", "Dyflogest"));
        cst.addAll(Arrays.asList("10 $", "20 $", "30 $", "40 $", "50 $"));
        acd.addAll(Arrays.asList("Levocytrozin", "Montelucast", "paracyntex", "AlprazaMyx", "Metaxyn"));
        img.addAll(Arrays.asList(R.drawable.maontairlc, R.drawable.montairfx, R.drawable.paracetamol, R.drawable.alprazamol, R.drawable.dyflogest));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        digestiveadapter=new digestiveadapter(getApplicationContext(),nm,cst,acd,img);
        recyclerView.setAdapter(digestiveadapter);

    }


    public void gotomain(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}