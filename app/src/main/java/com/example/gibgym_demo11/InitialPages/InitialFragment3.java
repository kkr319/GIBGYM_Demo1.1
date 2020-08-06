package com.example.gibgym_demo11.InitialPages;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gibgym_demo11.R;

import java.util.HashMap;

import kotlin.jvm.internal.Intrinsics;

public class InitialFragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        /*
        View view =  inflater.inflate(R.layout.fragment_initial3, container, false);
        final NavController navCon = Navigation.findNavController(view);

        ((TextView)view.findViewById(R.id.init_frag_finish_btn)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                navCon.navigate(R.id.action_viewPagerFragment_to_homeFragment);
                InitialFragment3.this.onBoardingFinished();
            }
        }));
        return  view;
    }

    private final void onBoardingFinished() {
        SharedPreferences sharedPref = this.requireActivity().getSharedPreferences("onBoarding", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Finished", true);
        editor.apply();
    }
    */
        final View view = inflater.inflate(R.layout.fragment_initial3, container, false);

        ((TextView)view.findViewById(R.id.init_frag_finish_btn)).setOnClickListener((View.OnClickListener)(new View.OnClickListener() {
            public final void onClick(View it) {
                final NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_viewPagerFragment_to_homeFragment);
                InitialFragment3.this.onBoardingFinished();
            }
        }));
        return view;
    }

    private final void onBoardingFinished() {
        SharedPreferences sharedPref = this.requireActivity().getSharedPreferences("onBoarding", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Finished", true);
        editor.apply();
    }

}