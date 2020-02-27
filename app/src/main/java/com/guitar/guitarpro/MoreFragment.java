package com.guitar.guitarpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MoreFragment extends Fragment {

    public MoreFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.more_fragment, container, false);

        TextView onboarding_textview = view.findViewById(R.id.see_onboarding);
        onboarding_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),
                        OnboardingActivity.class);
                startActivity(intent);
            }
        });

        TextView about_textview = view.findViewById(R.id.about);
        about_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),
                        AboutActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
