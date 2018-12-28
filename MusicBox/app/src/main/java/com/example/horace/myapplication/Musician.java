package com.example.horace.myapplication;


import android.annotation.SuppressLint;
import android.os.Message;

import java.security.PublicKey;

public class Musician {
    /*这个类负责整首音乐的播放，调用一个scalePerformer*/
    private ScalePerformer scalePerformer;
    private  static int Songs[][]=new int[3][];
    private  int IndexSongs=0,Index=0;
    public  Musician(ScalePerformer scalePerformer){
        this.scalePerformer=scalePerformer;
        Songs[0]=new int[]{0,0,4,4,5,5,4,8,3,3,2,2,1,1,0,8,4,4,3,3,2,2,1,8,4,4,3,3,2,2,1,8,0,0,4,4,5,5,4,8,3,3,2,2,1,1,0,8};
        Songs[1]=new int[]{2,2,3,4,4,3,2,1,0,0,1,2,2,1,1,8,2,2,3,4,4,3,2,1,0,0,1,2,1,0,0,8};
        Songs[2]=new int[]{2,2,2,8,2,2,2,8,2,4,0,1,2,8,8,8,3,3,3,3,3,2,2,2,2,1,1,2,1,8,4,8,2,2,2,8,2,2,2,8,2,4,0,1,2,8,8,8,3,3,3,3,3,2,2,2,4,4,3,1,0,8};
    }
    android.os.Handler handler;
    boolean flag=false;
    boolean flag2=false;
    @SuppressLint("HandlerLeak")
    public void PlaySongsIndex(int i){

        if(!flag){
            flag=true;
            flag2=true;
            IndexSongs =i;
            handler=new android.os.Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if(Index<Songs[IndexSongs].length){
                        scalePerformer.playScaleNumber(Songs[IndexSongs][Index]);
                        if(flag)  {
                            this.sendEmptyMessageDelayed(++Index,400);
                        }
                    }
                    else {
                        Index=0;
                    }
                }
            };
            if(flag2){
                handler.sendEmptyMessage(Songs[IndexSongs][Index]);
                flag2=false;
            }
        }
        else{
            flag=false;
            flag2=true;
        }
    }
    public  void Stop(){
        flag=false;
    }
    public  int[][] GetSongs(){
        return Songs;
    }
    public boolean GetFlag(){ return flag;}
}

