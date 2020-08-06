package com.example.gibgym_demo11.InitialPages;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.gibgym_demo11.R;

public class InitialFragment_Video extends Fragment implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener {

    private VideoView video;

    public static InitialFragment_Video getInstance(int resId, boolean showWelcome) {
        InitialFragment_Video fragment = new InitialFragment_Video();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.fragment_initial_video, container, false);
        video = (VideoView) view.findViewById(R.id.videoView_initit_one);

        String path = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.guide3;

        video.setVideoURI(Uri.parse(path));
        /*
        video.start();
        video.requestFocus();
*/      initEvent();
        return view;
    }

    private void initEvent() {
        video.setOnPreparedListener(this);
    }
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (video != null) {
            video.requestFocus();
            video.seekTo(0);
            video.start();
            video.setOnCompletionListener(this);
        }
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        video.requestFocus();
        video.seekTo(0);
        video.start();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (video != null) {
            video.stopPlayback();
        }
    }
}