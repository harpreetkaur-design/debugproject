package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class customerLogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_log_in);
    }

    public void gotosignup(View view) {
        Intent intent=new Intent(this,signUp.class);
        startActivity(intent);
    }

    public void goinsideApp(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}