package com.example.gibgym_demo11;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class GeneralSettingsFragment extends Fragment {

    String names[];
    int image[]={R.drawable.backbutton};
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_general_settings, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        names = getResources().getStringArray(R.array.glsetarr);

        recyclerView = getView().findViewById(R.id.recvGSFrag_rclv);

        GSAdapter gsAdapter = new GSAdapter(this.getContext(),names,image);
        recyclerView.setAdapter(gsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        super.onActivityCreated(savedInstanceState);
    }
}