package com.example.epharma;

import androidx.appcompat.app.AppCompatActivity;
import com.example.epharma.models.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.epharma.models.Users;
import com.google.firebase.firestore.FirebaseFirestore;

public class deleiveryDone extends AppCompatActivity {
String phone,email,adress,postal,city,province,cvv,cardtype,cardnumber;
String pname,pacid,pcost;
    FirebaseFirestore db;
  public   String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleivery_done);
        db=FirebaseFirestore.getInstance();
        TAG="finish sending mail";
        phone=getIntent().getStringExtra("phone");
        email=getIntent().getStringExtra("email");
        adress=getIntent().getStringExtra("adress");
        postal=getIntent().getStringExtra("postal");
        city=getIntent().getStringExtra("city");
        province=getIntent().getStringExtra("province");
        cvv=getIntent().getStringExtra("cvv");
        cardtype=getIntent().getStringExtra("cardtype");
        cardnumber=getIntent().getStringExtra("cardnumber");
        pname=getIntent().getStringExtra("pname");
        pcost=getIntent().getStringExtra("pcost");
        pacid=getIntent().getStringExtra("pacid");
    }

    public void returntohomepage(View view) {
        shoppingDetails shoppingdet=new shoppingDetails(email,phone,adress,
              postal,city,province,
               pname,pcost,pacid);
        db.collection("Bookings")
                .document(email).set(shoppingdet);
        Toast.makeText(getApplicationContext(),"Booking Succesfull",Toast.LENGTH_LONG).show();

    Intent intent=new Intent(getApplicationContext(),MainActivity.class);

        startActivity(intent);
    }
}