package com.example.epharma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.example.epharma.models.*;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class digestiveSystem extends AppCompatActivity {
    RecyclerView mFirestoreList;
    FirebaseFirestore firebaseFirestore;
    FirestoreRecyclerAdapter adapter;

    FirebaseStorage firebaseStorage2;
    StorageReference storageReference2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digestive_system);
       mFirestoreList=findViewById(R.id.recy);
firebaseFirestore=FirebaseFirestore.getInstance();

        firebaseStorage2 = FirebaseStorage.getInstance();
        storageReference2 = firebaseStorage2.getReference();


//QUERY
        Query query=firebaseFirestore.collection("digestive");

        //RECYCLER OPTIONS
        FirestoreRecyclerOptions<product> options=new FirestoreRecyclerOptions.Builder<product>()
                .setQuery(query,product.class)
                .build();

    adapter= new FirestoreRecyclerAdapter<product, ProductsViewHolder>(options) {
            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
              View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsdigestive,parent,false);
              return new ProductsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull final ProductsViewHolder holder, int position, @NonNull final product model) {
                holder.productname.setText(model.getProductname());
                holder.productacid.setText(model.getProductacid());
                holder.productcost.setText(model.getProductcost());

                StorageReference imageRef2 = storageReference2.child("images/"+model.getProductimage());
Toast.makeText(getApplicationContext(),model.getProductimage(),Toast.LENGTH_LONG).show();
                imageRef2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        // Picasso.get().load(uri).into(userpic);
                        Glide.with(getApplicationContext())
                                .load(uri)
                                .circleCrop()
                                .into(holder.medimage);


                        // Toast.makeText(getContext(),"Success.",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Toast.makeText(getContext(),"fail.",Toast.LENGTH_SHORT).show();
                    }
                });



                holder.digeslayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(getApplicationContext(), productOpened.class);
                        intent.putExtra("pname",holder.productname.getText().toString());
                        intent.putExtra("pacid",holder.productacid.getText().toString());
                        intent.putExtra("pimage",model.getProductimage());
                        intent.putExtra("pcost",holder.productcost.getText().toString());
                        startActivity(intent);

                    }
                });

            }
        };
mFirestoreList.setHasFixedSize(true);
mFirestoreList.setLayoutManager(new LinearLayoutManager(this));
mFirestoreList.setAdapter(adapter);

    }


    public void gotomain(View view) {
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    private class ProductsViewHolder extends RecyclerView.ViewHolder{
TextView productname,productacid,productcost;
ImageView medimage;
LinearLayout digeslayout;
        public ProductsViewHolder(@NonNull View itemView) {
            super(itemView);
            productname=itemView.findViewById(R.id.dmedicinename);
            productacid=itemView.findViewById(R.id.dmedicineacid);
            productcost=itemView.findViewById(R.id.dmedicinecost);
            medimage=itemView.findViewById(R.id.medimage);
            digeslayout=itemView.findViewById(R.id.diglayout);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}