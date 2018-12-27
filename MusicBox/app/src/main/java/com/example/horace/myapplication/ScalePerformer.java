package com.example.horace.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
public class ScalePerformer {
    /*
    控制音节播放的类
     */
    private Thread[] threads=new Thread[8];
    private MediaPlayer[] mediaPlayers=new MediaPlayer[8];
    private final Activity runActivity;
    private ImageButton[] imageButtons;
    private android.os.Handler handler;
    private ImageView imageView[];
    @SuppressLint("HandlerLeak")
    public ScalePerformer(Activity runActivity, ImageButton[] imageButtons, ImageView[] imageViews){
        this.imageView=imageViews;
        this.runActivity=runActivity;
        mediaPlayers[0] = MediaPlayer.create(runActivity, R.raw.do1);
        mediaPlayers[1] = MediaPlayer.create(runActivity, R.raw.re);
        mediaPlayers[2] = MediaPlayer.create(runActivity, R.raw.mi);
        mediaPlayers[3] = MediaPlayer.create(runActivity, R.raw.fa);
        mediaPlayers[4] = MediaPlayer.create(runActivity, R.raw.so);
        mediaPlayers[5] = MediaPlayer.create(runActivity, R.raw.la);
        mediaPlayers[6] = MediaPlayer.create(runActivity, R.raw.si);
        mediaPlayers[7] = MediaPlayer.create(runActivity, R.raw.do2);
        handler= new android.os.Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:{
                        if(threads[0]!=null)
                            if(threads[0].isAlive())
                                threads[0].destroy();
                        threads[0] = new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                mediaPlayers[0].stop();
                                try {
                                    mediaPlayers[0].prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                mediaPlayers[0].start();
                            }
                        };
                        threads[0].start();
                        break;

                    }
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
                    case 7:{
                        if(threads[7]!=null)
                            if(threads[7].isAlive())
                                threads[7].destroy();
                        threads[7] = new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                mediaPlayers[7].stop();

                                try {
                                    mediaPlayers[7].prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                mediaPlayers[7].start();
                            }
                        };
                        threads[7].start();
                        break;
                    }


                }
            }
        };
        this.imageButtons=imageButtons;
        imageButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        });
        imageButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });
        imageButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=2;
                handler.sendMessage(message);
            }
        });
        imageButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=3;
                handler.sendMessage(message);
            }
        });
        imageButtons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=4;
                handler.sendMessage(message);
            }
        });
        imageButtons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=5;
                handler.sendMessage(message);
            }
        });
        imageButtons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=6;
                handler.sendMessage(message);
            }
        });
        imageButtons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=7;
                handler.sendMessage(message);
            }
        });
        for (ImageView img:imageViews) {
            img.setVisibility(View.INVISIBLE);
        }
    }
    @SuppressLint("HandlerLeak")
    public ScalePerformer(Activity runActivity, ImageButton[] imageButtons){
        this.runActivity=runActivity;
        mediaPlayers[0] = MediaPlayer.create(runActivity, R.raw.do1);
        mediaPlayers[1] = MediaPlayer.create(runActivity, R.raw.re);
        mediaPlayers[2] = MediaPlayer.create(runActivity, R.raw.mi);
        mediaPlayers[3] = MediaPlayer.create(runActivity, R.raw.fa);
        mediaPlayers[4] = MediaPlayer.create(runActivity, R.raw.so);
        mediaPlayers[5] = MediaPlayer.create(runActivity, R.raw.la);
        mediaPlayers[6] = MediaPlayer.create(runActivity, R.raw.si);
        mediaPlayers[7] = MediaPlayer.create(runActivity, R.raw.do2);
        handler= new android.os.Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:{
                        if(threads[0]!=null)
                            if(threads[0].isAlive())
                                threads[0].destroy();
                        threads[0] = new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                mediaPlayers[0].stop();
                                try {
                                    mediaPlayers[1].prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                mediaPlayers[0].start();
                            }
                        };
                        threads[0].start();
                        break;

                    }
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
                    case 7:{
                        if(threads[7]!=null)
                            if(threads[7].isAlive())
                                threads[7].destroy();
                        threads[7] = new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                mediaPlayers[7].stop();

                                try {
                                    mediaPlayers[7].prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                mediaPlayers[7].start();
                            }
                        };
                        threads[7].start();
                        break;
                    }
                }
            }
        };
        this.imageButtons=imageButtons;
        imageButtons[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=0;
                handler.sendMessage(message);
            }
        });
        imageButtons[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=1;
                handler.sendMessage(message);
            }
        });
        imageButtons[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=2;
                handler.sendMessage(message);
            }
        });
        imageButtons[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=3;
                handler.sendMessage(message);
            }
        });
        imageButtons[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=4;
                handler.sendMessage(message);
            }
        });
        imageButtons[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=5;
                handler.sendMessage(message);
            }
        });
        imageButtons[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=6;
                handler.sendMessage(message);
            }
        });
        imageButtons[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message= new Message();
                message.what=7;
                handler.sendMessage(message);
            }
        });

    }

    private boolean btnEnabled=true;
    public void playScaleNumber(int i){
        try{
            if(btnEnabled){
                for (int s=0;s<=7;s++){
                    imageButtons[s].setEnabled(false);
                }
                btnEnabled=false;
            }
        }
        catch (Exception e){

        }
        try {
            for (int x = 0; x <= 7; x++) {
                imageView[x].setVisibility(View.INVISIBLE);
            }
        }
        catch (Exception e){}
        if(i>=0&&i<=7){
            Message message=new Message();
            message.what=i;
            handler.sendMessage(message);
            imageView[i].setVisibility(View.VISIBLE);
        }
        else if(i>0){
            try{
                for (int s=0;s<=7;s++){
                    imageButtons[s].setEnabled(true);
                }
                btnEnabled=true;
            }
            catch (Exception e){

            }
            for (int x = 0; x <=7; x++) {
                imageView[x].setVisibility(View.INVISIBLE);
            }

        }


    }

}
