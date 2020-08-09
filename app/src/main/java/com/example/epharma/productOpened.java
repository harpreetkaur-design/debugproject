package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class productOpened extends AppCompatActivity {
String prname,prcost,pracid;
String primage;

TextView productname,productacid,productcost;
ImageView productimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_opened);
       prname= getIntent().getStringExtra("pname");
        pracid= getIntent().getStringExtra("pacid");
        prcost= getIntent().getStringExtra("pcost");
        primage= getIntent().getStringExtra("pimage");

        productname=findViewById(R.id.productname);
        productcost=findViewById(R.id.productcost);
        productacid=findViewById(R.id.productacid);
        productimage=findViewById(R.id.productimage);


        productname.setText(prname);
        productcost.setText(prcost);
        productacid.setText(pracid);




    }

    public void gotopaymentsection(View view) {
        Intent intent=new Intent(getApplicationContext(),paymentSection.class);
        startActivity(intent);
    }

    public void gotomain(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}