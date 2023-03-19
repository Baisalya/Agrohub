package com.passonatetech.agrohub.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.passonatetech.agrohub.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        TextView createnewaccount=findViewById(R.id.dont_have_account);
        createnewaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotosignup();
            }
        });
    }

    private void gotosignup() {
        Intent intent=new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}