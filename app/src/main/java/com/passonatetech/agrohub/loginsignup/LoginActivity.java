package com.passonatetech.agrohub.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.cropcalender.CropCalender;

public class LoginActivity extends AppCompatActivity {
    private TextView createnewaccount;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
         createnewaccount=findViewById(R.id.dont_have_account);
         usernameEditText = findViewById(R.id.username);
         passwordEditText = findViewById(R.id.email);
         submitButton = findViewById(R.id.loginbtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });


        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotosignup();
            }
        });
    }

    private void login() {
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("Please enter a valid username.");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Please enter a valid password.");
            return;
        }

        // Perform further validation and authentication here.

        loginsuccess();
    }

    private void loginsuccess() {
        Intent intent=new Intent(LoginActivity.this, CropCalender.class);
        startActivity(intent);
        finish();
    }
    private void gotosignup() {
        Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}