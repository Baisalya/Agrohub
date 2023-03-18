package com.passonatetech.agrohub.cropcalender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.passonatetech.agrohub.R;

public class DetailsActivity extends AppCompatActivity {
 /*   private Spinner seasonSpinner;
    private String[] seasons;
    private String[] cropsinrabi;
    private String[] cropsinkharif;
    private String[] cropsinzaid;
    private String[] In_Rabi_Cereals;
    private String[] In_Rabi_vegetables;
    private String[] In_Rabi_Fruits;
    private String[] In_Rabi_Legumes;
    private String[] In_Kharif_Cereals;
    private String[] In_Kharif_vegetables;
    private String[] In_Kharif_Fruits;
    private String[] In_Kharif_Legumes;
    private String[] In_Kharif_SeedPlants;
    private String[] In_Kharif_Medicinal;
    private String[] In_Zaid_Cereals;
    private String[] In_Zaid_vegetables;
    private String[] In_Zaid_Fruits;
    private String[] In_Zaid_Legumes;
    private String[] In_Zaid_SeedPlants;
    private String[] In_Zaid_CashCrops;*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
/*        seasonSpinner = findViewById(R.id.season_spinner);
        seasons = getResources().getStringArray(R.array.seasons);
        cropsinrabi = getResources().getStringArray(R.array.In_Rabi);
        cropsinkharif = getResources().getStringArray(R.array.seasons);
        cropsinzaid = getResources().getStringArray(R.array.seasons);
        In_Rabi_Cereals = getResources().getStringArray(R.array.In_Rabi_Cereals);
        In_Rabi_vegetables = getResources().getStringArray(R.array.In_Rabi_vegetables);
        In_Rabi_Fruits = getResources().getStringArray(R.array.In_Rabi_Fruits);
        In_Rabi_Legumes = getResources().getStringArray(R.array.In_Rabi_Legumes);
        In_Kharif_Cereals = getResources().getStringArray(R.array.In_Kharif_Cereals);
        In_Kharif_vegetables = getResources().getStringArray(R.array.In_Kharif_vegetables);
        In_Kharif_Fruits = getResources().getStringArray(R.array.In_Kharif_Fruits);
        In_Kharif_Legumes = getResources().getStringArray(R.array.In_Kharif_Legumes);
        In_Kharif_SeedPlants = getResources().getStringArray(R.array.In_Kharif_SeedPlants);
        In_Kharif_Medicinal = getResources().getStringArray(R.array.In_Kharif_Medicinal);
        In_Zaid_Cereals = getResources().getStringArray(R.array.In_Zaid_Cereals);
        In_Zaid_vegetables = getResources().getStringArray(R.array.In_Zaid_vegetables);
        In_Zaid_Fruits = getResources().getStringArray(R.array.In_Zaid_Fruits);
        In_Zaid_Legumes = getResources().getStringArray(R.array.In_Zaid_Legumes);
        In_Zaid_SeedPlants = getResources().getStringArray(R.array.In_Zaid_SeedPlants);
        In_Zaid_CashCrops = getResources().getStringArray(R.array.In_Zaid_CashCrops);*/
/*
        ArrayAdapter<String> seasonAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, seasons);
        seasonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seasonSpinner.setAdapter(seasonAdapter);
/////////////////
        seasonSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedSeason = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
        // ArrayAdapter for the season spinner
        ArrayAdapter<CharSequence> seasonAdapter = ArrayAdapter.createFromResource(
                this, R.array.season_array, android.R.layout.simple_spinner_item);
        seasonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner seasonSpinner = findViewById(R.id.season_spinner);
        seasonSpinner.setAdapter(seasonAdapter);

// ArrayAdapter for the crop type spinner
        ArrayAdapter<CharSequence> cropTypeAdapter = ArrayAdapter.createFromResource(
                this, R.array.crop_type_array, android.R.layout.simple_spinner_item);
        cropTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner cropTypeSpinner = findViewById(R.id.crop_type_spinner);
        cropTypeSpinner.setAdapter(cropTypeAdapter);

// ArrayAdapter for the crop name spinner
        ArrayAdapter<CharSequence> cropNameAdapter = ArrayAdapter.createFromResource(
                this, R.array.crop_name_array, android.R.layout.simple_spinner_item);
        cropNameAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner cropNameSpinner = findViewById(R.id.crop_name_spinner);
        cropNameSpinner.setAdapter(cropNameAdapter);


    }
}