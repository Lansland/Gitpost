
package com.example.horace.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import pl.droidsonroids.gif.GifImageButton;


public class steptwo extends AppCompatActivity {
    private ImageButton shachuiBtn;
    private ImageButton lingguBtn;
    private ImageButton muyuBtn;
    MediaPlayer mp;
    private GifImageButton girlBtn;
    private int num=0;
    private String TAG="steptwo";
    private final Activity tep=this;
    Intent intents[]=new Intent[6];
    private  saveManager saveManager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steptwo);

        this.saveManager=new saveManager(this);
        shachuiBtn=findViewById(R.id.shachui);
        lingguBtn=findViewById(R.id.linggu);
        muyuBtn=findViewById(R.id.muyu);
        girlBtn=findViewById(R.id.girl);

        //mediaplayer
        mp=MediaPlayer.create(this, R.raw.step2tips1);
        mp.setLooping(false);
        mp.start();

        shachuiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent1=new Intent(steptwo.this,RoundoneActivity.class);
               // startActivity(intent1);
                shachuiBtn.setVisibility(View.INVISIBLE);
                num++;
                if(num==3){
                    mp.stop();
                    Log.d(TAG, "onCreate: sucess");
                    gotoStep(1,tep);
                }

            }
        });

        lingguBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lingguBtn.setVisibility(View.INVISIBLE);
                num++;
                if(num==3){
                    mp.stop();
                    gotoStep(1,tep);
                }
            }
        });

        muyuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                muyuBtn.setVisibility(View.INVISIBLE);
                num++;
                if(num==3){
                    mp.stop();
                   gotoStep(1,tep);
                }
            }
        });

    }




    public void gotoStep(int Index, Activity run){
        switch (Index){
            case 1:
            {
                intents[1]=new Intent(run,RoundoneActivity.class);
                startActivity(intents[1]);
                break;
            }
            case 2:
            {
                intents[2]=new Intent(run,SelectinstrumentActivity.class);
                startActivity(intents[2]);
                break;
            }
            case 3:
            {
                intents[3]=new Intent(run,SelectrhytmActivity.class);
                startActivity(intents[3]);
                break;
            }

            case 4:
            {
                intents[4]=new Intent(run,RoundtwoActivity.class);
                startActivity(intents[4]);
                break;
            }

            case 5:
            {
                intents[5]=new Intent(run,Selectrhythm2Activity.class);
                startActivity(intents[5]);
                break;
            }
        }
    }
    public void gotoStep(int Index,SelectinstrumentActivity run){
        switch (Index){
            case 1:
            {
                intents[1]=new Intent(run,RoundoneActivity.class);
                startActivity(intents[1]);
                break;
            }
            case 2:
            {
                intents[2]=new Intent(run,SelectinstrumentActivity.class);
                startActivity(intents[2]);
                break;
            }
            case 3:
            {
                intents[3]=new Intent(run,SelectrhytmActivity.class);
                startActivity(intents[3]);
                break;
            }

            case 4:
            {
                intents[4]=new Intent(run,RoundtwoActivity.class);
                startActivity(intents[4]);
                break;
            }

            case 5:
            {
                intents[5]=new Intent(run,Selectrhythm2Activity.class);
                startActivity(intents[5]);
                break;
            }
        }
    }
    public  void Test(){

    }
    public void playerBtnClick(View view) {
        if(!mp.isPlaying()){
            //stopping
            mp.start();
        }else mp.pause();

    }
}
