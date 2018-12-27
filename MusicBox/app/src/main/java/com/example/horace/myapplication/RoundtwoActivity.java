package com.example.horace.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ViewFlipper;
import android.content.Intent;

import java.io.IOException;

public class RoundtwoActivity extends AppCompatActivity {
    MediaPlayer mp;
    MediaPlayer mp1;
    MediaPlayer mp2;
    private RoundtwoFC fc;
    private ImageButton confirmBtn;
    private final Thread[]  threads=new Thread[5];
    private Handler handler;
    MediaPlayer[] mediaPlayers;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roundtwo);
        confirmBtn=(ImageButton)findViewById(R.id.confirm);
        mp=MediaPlayer.create(this, R.raw.tip24);
        mp.setLooping(false);
        mp.start();
        mp1=MediaPlayer.create(this, R.raw.syz);
        mp1.setLooping(false);
        mp2=MediaPlayer.create(this, R.raw.fsj);
        mp2.setLooping(false);
        ((ImageButton) findViewById(R.id.rhythm01)).setBackgroundResource(R.drawable.rhythm03);
        fc=new RoundtwoFC(this,(ViewFlipper)findViewById(R.id.vf),(ImageButton) findViewById(R.id.rhythm01));

        mediaPlayers=new MediaPlayer[5];

        threads[1]=new Thread(){
            @Override
            public void run() {
                super.run();
                if(threads[1]!=null)
                    if(threads[1].isAlive())
                        threads[1].destroy();
                threads[1] = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        mediaPlayers[1].stop();
                        try {
                            mediaPlayers[1].prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mediaPlayers[1].start();
                    }
                };
            }
        };
        threads[2]=new Thread(){
            @Override
            public void run() {
                super.run();
                if(threads[2]!=null)
                    if(threads[2].isAlive())
                        threads[2].destroy();
                threads[2] = new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        mediaPlayers[2].stop();
                        try {
                            mediaPlayers[2].prepare();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                threads[2].start();
            }
        };
        handler= new android.os.Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:{
                        threads[1].start();
                        break;
                    }
                    case 2:{
                        threads[2].start();
                        break;
                    }
                }
            }
        };

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayers[1].stop();
                mediaPlayers[2].stop();
                mp.stop();
                Intent intent1=new Intent(RoundtwoActivity.this, Selectrhythm2Activity.class);
                startActivity(intent1);

            }
        });

        reset();
    }
    public void playerBtnClick(View view) {
        if(!mp.isPlaying()){
            //stopping
            mp.start();

        }else mp.pause();

    }
    public  void reset(){
        findViewById(R.id.rhythm01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fc.getIndex()%2==1){
                    try{
                        mediaPlayers[1].stop();
                    }catch (Exception e){

                    }
                    try{
                        mediaPlayers[2].stop();
                    }catch (Exception e){

                    }
                    mediaPlayers[1] = MediaPlayer.create(RoundtwoActivity.this, R.raw.fsj);
                    mediaPlayers[1].start();

                }
                else{
                    try{
                        mediaPlayers[2].stop();
                    }catch (Exception e){

                    }
                    try{
                        mediaPlayers[1].stop();
                    }catch (Exception e){

                    }
                    mediaPlayers[2] = MediaPlayer.create(RoundtwoActivity.this, R.raw.syz);
                    mediaPlayers[2].start();
                }
            }
        });
    }
}
