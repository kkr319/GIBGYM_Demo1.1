package com.example.gibgym_demo11;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button LginLginButton = getView().findViewById(R.id.button_login_login);
        LginLginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavController navCon = Navigation.findNavController(view);
                //navCon.navigate(R.id.action_loginFragment_to_firstLogicFragment);
                Intent intent = new Intent(getActivity(),LogicActivity.class);
                startActivity(intent);
            }
        });
    }
}
