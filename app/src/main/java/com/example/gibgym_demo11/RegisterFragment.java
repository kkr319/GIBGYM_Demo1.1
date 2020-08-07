package com.example.gibgym_demo11;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    String TAG = "Registered Successfully";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_register,container,false);

        TextView agreementTextView = (TextView) rootView.findViewById(R.id.textView_fReg_uAgreement);
        agreementTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"User Agreement",Toast.LENGTH_SHORT).show();
                String str = initAssets("user_agreement.txt");
                final View inflate;
                inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_agreement_privacy,null);
                TextView tv_title = (TextView) inflate.findViewById(R.id.tv_title);
                tv_title.setText("User Agreement");
                TextView tv_content = (TextView) inflate.findViewById(R.id.tv_content);
                tv_content.setText(str);
                final Dialog dialog = new AlertDialog
                        .Builder(getActivity())
                        .setView(inflate)
                        .show();
                final WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
                params.width = 1000;
                params.height = 2000;
                dialog.getWindow().setAttributes(params);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
            }
        });

        TextView privacyPolicyTextView = (TextView) rootView.findViewById(R.id.textView_fReg_privacy);
        privacyPolicyTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Privacy Policy",Toast.LENGTH_SHORT).show();
                String str = initAssets("user_privacy.txt");
                final View inflate;
                inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_agreement_privacy,null);
                TextView tv_title = (TextView) inflate.findViewById(R.id.tv_title);
                tv_title.setText("Privacy Policy");
                TextView tv_content = (TextView) inflate.findViewById(R.id.tv_content);
                tv_content.setText(str);
                final Dialog dialog = new AlertDialog
                        .Builder(getActivity())
                        .setView(inflate)
                        .show();
                final WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
                params.width = 1000;
                params.height = 2000;
                dialog.getWindow().setAttributes(params);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
            }
        });
        return rootView;
    }



    public String initAssets(String fileName) {
        String str = null;
        try {
            InputStream inputStream = getContext().getAssets().open(fileName);

            str = getString(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return str;
    }
    public static String getString(InputStream inputStream) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Button regButton = getView().findViewById(R.id.button_fReg_submit);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCon = Navigation.findNavController(view);
                navCon.navigate(R.id.action_registerFragment_to_loginFragment);
                Toast.makeText(getActivity(),getString(R.string.emailtoast),Toast.LENGTH_SHORT).show();
            }
        });
        super.onActivityCreated(savedInstanceState);
    }
}
