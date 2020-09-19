package com.example.gibgym_demo11;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.results.SignUpResult;
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;

import static android.content.ContentValues.TAG;
import static android.content.Context.MODE_PRIVATE;
import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

public class ConfirmSignUp extends Fragment {
    private String sUname;
    private String sCode;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        try {
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
        } catch (AmplifyException e) {
            e.printStackTrace();
        }
        try {
            Amplify.configure(getActivity().getApplicationContext());
            Log.i("MyAmplifyApp", "Initialized Amplify");

        } catch (AmplifyException e) {
            e.printStackTrace();
            Log.e("MyAmplifyApp", "Could not initialize Amplify", e);

        }


        Button confirmButton = getView().findViewById(R.id.button_confFrag_confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyRegister();
            }
        });
        super.onActivityCreated(savedInstanceState);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_confirm_sign_up, container, false);
        return view;
    }

    private void verifyRegister (){

        EditText regcode = getView().findViewById(R.id.editTextNumber_confFrag_code);
        sCode = regcode.getText().toString();
        SharedPreferences prefs = getContext().getSharedPreferences("myAppPackage", 0);
        sUname = prefs.getString("username", "");
        System.out.println("XXXXXXXXXXXXXXXXXXX"+sUname);

        AWSMobileClient.getInstance().confirmSignUp(sUname, sCode, new Callback<SignUpResult>() {
            @Override
            public void onResult(final SignUpResult signUpResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "Sign-up callback state: " + signUpResult.getConfirmationState());
                        if (!signUpResult.getConfirmationState()) {
                            final UserCodeDeliveryDetails details = signUpResult.getUserCodeDeliveryDetails();
                            makeToast("Confirm sign-up with: " + details.getDestination());
                        } else {
                            makeToast("Sign-up done.");
                            NavController navCon = Navigation.findNavController(getView());
                            navCon.navigate(R.id.action_confirmSignUp_to_loginFragment);
                        }
                    }
                });
            }

            private void makeToast(String s) {
                Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "Confirm sign-up error", e);
            }
        });

        }

}