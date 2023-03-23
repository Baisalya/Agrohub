package com.passonatetech.agrohub.cropcalender;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.passonatetech.agrohub.R;

import java.util.Calendar;

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
                        switch (position) {
                            case 0: // Cereals
                                types = mContext.getResources().getStringArray(R.array.In_Rabi_Cereals);
                                break;
                            case 1: // Vegetables
                                types = mContext.getResources().getStringArray(R.array.In_Rabi_vegetables);
                                break;
                            case 2: // Fruits
                                types = mContext.getResources().getStringArray(R.array.In_Rabi_Fruits);
                                break;
                            case 3: // Legumes
                                types = mContext.getResources().getStringArray(R.array.In_Rabi_Legumes);
                                break;
                            case 4: // Cereals
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_Cereals);
                                break;
                            case 5: // vegetables
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_vegetables);
                                break;
                            case 6: // Fruits
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_Fruits);
                                break;
                            case 7: // Legumes
                                types =mContext. getResources().getStringArray(R.array.In_Kharif_Legumes);
                                break;
                            case 8: // SeedPlants
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_SeedPlants);
                                break;
                            case 9: // Medicinal
                                types = mContext.getResources().getStringArray(R.array.In_Kharif_Medicinal);
                                break;
                            case 10: //Cereals
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_Cereals);
                                break;
                            case 11: // vegetables
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_vegetables);
                                break;
                            case 12: // Fruits
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_Fruits);
                                break;
                            case 13: // Legumes
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_Legumes);
                                break;
                            case 14: // SeedPlants
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_SeedPlants);
                                break;
                            case 15: // CashCrops
                                types = mContext.getResources().getStringArray(R.array.In_Zaid_CashCrops);
                                break;

                            default:
                                types = new String[]{};

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
                ArrayAdapter<CharSequence> AreaAdapter = ArrayAdapter.createFromResource(
                        mContext, R.array.area_unit_array, android.R.layout.simple_spinner_item);
                AreaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Areaspinner.setAdapter(AreaAdapter);
                //Array adpter for qantity
                ArrayAdapter<CharSequence> QuantityAdapter = ArrayAdapter.createFromResource(
                        mContext, R.array.quantity_unit_array, android.R.layout.simple_spinner_item);
                QuantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Quantityspinner.setAdapter(QuantityAdapter);
                //date edit text logic

                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Set the chosen date on the EditText view
                        String dateString = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year;
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
                        String areaSize = Areaedittext.getText().toString().trim();
                        String cropQuantity=Quantitytext.getText().toString().trim();
                        //date

                        // If all fields have been filled out, submit the form
                        if (allFieldsFilled) {
                            //submitForm();

                            // Create an intent to start the ListFormActivity
                            Intent intent = new Intent(mContext, addtask.class);

                            // Add the values as extras to the intent

                            intent.putExtra("projDesc", projDesc);
                            intent.putExtra("projTitle", projTitle);
                            intent.putExtra("areaSize", areaSize);
                            intent.putExtra("cropQuantity",cropQuantity);

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
}

