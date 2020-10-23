package com.example.gibgym_demo11.Authentication;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
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
import com.example.gibgym_demo11.R;

import java.util.Objects;

import static android.content.ContentValues.TAG;
import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

public class ConfirmSignUp extends Fragment {
    public int counter;
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
            Amplify.configure(requireActivity().getApplicationContext());
            Log.i("MyAmplifyApp", "Initialized Amplify");

        } catch (AmplifyException e) {
            e.printStackTrace();
            Log.e("MyAmplifyApp", "Could not initialize Amplify", e);

        }

        //Set the text with timer for the first time
        TextView timerTextView = requireView().findViewById(R.id.textView_conFrg_timer);
        textTimer(timerTextView);

        //Resend Button
        TextView resendButton = requireView().findViewById(R.id.textView_conFrag_button);
        new CountDownTimer( 120000, 1000 ) {
            @Override public void onTick( long millisUntilFinished ) {
            }
            @Override public void onFinish() {
                resendButton.setOnClickListener(v -> {
                    textTimer(timerTextView);
                    resendCode();
                    start();
                });
            }
        }.start();

        //Confirm Button
        Button confirmButton = requireView().findViewById(R.id.button_confFrag_confirm);
        confirmButton.setOnClickListener(v -> verifyRegister());

        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        //TextView timerTextView = getView().findViewById(textView_conFrag_timer);

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

        EditText regcode = requireView().findViewById(R.id.editTextNumber_confFrag_code);
        sCode = regcode.getText().toString();
        SharedPreferences prefs = requireContext().getSharedPreferences("myAppPackage", 0);
        sUname = prefs.getString("username", "");
        System.out.println("XXXXXXXXXXXXXXXXXXX"+sUname);

        AWSMobileClient.getInstance().confirmSignUp(sUname, sCode, new Callback<SignUpResult>() {
            @Override
            public void onResult(final SignUpResult signUpResult) {
                runOnUiThread(() -> {
                    Log.d(TAG, "Sign-up callback state: " + signUpResult.getConfirmationState());
                    if (!signUpResult.getConfirmationState()) {
                        final UserCodeDeliveryDetails details = signUpResult.getUserCodeDeliveryDetails();
                        makeToast("Confirm sign-up with: " + details.getDestination());
                    } else {
                        makeToast("Sign-up done.");
                        NavController navCon = Navigation.findNavController(getView());
                        navCon.navigate(R.id.action_confirmSignUp_to_loginFragment);
                        navCon.popBackStack(R.id.homeFragment,false);
                    }
                });
            }

            private void makeToast(String s) {
                Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "Confirm sign-up error", e);
                runOnUiThread(() -> {
                    if(e.toString().contains("Invalid verification"))
                        Toast.makeText(getActivity(),"Please input the valid verification code", Toast.LENGTH_LONG).show();
                });            }
        });

        }

    private void resendCode(){
            SharedPreferences prefs = requireContext().getSharedPreferences("myAppPackage", 0);
            sUname = prefs.getString("username", "");
            AWSMobileClient.getInstance().resendSignUp(sUname, new Callback<SignUpResult>() {
                @Override
                public void onResult(SignUpResult signUpResult) {
                    Log.i(TAG, "A verification code has been sent via" +
                            signUpResult.getUserCodeDeliveryDetails().getDeliveryMedium()
                            + " at " +
                            signUpResult.getUserCodeDeliveryDetails().getDestination());
                    Toast.makeText(getActivity(),"Another verification code has been sent to your email address.",Toast.LENGTH_LONG).show();

                }
                @Override
                public void onError(Exception e) {
                    Log.e(TAG, String.valueOf(e));
                }
            });
        }

    private void textTimer(TextView textView){
       CountDownTimer countertimer = new CountDownTimer(120000, 1000) {
            public void onTick(long millisUntilFinished) {
                textView.setText(millisUntilFinished / 1000+"s");
            }
            public void onFinish() {

            }
        }.start();
    }


}