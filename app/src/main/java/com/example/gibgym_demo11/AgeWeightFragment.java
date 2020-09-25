package com.example.gibgym_demo11;

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
import android.widget.Toast;

import java.util.Objects;


public class AgeWeightFragment extends Fragment {

    String TAG;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_age_weight_, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Button anwSubmit = requireView().findViewById(R.id.button_anwfrag_button);
        anwSubmit.setOnClickListener(view -> {
           // Intent intent = new Intent(getActivity(),LogicActivity.class);
            //startActivity(intent);
            //Log.d(TAG,"New Activity");
            NavController navCon = Navigation.findNavController(view);
            navCon.navigate(R.id.action_ageWeightFragment_to_firstLogicFragment3);
        });

        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //Back button click do nothing
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        });
        super.onCreate(savedInstanceState);
    }
}