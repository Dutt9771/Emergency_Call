package com.example.emergencycall;




import android.os.Bundle;

import android.app.Notification;

import android.graphics.Color;

import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;



import android.support.design.widget.NavigationView;

import android.support.v4.widget.DrawerLayout;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.emergencycall.databinding.ActivityMainBinding;


public class SecondActivity extends AppCompatActivity {
private Button btn;
    private NotificationManagerCompat notificationManager;
    private EditText editTextTitle;
    private EditText editTextTitle1;
   private EditText editTextMessage1;
    private EditText blood;
   private ImageView icimage;
    private EditText editTextMessage;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_gallery);
        TextView text = (TextView) findViewById(R.id.text);
        TextView title = (TextView) findViewById(R.id.title);
        ImageView image=(ImageView) findViewById(R.id.image);
        Button btn=(Button) findViewById(R.id.btn);
        notificationManager = NotificationManagerCompat.from(this);
        ImageView ic=(ImageView) findViewById(R.id.ic);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void sendOnChannel1(View v) {

        editTextTitle = (EditText) findViewById(R.id.edit_text_title);
        editTextMessage = (EditText) findViewById(R.id.edit_text_message);
        editTextTitle1 = (EditText) findViewById(R.id.edit_text_title1);
        editTextMessage1 = (EditText) findViewById(R.id.edit_text_message1);
        blood = (EditText) findViewById(R.id.bloodgroup);

        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();
        String title1 = editTextTitle1.getText().toString();
        String message1 = editTextMessage1.getText().toString();
        String bloods = blood.getText().toString();

        if (title.isEmpty() && message.isEmpty() && message1.isEmpty() && title1.isEmpty()) {
            Toast.makeText(SecondActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
return;
        }



       int SUMMARY_ID = 0;
        String GROUP_KEY_WORK_EMAIL = "com.android.example.WORK_EMAIL";

        Notification newMessageNotification1 =
                new NotificationCompat.Builder(SecondActivity.this, App.CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic)
                        .setContentTitle(title)
                        .setContentText(message)
                        .setGroup(GROUP_KEY_WORK_EMAIL)
                        .setGroupSummary(true)
                        .setColor(Color.RED)
.build();
        Notification newMessageNotification2 =
                new NotificationCompat.Builder(SecondActivity.this, App.CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic)
                        .setContentTitle(title1)
                        .setContentText(message1)
                        .setGroup(GROUP_KEY_WORK_EMAIL)
                        .setGroupSummary(true)
                        .build();

        Notification summaryNotification =
                new NotificationCompat.Builder(SecondActivity.this, App.CHANNEL_1_ID)
                        .setContentTitle(title)
                        .setContentText(message + "                                               " + "Blood Group : "+ bloods)
                        .setSmallIcon(R.drawable.ic)
                        .setGroup(GROUP_KEY_WORK_EMAIL)
                        .setGroupSummary(true)
                        .setOngoing(true)
                        .setColor(Color.RED)
                        .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(1, newMessageNotification1);
        notificationManager.notify(1, newMessageNotification2);
        notificationManager.notify(SUMMARY_ID, summaryNotification);




        android.app.Notification notification = new NotificationCompat.Builder(SecondActivity.this, App.CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic)
                .setContentTitle(title1)
                .setContentText(message1 + "                                               " + "Blood Group : "+ bloods)
                .setOngoing(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.RED)
                .build();
        notificationManager.notify(1, notification);

    }



    private void getAutofillId(EditText editTextTitle) {
        String title = editTextTitle.getText().toString();
        String message = editTextMessage.getText().toString();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}








