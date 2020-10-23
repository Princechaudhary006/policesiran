package com.pcsolution.policesiran;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);
        imageView=findViewById(R.id.image2);
        musics();
        light();

    }
    private void musics()
    {
        mediaPlayer=MediaPlayer.create(this,R.raw.policesirna);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }
    private void light()
    {
        ObjectAnimator animator=ObjectAnimator.ofInt(imageView,"BackgroundColor", Color.RED,Color.BLUE);
        animator.setDuration(150);
        animator.setEvaluator(new ArgbEvaluator());
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();

    }
    @Override
    public void onBackPressed() {
        mediaPlayer.stop();
        super.onBackPressed();
    }
}