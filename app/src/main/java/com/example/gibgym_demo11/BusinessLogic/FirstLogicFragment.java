package com.example.gibgym_demo11.BusinessLogic;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gibgym_demo11.R;


public class FirstLogicFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_logic, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Button logicSubmit = getView().findViewById(R.id.button_fLogic_submit);
        logicSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCon = Navigation.findNavController(view);
                navCon.navigate(R.id.action_firstLogicFragment3_to_scrollFragment2);
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

}
