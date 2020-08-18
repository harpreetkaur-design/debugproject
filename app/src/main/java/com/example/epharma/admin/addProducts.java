package com.example.epharma.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.epharma.R;

public class addProducts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);
    }

    public void adddigestive(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","digestive");
        startActivity(intent);
    }

    public void addmakeup(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","makeup");
        startActivity(intent);
    }

    public void addskin(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","skincare");
        startActivity(intent);
    }

    public void addhaircare(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","haircare");
        startActivity(intent);
    }

    public void adddallergic(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","allergic");
        startActivity(intent);
    }

    public void addrespiratory(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","respiratory");
        startActivity(intent);
    }

    public void addnervous(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","nervous");
        startActivity(intent);
    }

    public void addcardi(View view) {
        Intent intent=new Intent(getApplicationContext(),additionOfProduct.class);
        intent.putExtra("code","cardivascular");
        startActivity(intent);
    }
}
