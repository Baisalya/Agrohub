package com.passonatetech.agrohub.loginsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.cropcalender.CropCalender;

public class OrganizationRegistation extends AppCompatActivity {
    private EditText organizationNameEditText;
    private Spinner organizationTypeSpinner;
    private EditText contactPersonNameEditText;
    private EditText contactPersonPhoneNumberEditText;
    private EditText emailEditText;
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
        organizationTypeSpinner.setBackgroundColor(ContextCompat.getColor(OrganizationRegistation.this, R.color.btn));

        emailEditText=findViewById(R.id.email);
        //  contactPersonNameEditText = findViewById(R.id.contactPersonNameEditText);
        contactPersonPhoneNumberEditText = findViewById(R.id.contactPersonPhoneEditText);
        //  organizationAddressEditText = findViewById(R.id.organizationAddressEditText);
        websiteURLEditText = findViewById(R.id.websiteUrlEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signUpButton = findViewById(R.id.signupButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.organization_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        organizationTypeSpinner.setAdapter(adapter);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Orginazationregistartion();
            }
        });
    }

    private void Orginazationregistartion() {


        String organizationType = organizationTypeSpinner.getSelectedItem().toString();
        String organizationName = organizationNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String websiteUrl = websiteURLEditText.getText().toString();
        String username = usernameEditText.getText().toString();
        String contactPersonPhone = contactPersonPhoneNumberEditText.getText().toString();
        String password = passwordEditText.getText().toString();


        if (TextUtils.isEmpty(organizationName)) {
            organizationNameEditText.setError("Organization name is required");
            return;
        }
        if (TextUtils.isEmpty(email)){
            emailEditText.setError("Email is Required"); 
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Invalid email format");
            return;
        }

        if (TextUtils.isEmpty(websiteUrl)) {
            websiteURLEditText.setError("websiteUrl is required");
            return;
        }

        if (TextUtils.isEmpty(username)) {
            usernameEditText.setError("username  is required");
            return;
        }

        if (TextUtils.isEmpty(contactPersonPhone)) {
            contactPersonPhoneNumberEditText.setError("Phoneno is required");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEditText.setError("Password is required");
            return;
        } else {
            register();
            Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
        }

    }
    private void register() {
        Intent intent = new Intent(OrganizationRegistation.this, CropCalender.class);
        startActivity(intent);
        finish();
    }
}