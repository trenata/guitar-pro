package com.guitar.guitarpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class FirstPagerAdapter extends PagerAdapter {

    private String[] titles;
    private String[] descriptions;
    private int[] images = {
            R.drawable.ic_circle_shape,
            R.drawable.ic_circle_shape,
            R.drawable.ic_circle_shape,
            R.drawable.ic_circle_shape
    };
    private LayoutInflater inflater;

    FirstPagerAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        titles = context.getResources().getStringArray(R.array.titles_first);
        descriptions = context.getResources().getStringArray(R.array.descriptions_first);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.first_time_user_experience, collection, false);
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