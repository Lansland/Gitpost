package com.example.horace.myapplication;

import android.app.Activity;
import android.os.Message;
import android.print.PrinterId;
import android.view.Gravity;
import android.widget.Toast;

import java.util.logging.Handler;

public class Exam {
    //负责考试
    //考察是否能按照Musician中的音乐播放
    private Musician musician;
    private int[][]  testSongs;
    private android.os.Handler handler;
    private  int time=0;
    private  final  int timeOutValue=50;
    private int songsIndex=0;
    private Activity run;
    private boolean flag=false;
    private android.os.Handler timer=new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(flag){
                time++;
                if(time>=timeOutValue){
                    timeOutOverExam();
                }
                else {
                    timer.sendMessageDelayed(new Message(),200);
                }
            }
        }
    };
    private static String[]  encourageWords={
            "加油",
            "ok",
            "太厉害",
            "Good",
            "Perfect!",
            "fantastic"
    };
    public Exam(Activity run,Musician musician){
        this.musician=musician;
        this.run=run;
        testSongs=musician.GetSongs();
    }
    private  int Index=0;
    public void ExamSongsStart(int SongsIndex) {
        time=0;
        timer.sendMessage(new Message());
        Toast toast= Toast.makeText(run,"进入考试模式",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, run.getWindowManager().getDefaultDisplay().getHeight()/ 4);
        toast.show();

        flag=true;
        this.songsIndex=SongsIndex;
        Index=0;
        this.handler = new android.os.Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                time=0;
                if(flag){
                    if(testStep(Index,msg.what)){
                        encourage(Index);
                    }
                    else{
                        overExam();
                    }
                }
            }
        };
    }
    public  void inputScale(int scaleValue){
        if(flag){
            Message message= new Message();
            message.what=scaleValue;
            handler.sendMessage(message);
        }
        else{

        }
    }
    private  boolean testStep(int Index,int value){
        if(testSongs[songsIndex][Index]==value){
            return  true;
        }else {
            return false;
        }
    }
    private void encourage(int Index){
        Toast.makeText(run,encourageWords[Index%encourageWords.length],Toast.LENGTH_SHORT).show();
    }
    private void overExam(){

        Toast toast= Toast.makeText(run,"弹奏失误",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, run.getWindowManager().getDefaultDisplay().getHeight()/ 4);
        toast.show();

        Toast toast2= Toast.makeText(run,"退出考试模式",Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.TOP, 0, run.getWindowManager().getDefaultDisplay().getHeight()/ 4);
        toast2.show();


        flag=false;
    }
    private void timeOutOverExam(){
        Toast toast= Toast.makeText(run,"弹奏超时",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, run.getWindowManager().getDefaultDisplay().getHeight()/ 4);
        toast.show();

        Toast toast2= Toast.makeText(run,"退出考试模式",Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.TOP, 0, run.getWindowManager().getDefaultDisplay().getHeight()/ 4);
        toast2.show();
        flag=false;
    }

}
