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
    /**** ****/

    private Spinner seasonspinner, typesofcrops, cropsname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Spinner seasonSpinner = findViewById(R.id.season_spinner);
        Spinner categorySpinner = findViewById(R.id.types_of_crop_spinner);
        Spinner typeSpinner = findViewById(R.id.crop_name_spinner);
        // In_Rabi_Cereals = getResources().getStringArray(R.array.In_Rabi_Cereals);
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
                this, R.array.seasons, android.R.layout.simple_spinner_item);
        seasonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seasonSpinner.setAdapter(seasonAdapter);
        seasonSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String[] categories = null;
                switch (position) {
                    case 0: // Rabi
                        categories = getResources().getStringArray(R.array.In_Rabi);
                        break;
                    case 1: // Kharif
                        categories = getResources().getStringArray(R.array.In_Kharif);
                        break;
                    case 2: // Zaid
                        categories = getResources().getStringArray(R.array.In_zaid);
                        break;
                }
                ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                        DetailsActivity.this, android.R.layout.simple_spinner_item, categories);
                categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                categorySpinner.setAdapter(categoryAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // Do nothing
            }
        });

// ArrayAdapter for the crop type spinner
 /*       typesofcrops.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                // Get selected season
                String cropsname = parent.getItemAtPosition(position).toString();
                // Create array adapter for item spinner based on selected season
                ArrayAdapter<CharSequence> itemAdapter;
                if(cropsname.equals("") ){}
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String[] types = null;
                String season = seasonSpinner.getSelectedItem().toString();
                String category = categorySpinner.getSelectedItem().toString();
                if (season.equals("") || category.equals("")) {
                    types = new String[]{};
                } else if (season.equals("Rabi")) {
                    if (category.equals("Cereals")) {
                        types = getResources().getStringArray(R.array.In_Rabi_Cereals);
                    } else if (category.equals("Vegetables")) {
                        types = getResources().getStringArray(R.array.In_Rabi_vegetables);
                    } else if (category.equals("Fruits")) {
                        types = getResources().getStringArray(R.array.In_Rabi_Fruits);
                    } else if (category.equals("Legumes")) {
                        types = getResources().getStringArray(R.array.In_Rabi_Legumes);
                    }
                } else if (season.equals("Kharif")) {
                    if (category.equals("Cereals")) {
                        types = getResources().getStringArray(R.array.In_Kharif_Cereals);
                    } else if (category.equals("Vegetables")) {
                        types = getResources().getStringArray(R.array.In_Kharif_vegetables);
                    } else if (category.equals("Fruits")) {
                        types = getResources().getStringArray(R.array.In_Kharif_Fruits);
                    } else if (category.equals("Legumes")) {
                        types = getResources().getStringArray(R.array.In_Kharif_Legumes);
                    } else if (category.equals("SeedPlants")) {
                        types = getResources().getStringArray(R.array.In_Kharif_SeedPlants);
                    } else if (category.equals("Medicinal")) {
                        types = getResources().getStringArray(R.array.In_Kharif_Medicinal);
                    }
                } else if (season.equals("Zaid")) {
                    if (category.equals("Cereals")) {
                        types = getResources().getStringArray(R.array.In_Zaid_Cereals);
                    } else if (category.equals("Vegetables")) {
                        types = getResources().getStringArray(R.array.In_Zaid_vegetables);
                    } else if (category.equals("Fruits")) {
                        types = getResources().getStringArray(R.array.In_Zaid_Fruits);
                    } else if (category.equals("Legumes")) {
                        types = getResources().getStringArray(R.array.In_Zaid_Legumes);
                    } else if (category.equals("SeedPlants")) {
                        types = getResources().getStringArray(R.array.In_Zaid_SeedPlants);
                    } else if (category.equals("Cash Crops")) {
                        types = getResources().getStringArray(R.array.In_Zaid_CashCrops);
                    }
                }
                ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, types);
                categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                typeSpinner.setAdapter(categoryAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //
            }
        });


// ArrayAdapter for the crop name spinner


        /////////////////////////////////////////////////


    }
}