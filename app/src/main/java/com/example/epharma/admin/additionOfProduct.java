package com.example.epharma.admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.epharma.R;
import com.example.epharma.pojo.pojoSignUp;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class additionOfProduct extends AppCompatActivity {
ImageView img;
    public Uri imguri;
    EditText productName,productAcid,productCost;
    private FirebaseAuth mAuth;
    public String TAG="";
    DatabaseReference reff;
    long maxid=0;
    pojoProduct pj;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_of_product);
        img=findViewById(R.id.imageView);
        productName=findViewById(R.id.pname);
        productAcid=findViewById(R.id.pacid);
        productCost=findViewById(R.id.pcost);
        code=getIntent().getStringExtra("code");
        Toast.makeText(getApplicationContext(),code,Toast.LENGTH_LONG).show();


        if (code.equals("digestive")) {
            reff = FirebaseDatabase.getInstance().getReference().child("Digestive");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }
        else if (code.equals("cardivascular"))
        {
            reff = FirebaseDatabase.getInstance().getReference().child("Cardivascular");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }
        else if (code.equals("respiratory"))
        {
            reff = FirebaseDatabase.getInstance().getReference().child("Respiratory");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }
        else if (code.equals("nervous"))
        {
            reff = FirebaseDatabase.getInstance().getReference().child("Nervous");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }
        else if (code.equals("allergic"))
        {
            reff = FirebaseDatabase.getInstance().getReference().child("Allergic");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }
        else if (code.equals("makeup"))
        {
            reff = FirebaseDatabase.getInstance().getReference().child("Makeup");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }
        else if (code.equals("skincare"))
        {
            reff = FirebaseDatabase.getInstance().getReference().child("Skincare");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }
        else if (code.equals("haircare"))
        {
            reff = FirebaseDatabase.getInstance().getReference().child("Haircare");
            reff.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists())
                        maxid = (dataSnapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pj = new pojoProduct();
        }

        }

    public void additem(View view) {
        pj.setProductname(productName.getText().toString().trim());
        pj.setProductacid(productAcid.getText().toString().trim());
        pj.setProductcost(productAcid.getText().toString().trim());

        reff.child(String.valueOf(productName.getText().toString())).setValue(pj);


    }

    public void uploadimage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 && resultCode == RESULT_OK && data !=null && data.getData()!= null)
        {
            imguri = data.getData();
            img.setImageURI(imguri);

        }
    }

}