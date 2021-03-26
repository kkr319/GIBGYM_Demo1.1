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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.results.ForgotPasswordResult;
import com.amazonaws.mobile.client.results.SignInResult;

import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;
import com.example.gibgym_demo11.R;

import org.w3c.dom.ls.LSOutput;

import io.grpc.internal.JsonUtil;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    //String TAG = "Own TAG";
    private static final String TAG = LoginFragment.class.getSimpleName();
    private AmazonCognitoIdentityProviderClient client;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"Main Activity Has Been Started!");
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Add this line, to include the Auth plugin.
        /*
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


         */


        Button LginLginButton = getView().findViewById(R.id.button_login_login);
            LginLginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavController navCon = Navigation.findNavController(view);
               // navCon.navigate(R.id.action_loginFragment_to_ageWeightFragment);
              login();
            }
        });


        TextView forgotpassTextview = getView().findViewById(R.id.textView_login_forgotpass);
        forgotpassTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText loginuname = getView().findViewById(R.id.text_login_uname);
                final String sUname = loginuname.getText().toString();
                forgotpass(sUname);
            }
        });

    }


    public void login() {

        EditText loginuname = getView().findViewById(R.id.text_login_uname);
        final String sUname = loginuname.getText().toString();
        EditText loginupass = getView().findViewById(R.id.text_login_pass);
        final String sPassword = loginupass.getText().toString();

        //Store the username for Confirm Fragment to use
        SharedPreferences prefs = getContext().getSharedPreferences("myAppPackage", 0);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Susername", sUname);
        editor.commit();

        if (sUname.isEmpty() || sPassword.isEmpty())
        {
            return;
        }
        AWSMobileClient.getInstance().signIn(sUname, sPassword, null, new Callback<SignInResult>() {
            @Override
            public void onResult(final SignInResult signInResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "Sign-in callback state: " + signInResult.getSignInState());
                        switch (signInResult.getSignInState()) {
                            case DONE:
                                makeToast("Sign-in done.");
                                NavController navCon = Navigation.findNavController(getView());
                                navCon.navigate(R.id.action_loginFragment_to_UInfoFragment);
                                break;
                            case NEW_PASSWORD_REQUIRED:
                                makeToast("Please confirm sign-in with new password.");
                                break;
                            default:
                                makeToast("Unsupported sign-in confirmation: " + signInResult.getSignInState());
                                break;
                        }
                    }

                    private void makeToast(String s) {
                        Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "Sign-in error", e);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(e.toString().contains("Incorrect username")) {
                            Toast.makeText(getActivity(), "Log in error: " + e.toString().substring(77, 107), Toast.LENGTH_LONG).show();
                        }else if(e.toString().contains("User does not exist")){
                            Toast.makeText(getActivity(), "Log in error: " + e.toString().substring(76, 95), Toast.LENGTH_LONG).show();

                        }
                        }
                });
            }
        });

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
                                NavController navController = Navigation.findNavController(getView());
                                navController.navigate(R.id.action_loginFragment_to_forgotPasswordFragment);
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


    /*
    private AuthenticationHandler authenticationHandler = new AuthenticationHandler()
    {
        @Override
        public void onSuccess(final CognitoUserSession userSession, final CognitoDevice newDevice)
        {
            // Login success, do startActivity() or other thing
            System.out.println("SSSSSSSSSSSSSSSSSSSSS");
            //NavController navCon = Navigation.findNavController(getView());
            //navCon.navigate(R.id.action_loginFragment_to_ageWeightFragment);

        }

        @Override
        public void getAuthenticationDetails(final AuthenticationContinuation continuation, final String userId)
        {
            if (userId != null)
            {
                sUname = userId;
            }


            final AuthenticationDetails authDetails = new AuthenticationDetails(sUname, sPassword, null);
            continuation.setAuthenticationDetails(authDetails);
            continuation.continueTask();
        }

        @Override
        public void getMFACode(final MultiFactorAuthenticationContinuation continuation)
        {
        }

        @Override
        public void authenticationChallenge(final ChallengeContinuation continuation)
        {
        }

        @Override
        public void onFailure(final Exception exception)
        {

        }
    };

     */

}
