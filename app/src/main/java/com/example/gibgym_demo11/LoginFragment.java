package com.example.gibgym_demo11;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.http.HttpClient;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.results.SignInResult;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoPinpointSharedContext;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;

import org.json.JSONObject;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    //String TAG = "Own TAG";
    private static final String TAG = LoginFragment.class.getSimpleName();
    private AmazonCognitoIdentityProviderClient client;

    private String sUname;
    private String sPassword;
    private String sForgotPass;

    private String clientId= "3p15e85uuq1e30mjgs3njvi27n";
    private String userPoolId= "us-east-1_GAE2cnMWx";
    private String clientSecret= "mv59t54g8t12epi4b4nhkk1o6slmj9ognutjduh85l36ptd0pa";
    private String identityPoolId = "us-east-1:7953558d-3732-4a59-a802-b760cbd65f20";
    private String cognitoRegion = "Regions.US_EAST_1";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"Main Activity Has Been Started!");
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        TextView forgotpassTextview = (TextView) view.findViewById(R.id.textView_login_forgotpass);
        sForgotPass = forgotpassTextview.getText().toString();

        forgotpassTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Add this line, to include the Auth plugin.

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

        Button LginLginButton = getView().findViewById(R.id.button_login_login);
            LginLginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //NavController navCon = Navigation.findNavController(view);
               // navCon.navigate(R.id.action_loginFragment_to_ageWeightFragment);
              login();
            }
        });

    }




    public void login() {
        EditText loginuname = getView().findViewById(R.id.text_login_uname);
        String sUname = loginuname.getText().toString();
        EditText loginupass = getView().findViewById(R.id.text_login_pass);
        String sPassword = loginupass.getText().toString();

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
                                navCon.navigate(R.id.action_loginFragment_to_ageWeightFragment);
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
            }
        });




        /*
        final AWSConfiguration awsConfiguration = AWSMobileClient.getInstance().getConfiguration();
        CognitoCachingCredentialsProvider credentialsProvider = new CognitoCachingCredentialsProvider(this.getActivity().getApplicationContext(), "us-east-1:e8820125-3328-44ec-89c7-9695c161b8c2", Regions.US_EAST_1);
        final CognitoUserPool userPool = new CognitoUserPool(this.getActivity().getApplicationContext(),userPoolId,clientId,clientSecret);
        final CognitoUser user = userPool.getUser(sUname); // Create a User Object with a UserId
        user.getSessionInBackground(authenticationHandler);
         */
    }

    public void forgotpass(){

    }

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

}
