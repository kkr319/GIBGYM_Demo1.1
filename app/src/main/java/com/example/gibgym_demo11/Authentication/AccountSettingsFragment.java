package com.example.gibgym_demo11.Authentication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.results.ForgotPasswordResult;
import com.example.gibgym_demo11.R;

import static android.content.ContentValues.TAG;
import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;


public class AccountSettingsFragment extends Fragment {

    String username;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account_settings, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        NavController navController = Navigation.findNavController(getView());

        SharedPreferences prefs = getActivity().getApplicationContext().getSharedPreferences("myAppPackage", 0);
        username = prefs.getString("Susername", "");
        TextView textViewUsername = requireView().findViewById(R.id.textView_acsFrag_uname);
        textViewUsername.setText(username);

        Button LginLginButton = getView().findViewById(R.id.button_astFrag_chpass);
        LginLginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forgotpass(username);
                AWSMobileClient.getInstance().signOut();
                navController.navigate(R.id.action_accountSettingsFragment_to_forgotPasswordFragment);
            }
        });

        Button logtButton = getView().findViewById(R.id.button_astFrag_logt);
        logtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AWSMobileClient.getInstance().signOut();
                navController.navigate(R.id.action_accountSettingsFragment_to_loginFragment);
            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    public void forgotpass(String uname){
        AWSMobileClient.getInstance().forgotPassword(uname, new Callback<ForgotPasswordResult>() {
            @Override
            public void onResult(final ForgotPasswordResult result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "forgot password state: " + result.getState());
                        switch (result.getState()) {
                            case CONFIRMATION_CODE:
                                makeToast("Confirmation code is sent to reset password");
                                break;
                            default:
                                Log.e(TAG, "un-supported forgot password state");
                                break;
                        }
                    }
                });
            }

            private void makeToast(String s) {
                Toast.makeText(getActivity(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "forgot password error", e);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(e.toString().contains("username' failed to satisfy constraint: Member must not be null")) {
                            Toast.makeText(getActivity(), "Error: You must provide your username", Toast.LENGTH_LONG).show();
                        }else if(e.toString().contains("Username/client id combination not found")){
                            Toast.makeText(getActivity(), "Error: Username does not exist", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

}