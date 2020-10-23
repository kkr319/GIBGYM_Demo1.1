package com.example.gibgym_demo11.Authentication;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
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
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.results.ForgotPasswordResult;
import com.example.gibgym_demo11.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;


public class ForgotPasswordFragment extends Fragment {

   private static final String TAG = ForgotPasswordFragment.class.getSimpleName();


    @Override
    public void onCreate(Bundle savedInstanceState) {

        //Back button click do nothing
        getActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        });
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button fgpFragConfirmButton = getView().findViewById(R.id.button_forgotFrag_confirm);
        fgpFragConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmNewPassword();
            }
        });
    }

    private void confirmNewPassword(){
        EditText verifyCode = getView().findViewById(R.id.editTextNumber_forgotFrag_confCode);
        EditText newpassword = getView().findViewById(R.id.editTextTextPassword_forgotFrag_newPass);
        EditText conpassword = getView().findViewById(R.id.editTextTextPassword_forgotFrag_newPassConfirm);

        final String SverifyCode = verifyCode.getText().toString();
        final String Snewpassword = newpassword.getText().toString();
        final String Sconpassword = conpassword.getText().toString();

        if(!Snewpassword.equals(Sconpassword)){
            Toast.makeText(getActivity(),"Passwords do not match",Toast.LENGTH_LONG).show();
        }else if(!isValidPassword(Snewpassword)){
            Toast.makeText(getActivity(),"Passwords must be at least 8 characters and contain at least one capital letter and one digit",Toast.LENGTH_LONG).show();
        }else
        actualConfirmNewPassword(Snewpassword,SverifyCode);

    }

    public void actualConfirmNewPassword(String password, String confoirmationCode){
        AWSMobileClient.getInstance().confirmForgotPassword(password, confoirmationCode, new Callback<ForgotPasswordResult>() {
            @Override
            public void onResult(final ForgotPasswordResult result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "forgot password state: " + result.getState());
                        switch (result.getState()) {
                            case DONE:
                                makeToast("Password changed successfully");
                                NavController navCon1 = Navigation.findNavController(getView());
                                navCon1.navigate(R.id.action_forgotPasswordFragment_to_loginFragment);
                                break;
                            default:
                                Log.e(TAG, "un-supported forgot password state");
                                break;
                        }
                    }
                });
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, "forgot password error", e);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(e.toString().contains("Invalid verification code provided")) {
                            Toast.makeText(getActivity(), "Error: " + e.toString().substring(76, 110), Toast.LENGTH_LONG).show();
                        }else if(e.toString().contains("Attempt limit exceeded")){
                            Toast.makeText(getActivity(), "Error: You have tried too many times, please try after some time" , Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    private void makeToast(String password_changed_successfully) {
        Toast.makeText(getActivity(),password_changed_successfully,Toast.LENGTH_LONG).show();
    }

    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

}