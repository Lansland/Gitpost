package com.example.horace.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Message;

import java.io.IOException;

public class rhythm2Performer {
    /*
    控制音节播放的类
     */
    private Thread[] threads=new Thread[8];
    private  MediaPlayer[] mediaPlayers=new MediaPlayer[8];
    private final Activity runActivity;
    private android.os.Handler handler;
    private  int Index;
    public void playinstr(int Index){
        this.Index=Index;
        Message message= new Message();
        message.what=Index;
        handler.sendMessage(message);
    }
    public  void Stop2(){
        mediaPlayers[Index].stop();
    }
    @SuppressLint("HandlerLeak")
    public rhythm2Performer(Activity runActivity){
        this.runActivity=runActivity;
        mediaPlayers[1] = MediaPlayer.create(runActivity, R.raw.znq1);
        mediaPlayers[2] = MediaPlayer.create(runActivity, R.raw.cmg2);
        handler= new android.os.Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:{
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
                        threads[1].start();
                        break;
                    }
                    case 2:{
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
                                mediaPlayers[2].start();
                            }
                        };
                        threads[2].start();
                        break;
                    }

                }
            }
        };

    }
}
