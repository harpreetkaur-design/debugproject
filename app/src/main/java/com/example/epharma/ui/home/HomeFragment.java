package com.example.epharma.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.epharma.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.epharma.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    Button digestivesys,respisys,nervoussys,allergicsys,cardisys;
    Button makeupsystem,haircaresystem,skincaresystem;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        digestivesys=root.findViewById(R.id.digestivesys);
        respisys=root.findViewById(R.id.respiratorysys);
        nervoussys=root.findViewById(R.id.nervoussys);
        allergicsys=root.findViewById(R.id.allergicsys);
        cardisys=root.findViewById(R.id.cardisys);
        makeupsystem=root.findViewById(R.id.makeupsys);
        haircaresystem=root.findViewById(R.id.haircaresys);
        skincaresystem=root.findViewById(R.id.skincaresys);



        return root;
    }
}