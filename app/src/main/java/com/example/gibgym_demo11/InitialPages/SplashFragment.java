package com.example.gibgym_demo11.InitialPages;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gibgym_demo11.MainActivity;
import com.example.gibgym_demo11.R;

public class SplashFragment extends Fragment {

    private static final String TAG = "Error:!!!";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_splash, container, false);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                NavController navCon = Navigation.findNavController(getActivity(), R.id.fragment);

                if(SplashFragment.this.onBoardingFinished()){
                    navCon.navigate(R.id.homeFragment);
                }else {
                    navCon.navigate(R.id.action_splashFragment_to_viewPagerFragment);
                }
            }
        };
        handler.postDelayed(runnable,3000);
        return  view;
    }

    private final boolean onBoardingFinished() {
        SharedPreferences sharedPref = this.requireActivity().getSharedPreferences("onBoarding", 0);
        return sharedPref.getBoolean("Finished", false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
}