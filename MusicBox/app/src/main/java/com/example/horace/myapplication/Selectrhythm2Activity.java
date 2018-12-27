package com.example.horace.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class Selectrhythm2Activity extends AppCompatActivity {
    MediaPlayer mp;
    private ImageButton[] buttons=new ImageButton[3];
    private int Key=0;
    private rhythm2Performer rp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectrhythm2);
        mp=MediaPlayer.create(this, R.raw.tip23);
        mp.setLooping(false);
        mp.start();
        initBtn();
    }
    public  void initBtn(){
        rp=new rhythm2Performer(this);
        Random random=new Random();
        Key=random.nextInt(2)+1;
        (buttons[0]=findViewById(R.id.playBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                rp.playinstr(Key);
            }
        });
        (buttons[1]=findViewById(R.id.rhythm1Btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Key==1){
                    TrueMethod();
                }
                else
                {
                    FalseMethod();
                }
            }
        });
        (buttons[2]=findViewById(R.id.rhythm2Btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Key==2){
                    TrueMethod();
                }
                else
                {
                    FalseMethod();
                }
            }
        });
    }
    private void TrueMethod(){
        final Intent intent=new Intent(this,SucessActivity.class);
        Toast.makeText(this,"回答正确", Toast.LENGTH_SHORT).show();
        @SuppressLint("HandlerLeak") Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                rp.Stop2();
                mp.stop();


                startActivity(intent);
            }
        };
        handler.sendMessageDelayed(new Message(),500);
    }
    private void FalseMethod(){
        Toast.makeText(this,"回答错误", Toast.LENGTH_SHORT).show();
        Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
        handler.sendMessageDelayed(new Message(),1000);
    }
    public void playerBtnClick(View view) {
        if(!mp.isPlaying()){
            //stopping
            mp.start();

        }else mp.pause();

    }
}
