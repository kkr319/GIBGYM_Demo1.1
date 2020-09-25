package com.example.gibgym_demo11;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amazonaws.mobile.client.results.SignUpResult;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.services.cognitoidentity.model.CognitoIdentityProvider;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    String TAG = "Registered Successfully";

    /*
    private String clientId= "3p15e85uuq1e30mjgs3njvi27n";
    private String userPoolId= "us-east-1_GAE2cnMWx";
    private String clientSecret= "mv59t54g8t12epi4b4nhkk1o6slmj9ognutjduh85l36ptd0pa";
    private String identityPoolId = "us-east-1:e8820125-3328-44ec-89c7-9695c161b8c2";
    private String cognitoRegion = "Regions.US_EAST_1";
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_register, container, false);
        TextView agreementTextView = (TextView) rootView.findViewById(R.id.textView_fReg_uAgreement);
        agreementTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "User Agreement", Toast.LENGTH_SHORT).show();
                String str = initAssets("user_agreement.txt");
                final View inflate;

                inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_agreement_privacy, null);
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
        privacyPolicyTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Privacy Policy", Toast.LENGTH_SHORT).show();
                String str = initAssets("user_privacy.txt");
                final View inflate;
                inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_agreement_privacy, null);
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
        super.onActivityCreated(savedInstanceState);
        /*
        AWSMobileClient.getInstance().initialize(getActivity().getApplicationContext(), new Callback<UserStateDetails>() {

                    @Override
                    public void onResult(UserStateDetails userStateDetails) {
                        Log.i(TAG, userStateDetails.getUserState().toString());
                        switch (userStateDetails.getUserState()){
                            case SIGNED_IN:
                                Intent i = new Intent(getActivity(), LogicActivity.class);
                                startActivity(i);
                                break;
                            case SIGNED_OUT:
                                NavController navCon = Navigation.findNavController(getView());
                                navCon.navigate(R.id.action_confirmSignUp_to_loginFragment);

                                //LoginFragment loginFragment = new LoginFragment();
                                //loginFragment.login();
                                break;
                            default:
                                AWSMobileClient.getInstance().signOut();
                                signup();
                                break;
                        }
                    }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, e.toString());
            }
        });

         */

             signup();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    public void signup() {
        Button regButton = getView().findViewById(R.id.button_fReg_submit);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText regusername = getView().findViewById(R.id.editText_fReg_uname);
                EditText regpassword = getView().findViewById(R.id.editText_fReg_Pass);
                EditText regemail = getView().findViewById(R.id.editText_fReg_email);
                EditText regphonenum = getView().findViewById(R.id.editText_fReg_phonenum);
                EditText regrepassword = getView().findViewById(R.id.editText_fReg_PassConfirm);
                CheckBox regcheckbox = getView().findViewById(R.id.checkBox_fReg);

                final String Spassword = regpassword.getText().toString();
                final String Susername = regusername.getText().toString();
                final String Semail = regemail.getText().toString();
                final String Sphonenumber = regphonenum.getText().toString();
                final String SrePass = regrepassword.getText().toString();
                final boolean checked = regcheckbox.isChecked();

                final Map<String, String> attributes = new HashMap<>();
                attributes.put("email", Semail);
                attributes.put("custom:phonenumber",Sphonenumber);
               // attributes.put("custom:phonenumber",Sphonenumber);


                //Store the username for Confirm Fragment to use
                SharedPreferences prefs = getContext().getSharedPreferences("myAppPackage", 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("username", Susername);
                editor.commit();


                if(Susername.equals("")||Spassword.equals("")||SrePass.equals("")||Semail.equals("")){
                    Toast.makeText(getActivity(),"Please fill all the fileds",Toast.LENGTH_LONG).show();
                }else if(!Spassword.equals(SrePass)){
                    Toast.makeText(getActivity(),"Passwords do not match",Toast.LENGTH_LONG).show();
                }else if(!isValidPassword(Spassword)||Spassword.length()<8){
                    Toast.makeText(getActivity(),"Passwords must be at least 8 characters and contain at least one capital letter and one special character",Toast.LENGTH_LONG).show();
                }else if(!Semail.contains("@")||!Semail.contains(".com")){
                    Toast.makeText(getActivity(),"Please input a valid email address",Toast.LENGTH_LONG).show();
                }else if(checked==false){
                    Toast.makeText(getActivity(),"You must agree with our user agreement and privacy policy ",Toast.LENGTH_LONG).show();
                }else if(!Sphonenumber.isEmpty()&&Sphonenumber.length()<11){
                    Toast.makeText(getActivity(),"Please input a valid mobile phone number",Toast.LENGTH_LONG).show();
                }
                else {
                        actualSignup(Susername,Spassword,attributes);
                }
            }

        });
    }

    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void actualSignup(String sname,String spass, Map<String,String> attr) {
        AWSMobileClient.getInstance().signUp(sname, spass, attr, null, new Callback<SignUpResult>() {
            @Override
            public void onResult(final SignUpResult signUpResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "Sign-up callback state: " + signUpResult.getConfirmationState());

                        if (!signUpResult.getConfirmationState()) {
                            final UserCodeDeliveryDetails details = signUpResult.getUserCodeDeliveryDetails();
                            makeToast("Confirm sign-up with: " + details.getDestination());
                            System.out.println("********************************");
                            NavController navCon1 = Navigation.findNavController(getView());
                            navCon1.navigate(R.id.action_registerFragment_to_confirmSignUp);

                        }
                        else {
                            makeToast("Sign-up done.");
                        }
                    }
                    private void makeToast(String s) {
                        Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();
                    }

                });
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "Sign-up error", e);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(e.toString().contains("already exists"))
                        Toast.makeText(getActivity(),"Sign up error: "+e.toString().substring(78,97), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }




}







