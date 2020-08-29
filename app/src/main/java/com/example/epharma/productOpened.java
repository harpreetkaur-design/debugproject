package com.example.epharma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class productOpened extends AppCompatActivity {
String prname,prcost,pracid;
String primage;

TextView productname,productacid,productcost;
ImageView productimage;

    FirebaseStorage firebaseStorage2;
    StorageReference storageReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_opened);


        firebaseStorage2 = FirebaseStorage.getInstance();
        storageReference2 = firebaseStorage2.getReference();

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

        StorageReference imageRef2 = storageReference2.child("images/"+primage);
        Toast.makeText(getApplicationContext(),primage,Toast.LENGTH_LONG).show();
        imageRef2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                // Picasso.get().load(uri).into(userpic);
                Glide.with(getApplicationContext())
                        .load(uri)
                        .circleCrop()
                        .into(productimage);


                // Toast.makeText(getContext(),"Success.",Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Toast.makeText(getContext(),"fail.",Toast.LENGTH_SHORT).show();
            }
        });





    }

    public void gotopaymentsection(View view) {
        Intent intent=new Intent(getApplicationContext(),paymentSection.class);
        intent.putExtra("pname",productname.getText().toString());
        intent.putExtra("pacid",productacid.getText().toString());
        intent.putExtra("pcost",productcost.getText().toString());
        startActivity(intent);
    }

    public void gotomain(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}