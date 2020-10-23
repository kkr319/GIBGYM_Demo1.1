package com.example.gibgym_demo11.Authentication;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
import android.widget.Button;
import android.widget.Toast;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.example.gibgym_demo11.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private static final String TAG = "ERROR:!!!";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AWSMobileClient.getInstance().initialize(getContext(), new Callback<UserStateDetails>() {

            @Override
            public void onResult(UserStateDetails userStateDetails) {
                NavController navController = Navigation.findNavController(getView());
                Log.i(TAG, userStateDetails.getUserState().toString());
                switch (userStateDetails.getUserState()){
                    case SIGNED_IN:
                        //navController.navigate(R.id.scrollFragment2);
                        //Intent i = new Intent(MainActivity.this, LogicActivity.class);
                        //startActivity(i);
                        if(navController.popBackStack(R.id.scrollFragment2, false)) {
                            Log.d(TAG, "SettingsFragment found in backStack");
                        } else {
                            Log.d(TAG, "SettingsFragment not found in backStack, navigate manually");
                            navController.navigate(R.id.scrollFragment2);
                        }
                        break;
                    case GUEST:
                        break;
                    case SIGNED_OUT_FEDERATED_TOKENS_INVALID:
                        break;
                    case SIGNED_OUT_USER_POOLS_TOKENS_INVALID:
                        break;
                    case SIGNED_OUT:
                        //LoginFragment loginFragment = new LoginFragment();
                        //loginFragment.login();

                        break;
                    case UNKNOWN:
                        break;
                    default:
                        AWSMobileClient.getInstance().signOut();
                        break;
                }
            }

            @Override
            public void onError(Exception e) {
                Log.e(TAG, e.toString());
            }
        });

        Button homeRegButton = getView().findViewById(R.id.button_home_reg);
        Button homeLoginButton = getView().findViewById(R.id.button_home_login);

        homeRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCon = Navigation.findNavController(view);
                navCon.navigate(R.id.action_homeFragment_to_registerFragment);
            }
        });

        homeLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navCon = Navigation.findNavController(view);
                //navCon.popBackStack(R.id.loginFragment,false);
               //Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_loginFragment);
                navCon.navigate(R.id.action_homeFragment_to_loginFragment);
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
