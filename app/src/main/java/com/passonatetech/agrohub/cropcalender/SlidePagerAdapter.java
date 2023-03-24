package com.passonatetech.agrohub.cropcalender;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.model.Reminder;

import java.io.Serializable;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SlidePagerAdapter extends PagerAdapter {
    private Context mContext;
    private EditText protitle,proj_desc,Areaedittext,Quantitytext,Startdate,EndDate;
    int mYear, mMonth, mDay;
    DatePickerDialog datePickerDialog;
    private Spinner  seasonSpinner,categorySpinner,typeSpinner,Areaspinner,Quantityspinner;
    private TextView errorMessageTextView;
    public SlidePagerAdapter(Context context) {
        mContext = context;
    }
    CropCalender cropCalender=new CropCalender();
 //Reminder model
 private List<Reminder> reminderList = new ArrayList<>();
    Time midnight = Time.valueOf("00:00:00");



    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view;

        switch (position) {
            case 0:
                view = inflater.inflate(R.layout.activity_addtask, container, false);
                container.addView(view);
                Button addtodo=view.findViewById(R.id.addtask);
                addtodo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      // container.setCurrentItem(1, true);

                    }
                });
                // Add the view to the container

                return view;

            case 1:
                view = inflater.inflate(R.layout.activity_details, container, false);
                container.addView(view);
                 seasonSpinner = view.findViewById(R.id.season_spinner);
                 categorySpinner = view.findViewById(R.id.types_of_crop_spinner);
                 typeSpinner = view.findViewById(R.id.crop_name_spinner);
                 protitle=view.findViewById(R.id.projecttitle_EditText);
                 proj_desc=view.findViewById(R.id.projectdescription_Edittext);
                 //String title = protitle.getText().toString().trim();
                 //String desc = proj_desc.getText().toString().trim();
                // ArrayAdapter for the season spinner
                ArrayAdapter<CharSequence> seasonAdapter = ArrayAdapter.createFromResource(
                        mContext, R.array.seasons, android.R.layout.simple_spinner_item);
                seasonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                seasonSpinner.setAdapter(seasonAdapter);
                seasonSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        String[] categories = null;
                        switch (position) {
                            case 0: // Rabi
                                categories =mContext.getResources().getStringArray(R.array.In_Rabi);
                                break;
                            case 1: // Kharif
                                categories =mContext.getResources().getStringArray(R.array.In_Kharif);
                                break;
                            case 2: // Zaid
                                categories = mContext.getResources().getStringArray(R.array.In_zaid);
                                break;
                        }
                        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(
                                mContext, android.R.layout.simple_spinner_item, categories);
                        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        categorySpinner.setAdapter(categoryAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        // Do nothing
                    }
                });
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
                                types = mContext.getResources().getStringArray(R.array.In_Rabi_Cereals);
                            } else if (category.equals("Vegetables")) {
                                types =mContext. getResources().getStringArray(R.array.In_Rabi_vegetables);
                            } else if (category.equals("Fruits")) {
                                types = mContext.getResources().getStringArray(R.array.In_Rabi_Fruits);
                            } else if (category.equals("Legumes")) {
                                types = mContext.getResources().getStringArray(R.array.In_Rabi_Legumes);
                            }
                        } else if (season.equals("Kharif")) {
                            if (category.equals("Cereals")) {
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_Cereals);
                            } else if (category.equals("Vegetables")) {
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_vegetables);
                            } else if (category.equals("Fruits")) {
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_Fruits);
                            } else if (category.equals("Legumes")) {
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_Legumes);
                            } else if (category.equals("Seed Plant")) {
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_SeedPlants);
                            } else if (category.equals("Medicinal")) {
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_Medicinal);
                            }
                        } else if (season.equals("Zaid")) {
                            if (category.equals("Cereals")) {
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_Cereals);
                            } else if (category.equals("Vegetables")) {
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_vegetables);
                            } else if (category.equals("Fruits")) {
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_Fruits);
                            } else if (category.equals("Legumes")) {
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_Legumes);
                            } else if (category.equals("Seed Plant")) {
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_SeedPlants);
                            } else if (category.equals("Cash Crops")) {
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_CashCrops);
                            }
                        }
                        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(mContext.getApplicationContext(), android.R.layout.simple_spinner_item, types);
                        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        typeSpinner.setAdapter(categoryAdapter);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        //
                    }
                });

                    return view;

            case 2:
                view = inflater.inflate(R.layout.activity_create_calender, container, false);
                container.addView(view);
                 Areaspinner=view.findViewById(R.id.area_unit_spinner);
                 Quantityspinner=view.findViewById(R.id.quantity_unit_spinner);
                 Startdate=view.findViewById(R.id.start_date_edittext);
                 EndDate=view.findViewById(R.id.end_date_edittext);
                 Areaedittext=view.findViewById(R.id.area_edittext);
                 Quantitytext=view.findViewById(R.id.quantity_edittext);
                String AreaSize=Areaedittext.getText().toString().trim();
                String Quantity=Quantitytext.getText().toString().trim();
                Button addtask=view.findViewById(R.id.addtask);
                errorMessageTextView=view.findViewById(R.id.errormsg);
                ///Array adptor for Area
                String[] units = {"Hectors", "Dismils", "Acres"};
                Button convertButton=view.findViewById(R.id.convtbtn);
                TextView output=view.findViewById(R.id.unitshow);
                SpinnerAdapter spinnerAdapter = new SpinnerAdapter(mContext, units);
                Areaspinner.setAdapter(spinnerAdapter);
                convertButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String inputText = Areaedittext.getText().toString();
                        if (TextUtils.isEmpty(inputText)) {
                            Toast.makeText(mContext, "Please enter a value to convert", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        double inputValue = Double.parseDouble(inputText);
                        String fromUnit = Areaspinner.getSelectedItem().toString();
                        String toUnit;

                        switch (fromUnit) {
                            case "Hectors":
                                toUnit = "Dismils";
                                break;
                            case "Dismils":
                                toUnit = "Hectors";
                                break;
                            case "Acres":
                                toUnit = "Hectors";
                                break;
                            default:
                                toUnit = "Unknown";
                                break;
                        }

                        double result = convertUnits(inputValue, fromUnit, toUnit);
                        Areaedittext.setText(String.format("%.2f", result));
                        output.setText(String.format("%.2f %s = %.2f %s", inputValue, fromUnit, result, toUnit));
                    }
                });
                ArrayAdapter<CharSequence> AreaAdapter = ArrayAdapter.createFromResource(
                        mContext, R.array.area_unit_array, android.R.layout.simple_spinner_item);
                AreaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //Areaspinner.setAdapter(AreaAdapter);

                //
                /////Areaspinner.setOnItemSelectedListener(new UnitItemSelectedListener());


                //Array adpter for qantity
                ArrayAdapter<CharSequence> QuantityAdapter = ArrayAdapter.createFromResource(
                        mContext, R.array.quantity_unit_array, android.R.layout.simple_spinner_item);
                QuantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Quantityspinner.setAdapter(QuantityAdapter);
                //choose date from cropCalender
               // String selectedDate = cropCalender.getSelectedDate();
                // convert the selected date to a String format


                //Startdate.setText(selectedDate);
                //date edit text logic
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                    // Get the window of the DatePickerDialog

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Set the chosen date on the EditText view
                        String dateString = dayOfMonth+ "/" + (monthOfYear + 1)  + "/" + year;
                        ((EditText)view.getTag()).setText(dateString);
                    }
                };
                //start Date
                Startdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create a DatePickerDialog for the start date
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                mContext,
                                dateSetListener,
                                Calendar.getInstance().get(Calendar.YEAR),
                                Calendar.getInstance().get(Calendar.MONTH),
                                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                        );

                        datePickerDialog.getDatePicker().setTag(v);
                        datePickerDialog.show();
                    }
                });
                //end date
                EndDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create a DatePickerDialog for the start date
                        DatePickerDialog datePickerDialog = new DatePickerDialog(
                                mContext,
                                dateSetListener,
                                Calendar.getInstance().get(Calendar.YEAR),
                                Calendar.getInstance().get(Calendar.MONTH),
                                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                        );
                        // Set the minimum date for the end date to be the same as the start date
                        if (Startdate.getText().length() > 0) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
                            try {
                                Date startDate = sdf.parse(Startdate.getText().toString());
                                long minDate = startDate.getTime();
                                datePickerDialog.getDatePicker().setMinDate(minDate);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }

                        datePickerDialog.getDatePicker().setTag(v);
                        datePickerDialog.show();
                    }
                });
                ///logic for addtask btn click
                addtask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Check whether all required fields have been filled out
                        boolean allFieldsFilled = checkAllFieldsFilled();
                        // Get the values from the EditText fields

                        String projTitle = protitle.getText().toString().trim();
                        String projDesc = proj_desc.getText().toString().trim();
                        String seasonspinner = seasonSpinner.getSelectedItem().toString();
                        String typofcrop = categorySpinner.getSelectedItem().toString();
                        String cropname = typeSpinner.getSelectedItem().toString();
                        String areaSize = Areaedittext.getText().toString().trim();
                        String cropQuantity=Quantitytext.getText().toString().trim();
                        String startDates = Startdate.getText().toString().trim();
                        String endDate = EndDate.getText().toString().trim();
                        String areaSpinnerValue = Areaspinner.getSelectedItem().toString();
                        String quantitySpinnerValue = Quantityspinner.getSelectedItem().toString();
                        //date
                        // Convert the startDateString to a Date object
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

                       // Parse the text of the Startdate EditText into a Date object
                        Date startdate = null;
                        try {
                            startdate = dateFormat.parse(startDates);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        // If all fields have been filled out, submit the form
                        if (allFieldsFilled) {
                            //submitForm();

                            // Create an intent to start the ListFormActivity
                            Intent intent = new Intent(mContext, addtask.class);
                            //Remider moddel
                            Reminder reminder = new Reminder(projTitle, projDesc,seasonspinner,
                                    typofcrop,cropname,areaSize,areaSpinnerValue,
                                    cropQuantity,quantitySpinnerValue,
                                    startdate, midnight);
                            reminderList.add(reminder);

                            // Add the values as extras to the intent
                            intent.putExtra("reminderList", (Serializable) reminderList);

                           /* setResult(Activity.RESULT_OK, intent);
                            super.onBackPressed();*/
                            //
                            // Concatenate the properties of the Reminder object as a string
                            String reminderString = "Project Title: " + reminder.getName() + "\n" +
                                    "Project Description: " + reminder.getDescription() + "\n" +
                                    "Seasons: " + reminder.getSeasons() + "\n" +
                                    "Type of Crops: " + reminder.getTypeofcrops() + "\n" +
                                    "Name of Crop: " + reminder.getNameofCrop() + "\n" +
                                    "Area: " + reminder.getArea() + "\n" +
                                    "Area Size: " + reminder.getAreaSize() + "\n" +
                                    "Quantity: " + reminder.getQuantity() + "\n" +
                                    "Quantity Measure: " + reminder.getQuantitymesure() + "\n" +
                                    "Start Date: " + reminder.getDate().toString() + "\n" +
                                    "Time: " + reminder.getTime().toString();

                        // Show the reminderString in a Toast
                           // Toast.makeText(mContext, reminderString, Toast.LENGTH_SHORT).show();
                          /*  intent.putExtra("seasonspinner", seasonspinner);
                            intent.putExtra("typofcrop", typofcrop);
                            intent.putExtra("cropname", cropname);
                            intent.putExtra("projTitle", projTitle);
                            intent.putExtra("areaSize", areaSize);
                            intent.putExtra("areaSize", areaSize);
                            intent.putExtra("cropQuantity",cropQuantity);
                            intent.putExtra("startDate", startDate);
                            intent.putExtra("endDate", endDate);
                            intent.putExtra("areaSpinnerValue", areaSpinnerValue);
                            intent.putExtra("quantitySpinnerValue", quantitySpinnerValue);*/
// Show the values in a Toast message
                            Toast.makeText(mContext,
                                    "Project Title: " + projTitle + "\n" +
                                            "Project Description: " + projDesc + "\n" +
                                            "Season: " + seasonspinner + "\n" +
                                            "Type of Crop: " + typofcrop + "\n" +
                                            "Crop Name: " + cropname + "\n" +
                                            "Area Size: " + areaSize + " " + areaSpinnerValue + "\n" +
                                            "Crop Quantity: " + cropQuantity + " " + quantitySpinnerValue + "\n" +
                                           "",
                                    Toast.LENGTH_LONG).show();
                            // Start the ListFormActivity
                            mContext.startActivity(intent);
                        } else {
                            // Display error message
                            errorMessageTextView.setVisibility(View.VISIBLE);
                        }


                    }

                    private void submitForm() {

                    }
                });

                return view;
        }

        return null;
    }
    //boolean form validation
    private boolean checkAllFieldsFilled() {
        String projTitle = protitle.getText().toString().trim();
        String projDesc = proj_desc.getText().toString().trim();
        String areaSize = Areaedittext.getText().toString().trim();
        String cropQuantity=Quantitytext.getText().toString().trim();
        String startDate = Startdate.getText().toString().trim();
        String endDate = EndDate.getText().toString().trim();

        if (TextUtils.isEmpty(projTitle)) {
            protitle.setError("Title cannot be empty");
            return false;
        }

        if (TextUtils.isEmpty(projDesc)) {
            proj_desc.setError("Description cannot be empty");
            return false;
        }
        if (TextUtils.isEmpty(areaSize)) {
            protitle.setError("Area cannot be empty");
            return false;
        }

        if (TextUtils.isEmpty(cropQuantity)) {
            proj_desc.setError("cropQuantity cannot be empty");
            return false;
        }
        return true;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
               /*** Simple unit Convter Apply ***/
   /* private class UnitItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
            String unit = parent.getItemAtPosition(position).toString();
            String valueString = Areaedittext.getText().toString();
            if (!valueString.isEmpty()) {
                double inputValue = Double.parseDouble(valueString);
                double convertedValue = convertValue(inputValue, unit);
                Areaedittext.setText(String.format("%.2f", convertedValue));
            }
         *//*   double inputValue = Double.parseDouble(Areaedittext.getText().toString());
            double convertedValue = convertValue(inputValue, unit);
            Areaedittext.setText(String.format("%.2f", convertedValue));*//*
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }*/

  /*  private double convertValue(double value, String unit) {
        double conversionFactor = 0.0;
        switch (unit) {
            case "Hectors":
                conversionFactor = 1.0; // No conversion needed
                break;
            case "Acers":
                conversionFactor = 2.47105;
                break;
            case "Dismil":
                conversionFactor = 0.024711;
                break;
        }
        return value * conversionFactor;
    }*/
    ////conveter unit
    public double convertUnits(double value, String fromUnit, String toUnit) {
        double result = 0;

        switch (fromUnit) {
            case "Hectors":
                if (toUnit.equals("Dismils")) {
                    result = value * 100;
                } else if (toUnit.equals("Acres")) {
                    result = value * 2.47105;
                }
                break;
            case "Dismils":
                if (toUnit.equals("Hectors")) {
                    result = value / 100;
                } else if (toUnit.equals("Acres")) {
                    result = value * 0.0247105;
                }
                break;
            case "Acres":
                if (toUnit.equals("Hectors")) {
                    result = value / 2.47105;
                } else if (toUnit.equals("Dismils")) {
                    result = value / 0.0247105;
                }
                break;
        }

        return result;
    }
    ///
    public class SpinnerAdapter extends ArrayAdapter<String> {

        private final String[] units;

        public SpinnerAdapter(Context context, String[] units) {
            super(context, android.R.layout.simple_spinner_dropdown_item, units);
            this.units = units;
        }

        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getDropDownView(position, convertView, parent);
            view.setText(units[position]);
            return view;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            view.setText(units[position]);
            return view;
        }
    }
}





