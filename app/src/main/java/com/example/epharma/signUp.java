package com.example.epharma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.security.PublicKey;
import com.example.epharma.models.*;

public class signUp extends AppCompatActivity {
EditText email,password,firstname,lastname,number,address,postal,city,province,country;
    private FirebaseAuth mAuth;
    public String TAG="";
    long maxid=0;
    FirebaseFirestore db;

    String finmail;
    String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        db=FirebaseFirestore.getInstance();

        email=findViewById(R.id.email);
        password=findViewById(R.id.pass);
        firstname=findViewById(R.id.fname);
        lastname=findViewById(R.id.lname);
        number=findViewById(R.id.number);
        address=findViewById(R.id.address);
        postal=findViewById(R.id.postal);
        city=findViewById(R.id.city);
        province=findViewById(R.id.province);
        country=findViewById(R.id.country);


    }

    public void createaccount(View view) {


        mail=email.getText().toString().trim();
        int ind= mail.indexOf("@");
        finmail=mail.substring(0,ind);
        Toast.makeText(getApplicationContext(),finmail,Toast.LENGTH_LONG).show();



        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_LONG).show();
                            tofirestore();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(signUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }

    public  void tofirestore(){
        Users users=new Users(firstname.getText().toString(),lastname.getText().toString(),email.getText().toString(),
                number.getText().toString(),address.getText().toString(),password.getText().toString(),
                postal.getText().toString(),city.getText().toString(),province.getText().toString(),country.getText().toString());
        db.collection("Users")
                .document(finmail).set(users);
        Toast.makeText(getApplicationContext(),"Registraion Succesfull",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,customerLogIn.class);
        startActivity(intent);

    }


}