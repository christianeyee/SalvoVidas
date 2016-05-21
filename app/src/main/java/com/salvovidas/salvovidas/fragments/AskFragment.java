package com.salvovidas.salvovidas.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.salvovidas.salvovidas.R;

public class AskFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_ask, container, false);
        setUpRadio(rootView);
        return rootView;
    }

    private void setUpRadio(ViewGroup vg) {
        RadioGroup radioGroup = (RadioGroup) vg.findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_no) {

                }
                else {

                }
            }
        });
    }
}

