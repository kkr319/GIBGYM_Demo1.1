package com.example.gibgym_demo11.InitialPages;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gibgym_demo11.R;

import java.util.ArrayList;

public class ViewPagerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        PagerAdapter pagerAdapter;
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_view_pager, container, false);

        ArrayList fragmentList = new ArrayList();
        //ArrayList fragmentList = CollectionsKt.arrayListOf(new Fragment[]{(Fragment)(new InitialFragment_Video()), (Fragment)(new InitialFragment2())});

        FragmentActivity fragmentActivity = this.requireActivity();
        FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
        Lifecycle lifecycle = this.getLifecycle();

        fragmentList.add(new InitialFragment1());
        fragmentList.add(new InitialFragment2());
        fragmentList.add(new InitialFragment3());
        fragmentList.add(new InitialFragment_Video());

        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentList,fragmentManager,lifecycle);
        ViewPager2 viewPager  = (ViewPager2) view.findViewById(R.id.viewPager);
        viewPager.setAdapter((RecyclerView.Adapter)adapter);

        /* FAKE DRAG
        viewPager.beginFakeDrag();
        viewPager.fakeDragBy(-2f);
        viewPager.endFakeDrag();
        */

        return view;
    }


/*
    public View onCreateView(@NotNull LayoutInflater inflater, @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        ArrayList fragmentList = CollectionsKt.arrayListOf(new Fragment[]{(Fragment)(new InitialFragment_Video()), (Fragment)(new InitialFragment2())});
        FragmentActivity var10003 = this.requireActivity();
        FragmentManager var7 = var10003.getSupportFragmentManager();
        Lifecycle var10004 = this.getLifecycle();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fragmentList, var7, var10004);
        ViewPager2 var10000 = (ViewPager2)view.findViewById(R.id.viewPager);
        var10000.setAdapter((RecyclerView.Adapter)adapter);
        return view;
    }
*/





}