package com.example.restaurantapplinuiyanbdt20051;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MusicActivityBDT20051 extends AppCompatActivity implements View.OnClickListener {

    Button Playbtn, Pauebtn, Stopbtn;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_bdt20051);
        Playbtn = findViewById(R.id.buttonlinuoyan);
        Pauebtn = findViewById(R.id.button2linuoyan);
        Stopbtn = findViewById(R.id.button3linuoyan);

        Playbtn.setOnClickListener(this);
        Pauebtn.setOnClickListener(this);
        Stopbtn.setOnClickListener(this);
        intMediaPlayer();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonlinuoyan) {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
            }
        } else if (v.getId() == R.id.button2linuoyan) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            }
        } else if (v.getId() == R.id.button3linuoyan) {
            mediaPlayer.reset();
            intMediaPlayer();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    private void intMediaPlayer() {
        mediaPlayer = MediaPlayer.create(MusicActivityBDT20051.this, R.raw.mtest);
    }
}
