package com.example.restaurantapplinuiyanbdt20051;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class VideoActivityBDT20051 extends AppCompatActivity implements View.OnClickListener{
        MediaPlayer mMediaPlayer;
        SurfaceView mSurfaceView;
        Button mLoad,mPause,mPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_bdt20051);
        mSurfaceView = findViewById(R.id.surfaceView1linuoyan);
        mLoad = findViewById(R.id.load1linuoyan);
        mPause = findViewById(R.id.pause1linuoyan);
        mPlay = findViewById(R.id.play1linuoyan);

        mMediaPlayer = new MediaPlayer();

        mLoad.setOnClickListener(this);
        mPlay.setOnClickListener(this);
        mPause.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.load1linuoyan)
        {
            try {
                mMediaPlayer.reset();
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                String path = "android.resource://com.example.restaurantapplinuiyanbdt20051/"+R.raw.sample;
                mMediaPlayer.setDataSource(this, Uri.parse(path));

                mMediaPlayer.setDisplay(mSurfaceView.getHolder());
                mMediaPlayer.prepare();

            }
            catch (Exception e) {
                Log.i("MediaPlay err","MediaPlay err");
            }
        }
        if(v.getId()==R.id.pause1linuoyan)
        {
            mMediaPlayer.pause();
        }
        if (v.getId()==R.id.play1linuoyan)
        {
            mMediaPlayer.start();
        }
    }

}