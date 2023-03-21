package com.passonatetech.agrohub.cropcalender;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewpager.widget.PagerAdapter;

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
                return view;

            case 2:
                view = inflater.inflate(R.layout.activity_create_calender, container, false);
                container.addView(view);
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

