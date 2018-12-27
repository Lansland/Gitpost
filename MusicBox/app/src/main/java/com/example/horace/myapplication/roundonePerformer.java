package com.example.horace.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

import pl.droidsonroids.gif.GifImageView;

public class roundonePerformer {
    /*
    控制音节播放的类
     */
    private Thread[] threads=new Thread[8];
    private MediaPlayer[] mediaPlayers=new MediaPlayer[8];
    private final Activity runActivity;
    @SuppressLint("HandlerLeak")
    private android.os.Handler handler = new android.os.Handler() {
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
                case 3:{
                    if(threads[3]!=null)
                    if(threads[3].isAlive())
                        threads[3].destroy();
                    threads[3] = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            mediaPlayers[3].stop();

                            try {
                                mediaPlayers[3].prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            mediaPlayers[3].start();
                        }
                    };
                    threads[3].start();
                    break;
                }
                case 4:{
                    if(threads[4]!=null)
                    if(threads[4].isAlive())
                        threads[4].destroy();
                    threads[4] = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            mediaPlayers[4].stop();

                            try {
                                mediaPlayers[4].prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            mediaPlayers[4].start();
                        }
                    };
                    threads[4].start();
                    break;
                }
                case 5:{
                    if(threads[5]!=null)
                    if(threads[5].isAlive())
                        threads[5].destroy();
                    threads[5] = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            mediaPlayers[5].stop();

                            try {
                                mediaPlayers[5].prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            mediaPlayers[5].start();
                        }
                    };
                    threads[5].start();
                    break;
                }
                case 6:{
                    if(threads[6]!=null)
                    if(threads[6].isAlive())
                        threads[6].destroy();
                    threads[6] = new Thread() {
                        @Override
                        public void run() {
                            super.run();
                            mediaPlayers[6].stop();

                            try {
                                mediaPlayers[6].prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            mediaPlayers[6].start();
                        }
                    };
                    threads[6].start();
                    break;
                }

            }
        }
    };
    private  int Index;



    public void playinstr(int Index){
        this.Index=Index;
        Message message= new Message();
        message.what=Index;
        handler.sendMessage(message);
    }
    public  void stopIndex(){
        mediaPlayers[Index].stop();
    }
    public roundonePerformer(Activity runActivity){
        this.runActivity=runActivity;
        mediaPlayers[1] = MediaPlayer.create(runActivity, R.raw.sandhammer11);
        mediaPlayers[2] = MediaPlayer.create(runActivity, R.raw.sandhammer12);
        mediaPlayers[3] = MediaPlayer.create(runActivity, R.raw.fish11);
        mediaPlayers[4] = MediaPlayer.create(runActivity, R.raw.fish12);
        mediaPlayers[5] = MediaPlayer.create(runActivity, R.raw.tamdrum11);
        mediaPlayers[6] = MediaPlayer.create(runActivity, R.raw.tamdrum12);

    }
}
