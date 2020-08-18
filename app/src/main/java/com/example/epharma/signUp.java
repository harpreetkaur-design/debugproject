package com.example.epharma;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.epharma.pojo.*;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signUp extends AppCompatActivity {
EditText email,password,firstname,lastname,number,address,postal,city,province,country;
    private FirebaseAuth mAuth;
    public String TAG="";
    DatabaseReference reff;
    long maxid=0;
    String finmail;
    String mail;
    pojoSignUp pj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
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
        reff= FirebaseDatabase.getInstance().getReference().child("Users");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        pj=new pojoSignUp();

    }

    public void createaccount(View view) {


        mail=email.getText().toString().trim();
        int ind= mail.indexOf("@");
        finmail=mail.substring(0,ind);
        Toast.makeText(getApplicationContext(),finmail,Toast.LENGTH_LONG).show();

        pj.setFirstName(firstname.getText().toString().trim());
        pj.setLastName(lastname.getText().toString().trim());
        pj.setEmail(email.getText().toString().trim());
        pj.setContactNumber(number.getText().toString().trim());
        pj.setAddress(address.getText().toString().trim());
        pj.setPassword(password.getText().toString().trim());
        pj.setPostalCode(postal.getText().toString().trim());
        pj.setCity(city.getText().toString().trim());
        pj.setProvince(province.getText().toString().trim());
        pj.setCountry(country.getText().toString().trim());

        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_LONG).show();
                            reff.child(String.valueOf(finmail)).setValue(pj);
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


}