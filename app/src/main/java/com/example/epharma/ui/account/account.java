package com.example.epharma.ui.account;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.epharma.R;
import com.example.epharma.enteredMail;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class account extends Fragment {

    TextView mailadress, namel, namef, phnnumber, fulladress, pstl, city, province, country;
    FirebaseFirestore db;
    public static String TAG = "";
    String ml;
    int index;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        ml = enteredMail.mailId;
        index = ml.indexOf("@");
        ml = ml.substring(0, index);
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        mailadress = view.findViewById(R.id.mailadress);
        namel = view.findViewById(R.id.namel);
        namef = view.findViewById(R.id.namef);
        phnnumber = view.findViewById(R.id.phnnumber);
        fulladress = view.findViewById(R.id.fulladress);
        pstl = view.findViewById(R.id.pstl);
        city = view.findViewById(R.id.city);
        province = view.findViewById(R.id.province);
        country = view.findViewById(R.id.country);

        DocumentReference docRef = db.collection("Users").document(ml);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document != null && document.exists()) {

                        fulladress.setText(document.getString("address"));
                        mailadress.setText(document.getString("email"));
                        namef.setText(document.getString("firstName"));
                        namel.setText(document.getString("lastName"));
                        phnnumber.setText(document.getString("contactNumber"));
                        pstl.setText(document.getString("postalCode"));
                        city.setText(document.getString("city"));
                        province.setText(document.getString("province"));
                        country.setText(document.getString("country"));

                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });


        retrieve();
        return view;
    }

    public void retrieve() {

    }


}