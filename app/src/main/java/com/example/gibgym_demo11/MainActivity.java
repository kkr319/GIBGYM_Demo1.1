package com.example.gibgym_demo11;


import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.UserStateDetails;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.ModelProvider;
import com.amplifyframework.datastore.AWSDataStorePlugin;
import com.amplifyframework.datastore.generated.model.AmplifyModelProvider;
import com.example.gibgym_demo11.InitialPages.SplashFragment;


public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {


    private static final String TAG ="Amplify Initialised successfully";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        /*
        AWSMobileClient.getInstance().initialize(getApplicationContext(), new Callback<UserStateDetails>() {

            @Override
            public void onResult(UserStateDetails userStateDetails) {
                NavController navController = Navigation.findNavController(MainActivity.this,R.id.fragment);
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

         */

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {


        return super.onCreateView(name, context, attrs);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }





}
