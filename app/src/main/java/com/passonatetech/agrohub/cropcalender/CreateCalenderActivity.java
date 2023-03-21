package com.passonatetech.agrohub.cropcalender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.passonatetech.agrohub.R;

public class CreateCalenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_calender);
        Spinner areaUnitSpinner = findViewById(R.id.area_unit_spinner);
        ArrayAdapter<CharSequence> areaUnitAdapter = ArrayAdapter.createFromResource(this, R.array.area_unit_array, android.R.layout.simple_spinner_item);
        areaUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaUnitSpinner.setAdapter(areaUnitAdapter);

        Spinner quantityUnitSpinner = findViewById(R.id.quantity_unit_spinner);
        ArrayAdapter<CharSequence> quantityUnitAdapter = ArrayAdapter.createFromResource(this, R.array.quantity_unit_array, android.R.layout.simple_spinner_item);
        quantityUnitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quantityUnitSpinner.setAdapter(quantityUnitAdapter);
    }
}