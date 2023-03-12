package com.passonatetech.agrohub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.passonatetech.agrohub.onbordingscreen.OnboardingScreen;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intentHome = new Intent(HomePage.this, OnboardingScreen.class);
                        startActivity(intentHome);
                        break;
                    case R.id.calender:
                        Intent intentDashboard = new Intent(HomePage.this, Task.class);
                        startActivity(intentDashboard);
                        break;
                    case R.id.Alert:
                        Intent intentNotifications = new Intent(HomePage.this, OnboardingScreen.class);
                        startActivity(intentNotifications);
                        break;
                }
                return true;
            }
        });


    }
}