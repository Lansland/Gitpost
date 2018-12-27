package com.example.horace.myapplication;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class RoundoneActivity extends AppCompatActivity {
    MediaPlayer mp;
    MediaPlayer mp1;
    MediaPlayer mp2;
    private RoundoneFC fc;
    private ImageButton confirmBtn;
    private roundonePerformer roundonePerformer;
    private  saveManager saveManager=new saveManager();


    private Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roundone);
        activity=this;
        confirmBtn=(ImageButton)findViewById(R.id.confirm);
        // Resources file



        mp=MediaPlayer.create(this, R.raw.tip21);
        mp.setLooping(false);
        mp.start();
        mp1=MediaPlayer.create(this, R.raw.fish11);
        mp1.setLooping(false);
        mp2=MediaPlayer.create(this, R.raw.fish12);
        mp2.setLooping(false);
        fc=new RoundoneFC(this,(ViewFlipper)findViewById(R.id.vfround1));
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.stop();
                saveManager.gotoStep(2,activity);
                finish();
            }
        });

        roundonePerformer =new roundonePerformer(this);

    }

    public void playerBtnClick(View view) {
        if(!mp.isPlaying()){
            //stopping
            mp.start();

        }else mp.pause();

    }
    public void playrhythm1(View view) {
        mp.stop();
            roundonePerformer.playinstr(2*fc.GetIndex()+1);
    }
    public void playrhythm2(View view) {
        mp.stop();
            roundonePerformer.playinstr(2*fc.GetIndex()+2);
    }

    @Override
    public void finish() {
        super.finish();
        roundonePerformer.stopIndex();
    }
}
