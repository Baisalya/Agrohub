package com.passonatetech.agrohub.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.passonatetech.agrohub.R;

public class OrganizationRegistation extends AppCompatActivity {
    private EditText organizationNameEditText;
    private Spinner organizationTypeSpinner;
    private EditText contactPersonNameEditText;
    private EditText contactPersonPhoneNumberEditText;
    private EditText organizationAddressEditText;
    private EditText websiteURLEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_register_page);

        organizationNameEditText = findViewById(R.id.organizationNameEditText);
        organizationTypeSpinner = findViewById(R.id.organizationTypeSpinner);
      //  contactPersonNameEditText = findViewById(R.id.contactPersonNameEditText);
        contactPersonPhoneNumberEditText = findViewById(R.id.contactPersonPhoneEditText);
      //  organizationAddressEditText = findViewById(R.id.organizationAddressEditText);
        websiteURLEditText = findViewById(R.id.websiteUrlEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.signupButton);
    }
}