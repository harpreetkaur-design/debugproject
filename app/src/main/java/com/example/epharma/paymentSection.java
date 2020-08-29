package com.example.epharma;
/**
 * To add details of card and the adress
 * @author Sahila karra
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class paymentSection extends AppCompatActivity {
String name;
String card;
String pname,pacid,pcost;
EditText phn,adress,postal,city,province,cardnumber,cvv;
TextView email;
Spinner cardtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_section);
        cardtype = findViewById(R.id.cardtype);
        phn=findViewById(R.id.phn);
        email=findViewById(R.id.email);
        adress=findViewById(R.id.adress);
        postal=findViewById(R.id.postal);
        city=findViewById(R.id.city);
        province=findViewById(R.id.province);
        cardnumber=findViewById(R.id.cardnumber);
        cvv=findViewById(R.id.cvv);

        email.setText(enteredMail.mailId);

     name=   getIntent().getStringExtra("productname" );
        pname=   getIntent().getStringExtra("pname" );
        pacid=   getIntent().getStringExtra("pacid" );
        pcost=   getIntent().getStringExtra("pcost" );


    }
    /**
     * go to final page of app shpping
     */
    public void gotofinalpage(View view) {
        Intent intent=new Intent(getApplicationContext(),deleiveryDone.class);
        intent.putExtra("phone",phn.getText().toString());
        intent.putExtra("email",enteredMail.mailId);
        intent.putExtra("adress",adress.getText().toString());
        intent.putExtra("postal",postal.getText().toString());
        intent.putExtra("city",city.getText().toString());
        intent.putExtra("province",province.getText().toString());
        intent.putExtra("cardnumber",cardnumber.getText().toString());
        intent.putExtra("cvv",cvv.getText().toString());
        intent.putExtra("cardtype",cardtype.getSelectedItem().toString());
        intent.putExtra("pname",pname);
        intent.putExtra("pacid",pacid);
        intent.putExtra("pcost",pcost);

        startActivity(intent);
    }

}