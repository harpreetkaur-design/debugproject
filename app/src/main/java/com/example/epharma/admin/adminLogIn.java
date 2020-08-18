package com.example.epharma.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.epharma.R;

public class adminLogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);
    }

    public void insideadmin(View view) {
        Intent intent=new Intent(getApplicationContext(),addProducts.class);
        startActivity(intent);
    }
}