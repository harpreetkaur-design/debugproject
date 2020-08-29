package com.example.epharma;
/**
 * Customer login page to go inside application
 * @author harpreet kaur
 */
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.epharma.enteredMail;
import android.content.Intent;
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


public class customerLogIn extends AppCompatActivity {
    EditText mail,password;
    private FirebaseAuth mAuth;
    public String TAG="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_log_in);
        mAuth = FirebaseAuth.getInstance();
        mail=findViewById(R.id.email);
        password=findViewById(R.id.pass);
    }

    /**
     * go to registraion section
     */
    public void gotosignup(View view) {
        Intent intent=new Intent(this,signUp.class);
        startActivity(intent);
    }

    /**
     * go to inside the app
     */
    public void goinsideApp(View view) {

        mAuth.signInWithEmailAndPassword(mail.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent =new Intent(customerLogIn.this,MainActivity.class);
                            enteredMail.mailId=mail.getText().toString();
                            intent.putExtra("usermail",mail.getText().toString());
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(customerLogIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });



    }
}