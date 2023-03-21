package com.passonatetech.agrohub.cropcalender;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.viewpager.widget.PagerAdapter;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.passonatetech.agrohub.R;

public class SlidePagerAdapter extends PagerAdapter {
    private Context mContext;

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

                return view;

            case 1:
                view = inflater.inflate(R.layout.activity_details, container, false);
                container.addView(view);
                Spinner seasonSpinner = view.findViewById(R.id.season_spinner);
                Spinner categorySpinner = view.findViewById(R.id.types_of_crop_spinner);
                Spinner typeSpinner = view.findViewById(R.id.crop_name_spinner);
                EditText protitle=view.findViewById(R.id.projecttitle_EditText);
                EditText proj_desc=view.findViewById(R.id.projectdescription_Edittext);
                String title = protitle.getText().toString().trim();
                String desc = proj_desc.getText().toString().trim();
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
                if (TextUtils.isEmpty(title)) {
                    protitle.setError("Title cannot be empty");
                     // stop further execution
                }

                if (TextUtils.isEmpty(desc)) {
                    proj_desc.setError("Description cannot be empty");
                     // stop further execution
                }
                    return view;

            case 2:
                view = inflater.inflate(R.layout.activity_create_calender, container, false);
                container.addView(view);
                Spinner Areaspinner=view.findViewById(R.id.area_unit_spinner);
                Spinner Quantityspinner=view.findViewById(R.id.quantity_unit_spinner);
                DatePicker Startdate=view.findViewById(R.id.start_date_edittext);
                DatePicker EndDate=view.findViewById(R.id.end_date_edittext);
                EditText   Areaedittext=view.findViewById(R.id.area_edittext);
                EditText   Quantitytext=view.findViewById(R.id.quantity_edittext);
                String AreaSize=Areaedittext.getText().toString().trim();
                String Quantity=Quantitytext.getText().toString().trim();
                FloatingActionButton addtask=view.findViewById(R.id.addtask);
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
                ///logic for addtask btn click
                addtask.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

                return view;
        }

        return null;
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

