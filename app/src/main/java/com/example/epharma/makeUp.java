package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.epharma.adapter.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class makeUp extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> nm;
    List<String> cst;
    List<String> acd;
    List<Integer> img;
    adaptermakeup adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up);
        recyclerView=findViewById(R.id.recy);


        nm=new ArrayList<>();
        cst=new ArrayList<>();
        acd=new ArrayList<>();
        img=new ArrayList<>();

        nm.addAll(Arrays.asList("Laura Mercier", "Fanty Beauty", "Loccitane", "Bite", "Lancome"));
        cst.addAll(Arrays.asList("10 $", "20 $", "30 $", "40 $", "50 $"));
        acd.addAll(Arrays.asList("Levocytrozin", "Montelucast", "paracyntex", "AlprazaMyx", "Metaxyn"));
        img.addAll(Arrays.asList(R.drawable.lauramercier, R.drawable.fentybeauty, R.drawable.loccitane, R.drawable.bite, R.drawable.lancome));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new adaptermakeup(getApplicationContext(),nm,cst,acd,img);
        recyclerView.setAdapter(adapter);



    }

    public void gotomain(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
