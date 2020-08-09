package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class paymentSection extends AppCompatActivity {
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_section);

     name=   getIntent().getStringExtra("productname" );

        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
    }

    public void gotofinalpage(View view) {
        Intent intent=new Intent(getApplicationContext(),deleiveryDone.class);
        startActivity(intent);
    }
}