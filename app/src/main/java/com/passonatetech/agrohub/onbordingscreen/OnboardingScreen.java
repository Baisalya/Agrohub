package com.passonatetech.agrohub.onbordingscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.passonatetech.agrohub.R;
import com.passonatetech.agrohub.loginsignup.RegistrationActivity;

public class OnboardingScreen extends AppCompatActivity {
ViewPager AgroSliderViewPager;
LinearLayout dotLayout;
Button prevbtn,nextbtn,skipbtn;
   TextView[] dots;
    ViewerPageAdaptor viewerPageAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);
        prevbtn=findViewById(R.id.prev_btn);
        nextbtn=findViewById(R.id.next_btn);
        skipbtn=findViewById(R.id.skip_btn);
       //Previous view in slider
        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(getItem(0)>0){
                  AgroSliderViewPager.setCurrentItem(getItem(-1),true);
              }
            }
        });
        //next view in slider
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getItem(0)<3){
                    AgroSliderViewPager.setCurrentItem(getItem(1),true);
                }else {
                    activity();
                }
            }

        });
        //skip onbording Screen
        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity();
            }
        });
        //for viwpager
        AgroSliderViewPager=(ViewPager) findViewById(R.id.SlideViewPager);
        dotLayout=(LinearLayout) findViewById(R.id.indicator_layout);
        viewerPageAdaptor = new ViewerPageAdaptor(this);
        AgroSliderViewPager.setAdapter(viewerPageAdaptor);
        setUpindicator(0);
        AgroSliderViewPager.addOnPageChangeListener(viewListner);
    }
    //Method for adding indicator
    public void  setUpindicator(int position){
        dots=new TextView[4];
        dotLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.inactive,getApplicationContext().getTheme()));
            dotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.active,getApplicationContext().getTheme()));
    }
    ViewPager.OnPageChangeListener viewListner=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
           setUpindicator(position);
           if (position > 0){
               prevbtn.setVisibility(View.VISIBLE);
           }else {
               prevbtn.setVisibility(View.INVISIBLE);
           }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    //method for give the position of viewItem
    private int getItem(int i){
        return AgroSliderViewPager.getCurrentItem()+i;
    }
    //method for skip and last next viewer page
    private void activity() {
        Intent intent = new Intent(OnboardingScreen.this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}