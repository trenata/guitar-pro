package com.guitar.guitarpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class CustomPagerAdapter extends PagerAdapter {

    private String[] titles;
    private String[] descriptions;
    private int[] images = {
            R.drawable.onboarding_image_1,
            R.drawable.onboarding_image_2,
            R.drawable.onboarding_image_3,
            R.drawable.onboarding_image_4
    };
    private LayoutInflater inflater;

    CustomPagerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        titles = context.getResources().getStringArray(R.array.titles);
        descriptions = context.getResources().getStringArray(R.array.descriptions);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.view_page, collection, false);
        TextView title = layout.findViewById(R.id.title);
        TextView description = layout.findViewById(R.id.description);
        ImageView image = layout.findViewById(R.id.background_image);
        title.setText(titles[position]);
        description.setText(descriptions[position]);
        image.setImageResource(images[position]);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

}