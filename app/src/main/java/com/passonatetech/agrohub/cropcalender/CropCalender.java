package com.passonatetech.agrohub.cropcalender;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.loginsignup.ExpertRegistration;
import com.passonatetech.agrohub.widgets.AlertBox;

import java.util.Calendar;

public class CropCalender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_calender);
        CalendarView calendarView=findViewById(R.id.cropcalender);

        calendarView.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                        clickondate();
                    }
                }
        );
    }
    public void clickondate() {
        String message = "Select One";
        Intent intent = new Intent(this, Category.class);
        Intent intent1=new Intent(this,ExpertRegistration.class);
        Createprojectpopup.showAlert(this, message, intent,intent1);

    }
}