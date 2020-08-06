package com.example.gibgym_demo11.InitialPages;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList fragmentList;

    public ViewPagerAdapter(@NonNull ArrayList<Fragment> list, @NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.fragmentList = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Object fragPosition = this.fragmentList.get(position);
        return (Fragment)fragPosition;
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}

