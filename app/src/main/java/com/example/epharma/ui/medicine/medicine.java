package com.example.epharma.ui.medicine;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.epharma.digestiveSystem;
import com.example.epharma.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.epharma.R;

public class medicine extends Fragment {

    LinearLayout digestivesystem,cardilayout,nervouslayout,allergiclayout,respiratorylayout;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_medicine, container, false);
        digestivesystem=root.findViewById(R.id.dgss);
        cardilayout=root.findViewById(R.id.cardilayout);
        nervouslayout=root.findViewById(R.id.nervouslayout);
        allergiclayout=root.findViewById(R.id.allergiclayout);
        respiratorylayout=root.findViewById(R.id.resplayout);



        digestivesystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(), digestiveSystem.class);
                startActivity(intent);
            }
        });

        cardilayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), cardivascularSystem.class);
                startActivity(intent);
            }
        });

        nervouslayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), nervousSystem.class);
                startActivity(intent);
            }
        });

        allergiclayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), allergicSystem.class);
                startActivity(intent);
            }
        });

        respiratorylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), respiratorySystem.class);
                startActivity(intent);
            }
        });

        return root;
    }
}