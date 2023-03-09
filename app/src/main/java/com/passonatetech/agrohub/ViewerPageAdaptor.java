package com.passonatetech.agrohub;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ViewerPageAdaptor extends PagerAdapter {
    Context context;
    int images[]={
            R.drawable.leaf,
            R.drawable.leaf,
            R.drawable.leaf,
            R.drawable.leaf,
    };

    int heading[]={
            R.string.onboarding_page_1,
            R.string.onboarding_page_2,
            R.string.onboarding_page_3,
            R.string.onboarding_page_4,
    };
    public ViewerPageAdaptor(Context context){
        this.context=context;
    }
    int description[]={
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
            R.string.app_name,
    };
    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container,int position){
        LayoutInflater layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slider_layout,container,false);
        ImageView  slidetitleimage=(ImageView) view.findViewById(R.id.title_img);
        TextView   slidingHeading=(TextView) view.findViewById(R.id.title_text);
        TextView   slidingDescription=(TextView) view.findViewById(R.id.description_text);
        //
        slidetitleimage.setImageResource(images[position]);
        slidingHeading.setText(heading[position]);
        slidingDescription.setText(description[position]);
        container.addView(view);
        return view;

       // return  super.instantiateItem(container,position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       // super.destroyItem(container, position, object);
        container.removeView((LinearLayout)object);
    }
}
