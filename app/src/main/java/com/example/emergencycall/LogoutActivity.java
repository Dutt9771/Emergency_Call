package com.example.emergencycall;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class LogoutActivity extends FragmentActivity {
    private String TAG = null;
    private static final String INTENT_FILTER_USER_LOGOUT = "org.abhi.app.logout";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);



    }
}



