package com.example.gibgym_demo11.BusinessLogic;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.gibgym_demo11.R;

public class WorkoutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        ImageButton plButton = getView().findViewById(R.id.wofrag_imageButton_pl);
        plButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCon = Navigation.findNavController(view);
                navCon.navigate(R.id.action_workoutFragment_to_scrollFragment2);
            }
        });

        ImageButton startwktbt = getView().findViewById(R.id.wofrag_imageButton_start);
        startwktbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navCon = Navigation.findNavController(v);
                navCon.navigate(R.id.action_workoutFragment_to_camFragment);
            }
        });

        super.onActivityCreated(savedInstanceState);
    }
}