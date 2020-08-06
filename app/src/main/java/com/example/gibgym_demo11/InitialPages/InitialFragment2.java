package com.example.gibgym_demo11.InitialPages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gibgym_demo11.R;

public class InitialFragment2 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_initial2, container, false);
        FragmentActivity fragmentActivity = this.getActivity();
        final ViewPager2 viewPager = fragmentActivity != null ? (ViewPager2)fragmentActivity.findViewById(R.id.viewPager) : null;


        ((TextView)view.findViewById(R.id.init_frag_next_btn_two)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                ViewPager2 viewPager2 = viewPager;
                if (viewPager2 != null) {
                    viewPager2.setCurrentItem(2);
                }
            }
        }));

        return view;
    }
}