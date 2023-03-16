package com.passonatetech.agrohub.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.Task;
import com.passonatetech.agrohub.cropcalender.CropCalender;
import com.passonatetech.agrohub.onbordingscreen.OnboardingScreen;
import com.passonatetech.agrohub.widgets.AlertBox;

public class RegistrationActivity extends AppCompatActivity {
    private EditText NameEditText;
    private EditText PhoneEditText;
    private EditText PasswordEditText;
    private Spinner AccountTypeSpinner;
    private static final int REQUEST_CODE_ALERT_BOX = 1;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);
        //ui object name assign
        NameEditText = findViewById(R.id.name);
        PhoneEditText = findViewById(R.id.phoneno);
        PasswordEditText = findViewById(R.id.password);
        AccountTypeSpinner = findViewById(R.id.account_type);
        Button registerButton = findViewById(R.id.register_button);
        TextView alreadyRegister = findViewById(R.id.already_registered);
        /*** background   video        ****/
        videoView=findViewById(R.id.videoview);
        String path="android.resource://com.passonatetech.agrohub/"+R.raw.regdvdo;
        Uri u=Uri.parse(path);
        videoView.setVideoURI(u);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        //for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.account_types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AccountTypeSpinner.setAdapter(adapter);
        //
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
        alreadyRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnlogin();
            }
        });

    }

    private void registerUser() {
        String name = NameEditText.getText().toString().trim();
        String email = PhoneEditText.getText().toString().trim();
        String password = PasswordEditText.getText().toString().trim();
        String accountType = AccountTypeSpinner.getSelectedItem().toString();

        //  validation on  input
        if (TextUtils.isEmpty(name)) {
            NameEditText.setError("Please enter your name");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            PhoneEditText.setError("Please enter your phoneno");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            PasswordEditText.setError("Please enter your password");
            return;
        }if(AccountTypeSpinner.getSelectedItem().toString().equals("Organization") ){
            orgalert();
            //organisationSelected();
            return;

        }if(AccountTypeSpinner.getSelectedItem().toString().equals("Expert") ){
            Expertalert() ;
            //organisationSelected();
            return;

        }


        if (TextUtils.isEmpty(accountType)) {
            Toast.makeText(this, "Please select your account type", Toast.LENGTH_SHORT).show();
            return;
        }

        // Perform registration logic here, depending on the selected account type
        switch (accountType) {
            case "Farmer":
                // Register as a farmer
                break;
            case "Organization":
                // Register as an organization
                break;
            case "Expert":
                // Register as an expert
                break;
            default:
                Toast.makeText(this, "Invalid account type selected", Toast.LENGTH_SHORT).show();
                break;
        }

        //  successful registration
        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

        // Finish the activity and return to the login screen
        returnlogin();
        finish();
    }
    //Alredy register routes
    private void returnlogin() {
        Intent intent = new Intent(RegistrationActivity.this, CropCalender.class);
        startActivity(intent);
    }
    //if oganisation route
  /*  private void  organisationSelected(){
        Intent intent = new Intent(RegistrationActivity.this, OrganizationRegistation.class);
        startActivity(intent);
    }*/
    //Alert box and route for organization.
public void orgalert() {
    String message = "Are You Sure !! Sign Up as an Organization";
    Intent intent = new Intent(this, OrganizationRegistation.class);
    AlertBox.showAlert(this, message, intent);
}
    //Alert box and route for  expert.
    public void Expertalert() {
        String message = "Are You Sure !! Sign Up as an Expert";
        Intent intent = new Intent(this, ExpertRegistration.class);
        AlertBox.showAlert(this, message, intent);
    }
}