package com.example.gibgym_demo11;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {



    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_register,container,false);

        TextView agreementTextView = (TextView) rootView.findViewById(R.id.textView_fReg_uAgreement);
        agreementTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"clicked",Toast.LENGTH_SHORT).show();
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
        /*
        String agreement = "the User agreement";
        SpannableString ssAgreement = new SpannableString(agreement);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Toast.makeText(getActivity(),"clicked",Toast.LENGTH_SHORT).show();
            }
        };
        ssAgreement.setSpan(clickableSpan,0,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        agreementTextView.setText(agreement);
        agreementTextView.setMovementMethod(LinkMovementMethod.getInstance());

         */
        TextView privacyPolicyTextView = (TextView) rootView.findViewById(R.id.textView_fReg_privacy);
        privacyPolicyTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"clicked",Toast.LENGTH_SHORT).show();
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

}
