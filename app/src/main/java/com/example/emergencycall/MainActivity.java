package com.example.emergencycall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class MainActivity extends AppCompatActivity {

    private RatingBar ratingBar;
    private Button button;
    private TextView ratingVal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingVal=(TextView) findViewById(R.id.ratingVal);
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                ratingVal.setText("Current Rating  : "+String.valueOf(rating));

            }
        });

        button = (Button) findViewById(R.id.button);
        Toast.makeText(MainActivity.this, "You Clicked on Button..", Toast.LENGTH_LONG).show();
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

              //  Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();


            }

        });

    }
}