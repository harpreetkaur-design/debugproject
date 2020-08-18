package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;
import com.example.epharma.admin.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chooseSection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_section);
    }

    public void admin(View view) {
        Intent intent=new Intent(getApplicationContext(),adminLogIn.class);
        startActivity(intent);
    }

    public void client(View view) {
        Intent intent=new Intent(getApplicationContext(),customerLogIn.class);
        startActivity(intent);
    }
}