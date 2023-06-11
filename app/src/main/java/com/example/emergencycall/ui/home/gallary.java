package com.example.emergencycall.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.emergencycall.R;

public class gallary extends AppCompatActivity {
    private ImageView ic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        ic=(ImageView) findViewById(R.id.ic);

    }
}