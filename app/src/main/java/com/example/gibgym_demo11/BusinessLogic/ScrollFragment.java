package com.example.gibgym_demo11.BusinessLogic;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

import com.example.gibgym_demo11.R;


public class ScrollFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_scroll, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        // make it scroll from bottom
        final ScrollView scrollView = getView().findViewById(R.id.scfrag_scrollView);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
            }
        });
        super.onActivityCreated(savedInstanceState);

        ImageButton settingButton = getView().findViewById(R.id.scfrag_imageButton_settings);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCon = Navigation.findNavController(view);
                navCon.navigate(R.id.action_scrollFragment2_to_generalSettingsFragment);
            }
        });

        ImageButton woButton = getView().findViewById(R.id.scfrag_imageButton_workouts);
        woButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCon = Navigation.findNavController(view);
                navCon.navigate(R.id.action_scrollFragment2_to_workoutFragment);
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        //Back button click do nothing
        getActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        });

        super.onCreate(savedInstanceState);
    }

}