package com.example.epharma;
/**
 * Choose admin or user section
 * @author Rajan
 */
import androidx.appcompat.app.AppCompatActivity;
import com.example.epharma.admin.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chooseSection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_section);
    }
    /**
     * go to admin section
     */
    public void admin(View view) {
        Intent intent=new Intent(getApplicationContext(),adminLogIn.class);
        startActivity(intent);
    }
    /**
     * go to client login section
     */
    public void client(View view) {
        Intent intent=new Intent(getApplicationContext(),customerLogIn.class);
        startActivity(intent);
    }
}