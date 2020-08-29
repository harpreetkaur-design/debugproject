package com.example.epharma.admin;
/**
 * admin login section
 * @author Rajan
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.epharma.R;

public class adminLogIn extends AppCompatActivity {
EditText email,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
    }

    public void insideadmin(View view) {
        if (email.getText().toString().equals("admin@gmail.com") && pass.getText().toString().equals("admin") )
        {
            Intent intent = new Intent(getApplicationContext(), addProducts.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"check email and password",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), adminLogIn.class);
            startActivity(intent);
        }
    }
}