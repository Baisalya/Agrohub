package com.passonatetech.agrohub.loginsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.cropcalender.CropCalender;

import java.util.Calendar;

public class ExpertRegistration extends AppCompatActivity {
 private EditText EmailController,ContactInfoController,LocationController,EducationController,PasswordController;
private Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_registration);
        EmailController=findViewById(R.id.email_edit_text);
        ContactInfoController=findViewById(R.id.contactinfo_edit_text);
        LocationController=findViewById(R.id.location_edit_text);
        EducationController=findViewById(R.id.education_edit_text);
        PasswordController=findViewById(R.id.password_Edit_Text);
        Submit=findViewById(R.id.submit);
        RadioGroup expertiseRadioGroup = findViewById(R.id.expertise_radio_group);
        expertiseRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton checkedRadioButton = radioGroup.findViewById(checkedId);
                String selectedOption = checkedRadioButton.getText().toString();
                // do something with selectedOption
            }
        });
// Get the text from the EditText views
        String email = EmailController.getText().toString();
        String contactInfo = ContactInfoController.getText().toString();
        String location = LocationController.getText().toString();
        String education = EducationController.getText().toString();
        String password = PasswordController.getText().toString();
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(submitValidation()==true){
                  RegisterSucess();
                }
            }
        });
    }

    private void RegisterSucess() {
        Intent intent=new Intent(ExpertRegistration.this, CropCalender.class);
        startActivity(intent);
        finish();
    }
    //Intent

    private boolean submitValidation() {
        // Get the EditText views
        EditText emailEditText = findViewById(R.id.email_edit_text);
        EditText contactInfoEditText = findViewById(R.id.contactinfo_edit_text);
        EditText locationEditText = findViewById(R.id.location_edit_text);
        EditText educationEditText = findViewById(R.id.education_edit_text);
        EditText passwordEditText = findViewById(R.id.password_Edit_Text);

        // Get the selected radio button from the expertise radio group
        RadioGroup expertiseRadioGroup = findViewById(R.id.expertise_radio_group);
        int selectedExpertiseId = expertiseRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedExpertiseRadioButton = null;
        if (selectedExpertiseId != -1) {
            selectedExpertiseRadioButton = findViewById(selectedExpertiseId);
        }
        String selectedExpertise = "";
        if (selectedExpertiseRadioButton != null) {
            selectedExpertise = selectedExpertiseRadioButton.getText().toString();
        }

        // Get the text from the EditText views
        String email = emailEditText.getText().toString();
        String contactInfo = contactInfoEditText.getText().toString();
        String location = locationEditText.getText().toString();
        String education = educationEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Validate the input fields
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("Please enter a valid email address");
            emailEditText.requestFocus();
            return false;
        }

        if (contactInfo.isEmpty()) {
            contactInfoEditText.setError("Please enter your contact information");
            contactInfoEditText.requestFocus();
            return false;
        }

        if (location.isEmpty()) {
            locationEditText.setError("Please enter your location");
            locationEditText.requestFocus();
            return false;
        }

        if (education.isEmpty()) {
            educationEditText.setError("Please enter your education");
            educationEditText.requestFocus();
            return false;
        }

        if (password.isEmpty() || password.length() < 6) {
            passwordEditText.setError("Please enter a password with at least 6 characters");
            passwordEditText.requestFocus();
            return false;
        }

        if (selectedExpertise.isEmpty()) {
            Toast.makeText(this, "Please select your expertise", Toast.LENGTH_SHORT).show();
            return false;
        }

        // If all input fields are valid, return true
        return true;
    }


}