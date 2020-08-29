package com.example.epharma.admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.epharma.MainActivity;
import com.example.epharma.models.*;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.epharma.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class additionOfProduct extends AppCompatActivity {
ImageView img;
    public Uri imguri;
    String code;
    EditText productname,productcost,productacid;
 public    String productImageName;
    FirebaseFirestore db;
    private StorageTask uploadTask;
    StorageReference mstorageRef;
    String a;
    String b;

    private Uri filePath;
    FirebaseStorage storage;
    StorageReference storageReference;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_of_product);
        db=FirebaseFirestore.getInstance();

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        productname=findViewById(R.id.pname);
        productacid=findViewById(R.id.pacid);
        productcost=findViewById(R.id.pcost);
        img=findViewById(R.id.imageView);
        mstorageRef = FirebaseStorage.getInstance().getReference("Images");
        code=getIntent().getStringExtra("code");
        Toast.makeText(getApplicationContext(),code,Toast.LENGTH_LONG).show();


        }



    public void uploadimage(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1);
    }

    private String getExtension(Uri uri) {
        ContentResolver cr = getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();
        return mimeTypeMap.getExtensionFromMimeType(cr.getType(uri));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1 && resultCode == RESULT_OK && data !=null && data.getData()!= null)
        {
            imguri = data.getData();
            filePath=data.getData();
            img.setImageURI(imguri);

        }
    }

    public void additem(View view) {
        product prdct=new product(productname.getText().toString(),productcost.getText().toString(),productacid.getText().toString(),productname.getText().toString()+"_"+code);
        db.collection(code)
                .document(productname.getText().toString()).set(prdct);
        Toast.makeText(getApplicationContext(),"Product Addition Succesfull",Toast.LENGTH_LONG).show();
        sendImageToStorag();

    }
public void sendImageToStorag()
{

    if (filePath != null) {

        // Code for showing progressDialog while uploading
        final ProgressDialog progressDialog
                = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();


        StorageReference ref
                = storageReference
                .child(
                        "images/"
                                + productname.getText().toString()+"_"+code);

        ref.putFile(filePath)
                .addOnSuccessListener(
                        new OnSuccessListener<UploadTask.TaskSnapshot>() {

                            @Override
                            public void onSuccess(
                                    UploadTask.TaskSnapshot taskSnapshot)
                            {

                                // Image uploaded successfully
                                // Dismiss dialog
                                progressDialog.dismiss();
                                Toast.makeText(additionOfProduct.this,
                                                "Image Uploaded!!",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        })

                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e)
                    {

                        // Error, Image not uploaded
                        progressDialog.dismiss();
                        Toast
                                .makeText(additionOfProduct.this,
                                        "Failed " + e.getMessage(),
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                })
                .addOnProgressListener(
                        new OnProgressListener<UploadTask.TaskSnapshot>() {

                            // Progress Listener for loading
                            // percentage on the dialog box
                            @Override
                            public void onProgress(
                                    UploadTask.TaskSnapshot taskSnapshot)
                            {
                                double progress
                                        = (100.0
                                        * taskSnapshot.getBytesTransferred()
                                        / taskSnapshot.getTotalByteCount());
                                progressDialog.setMessage(
                                        "Uploaded "
                                                + (int)progress + "%");
                            }
                        });


}
}}