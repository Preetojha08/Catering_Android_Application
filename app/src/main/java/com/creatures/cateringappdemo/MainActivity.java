package com.creatures.cateringappdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences main_shared_preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        int SPLASH_TIME = 3000; //This is 3 seconds

        main_shared_preferences=getSharedPreferences("MyPREFERENCES", Context.MODE_MULTI_PROCESS);
        int a;
        a=main_shared_preferences.getInt("welcomeCounterKey",-1);

        if(a==100)
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();
                    Intent mySuperIntent = new Intent(MainActivity.this, Home_Activity.class);
                    startActivity(mySuperIntent);
                    Log.i("Splash Screen Information","The Splash Screen is working Good in this application");

                    finish();
                }
            }, SPLASH_TIME );

        }
        else
        {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //Toast.makeText(MainActivity.this, ""+a, Toast.LENGTH_SHORT).show();
                    Intent mySuperIntent = new Intent(MainActivity.this, Welcome_Activity.class);
                    startActivity(mySuperIntent);
                    Log.i("Splash Screen Information","The Splash Screen is working in this application");

                    finish();
                }
            }, SPLASH_TIME );
        }




    }
}