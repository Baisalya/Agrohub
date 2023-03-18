package com.passonatetech.agrohub.cropcalender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.passonatetech.agrohub.R;

public class Category extends AppCompatActivity {
   Button nxtbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        nxtbtn=findViewById(R.id.next_btn);
        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Category.this,DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}