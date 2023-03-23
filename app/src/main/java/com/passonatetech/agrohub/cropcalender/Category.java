package com.passonatetech.agrohub.cropcalender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.passonatetech.agrohub.R;

import java.util.ArrayList;
import java.util.List;

public class Category extends AppCompatActivity {
   Button nxtbtn;
    private ViewPager viewPager;
    private SlidePagerAdapter pagerAdapter;
    private Button createnew,existing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        nxtbtn=findViewById(R.id.next_btn);
        createnew=findViewById(R.id.cre_new);
        existing=findViewById(R.id.existing_pro);
        viewPager = findViewById(R.id.view_pager);
        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);
        //view remove
        ViewGroup layoutContainer = findViewById(R.id.btnscreandselectContainer);
        //layoutContainer.removeAllViews();
        ViewGroup parentView = (ViewGroup) layoutContainer.getParent();
        //parentView.removeView(layoutContainer);

        List<View> views = new ArrayList<>();
        pagerAdapter = new SlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        /**custome progressbar  **/
        TextView infopro,infoico,datepro,dateico;
        infopro=findViewById(R.id.infoprogressbar);
        datepro=findViewById(R.id.dateprogressbar);
        Drawable disablecustomProgressDrawable = getResources().getDrawable(R.drawable.custom_progressbar);
        infoico=findViewById(R.id.infoico);
        Drawable disableinfoicoDrawable=getResources().getDrawable(R.drawable.infobw);
        dateico=findViewById(R.id.dateico);
        Drawable disabledateicoDrawable=getResources().getDrawable(R.drawable.datebw);
        //enable
        Drawable customProgressDrawable = getResources().getDrawable(R.drawable.horizontalstepbar);
        Drawable infoicoDrawable=getResources().getDrawable(R.drawable.info);
        Drawable dateicoDrawable=getResources().getDrawable(R.drawable.date);
        /** custome progresbar end **/
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch(position){
                    case 0:
                        topAppBar.setTitle("Category");
                        infopro.setBackground(disablecustomProgressDrawable);
                        datepro.setBackground(disablecustomProgressDrawable);
                        infoico.setBackground(disableinfoicoDrawable);
                        dateico.setBackground(disabledateicoDrawable);
                        // Check if layoutContainer has been removed and add it back



                      break;
                    case 1:
                        topAppBar.setTitle("Details");
                        layoutContainer.removeAllViews();
                        parentView.removeView(layoutContainer);
                        infopro.setBackground(customProgressDrawable);
                        datepro.setBackground(disablecustomProgressDrawable);
                        infoico.setBackground(infoicoDrawable);
                        dateico.setBackground(disabledateicoDrawable);
                        break;
                    case 2:
                        topAppBar.setTitle("Create Calender");
                        layoutContainer.removeAllViews();
                        parentView.removeView(layoutContainer);
                        infopro.setBackground(customProgressDrawable);
                        datepro.setBackground(customProgressDrawable);
                        infoico.setBackground(infoicoDrawable);
                        dateico.setBackground(dateicoDrawable);
                        break;


                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

// Add your views to the list here
       /* MyPagerAdapter adapter = new MyPagerAdapter(views);
        viewPager.setAdapter(adapter);*/

existing.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(Category.this,addtask.class);
        startActivity(intent);
        finish();
    }
});


        nxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Category.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

    }
}