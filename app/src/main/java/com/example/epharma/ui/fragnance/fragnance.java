package com.example.epharma.ui.fragnance;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import com.example.epharma.*;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.epharma.R;
import com.example.epharma.ui.skin_care.SlideshowViewModel;


public class fragnance extends Fragment {
    private SlideshowViewModel slideshowViewModel;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_fragnance, container, false);


        progressBar = root.findViewById(R.id.progressBar);
        textView =root.findViewById(R.id.textView);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            textView.setText(progressStatus+"/"+progressBar.getMax());
                        }
                    });
                    try {
                        // Sleep for 200 milliseconds.
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    return  root;
    }
}