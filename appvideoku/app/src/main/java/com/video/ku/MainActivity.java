package com.video.ku;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.khizar1556.mkvideoplayer.MKPlayer;

public class MainActivity extends AppCompatActivity {

    MKPlayer mkPlayer;
    String url = "https://cdn0-a.production.vidio.static6.com/uploads/776180/lagu-20balonku-20ada-20lima-86e0-b600.mp4.m3u8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mkPlayer = new MKPlayer(this);
        mkPlayer.play(url);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
