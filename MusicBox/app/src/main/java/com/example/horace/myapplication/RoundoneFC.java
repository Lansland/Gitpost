package com.example.horace.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import pl.droidsonroids.gif.GifImageView;

public class RoundoneFC {
    private Activity runActivity;
    private ViewFlipper flipper;
    private int[] images=new int[]{R.drawable.shachui,R.drawable.muyu,R.drawable.linggu};
    private Activity[] activities=new Activity[3];
    private int Index=0;

    public  int GetIndex(){
        return  Index;
    }
    private ImageView[] imageViews;
    private Animation[] animation;


    private  Message message=new Message();
    private  int drag=0;
    private  Thread Thread=new Thread(){
    };
    public RoundoneFC(Activity activity, ViewFlipper vf){
        runActivity=activity;
        this.flipper=vf;
        imageViews=new ImageView[images.length];
        for(int i=0;i<images.length;i++){
            imageViews[i]=new ImageView(runActivity);
            imageViews[i].setImageResource(images[i]);
            flipper.addView(imageViews[i]);
        }
        animation=new Animation[4];
        animation[0]=AnimationUtils.loadAnimation(runActivity,R.anim.slide_in_right);
        animation[1]=AnimationUtils.loadAnimation(runActivity,R.anim.slide_in_left);
        animation[2]=AnimationUtils.loadAnimation(runActivity,R.anim.slide_out_left);
        animation[3]=AnimationUtils.loadAnimation(runActivity,R.anim.slide_out_right);
        flipper.setInAnimation(animation[0]);
        flipper.setOutAnimation(animation[2]);
        message.what=0;


        activities[0]=new ScaleActivity();
        initEvent();
    }

    private boolean flag=false;
    @SuppressLint("HandlerLeak")
    private android.os.Handler handler=new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
                if(flag==false&&((message.what==0||message.what==1))){
                    Thread=new Thread(){
                        @Override
                        public void run() {
                            super.run();
                            flag=true;
                            if(message.what==0){
                                flipper.showPrevious();
                                Index--;
                                if(Index<0){
                                    Index=images.length-1;
                                }
                            }
                            else if (message.what==1){
                                flipper.showNext();
                                Index++;
                                if(Index==images.length){
                                    Index=0;
                                }
                            }


                        Message message2=new Message();
                            message2.what=3;
                            sendMessageDelayed(message2,1000);
                        }
                    };
                    Thread.run();
                }
                if(msg.what==3){
                    flag=false;
                }
        }
    };

    private  float mPosX,mPosY,mCurPosX,mCurPosY;


    @SuppressLint("ClickableViewAccessibility")
    private  void initEvent(){
        flipper.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    // TODO Auto-generated method stub
                    if(flag==false) {
                        switch (event.getAction()) {

                            case MotionEvent.ACTION_DOWN:
                                mPosX = event.getX();
                                mPosY = event.getY();
                                break;
                            case MotionEvent.ACTION_MOVE:

                                break;
                            case MotionEvent.ACTION_UP:
                                mCurPosX = event.getX();
                                mCurPosY = event.getY();
                                if (mCurPosX - mPosX > 0 && (Math.abs(mCurPosX - mPosX) > 100)) {
                                    message=new Message();
                                    flipper.setInAnimation(animation[1]);
                                    flipper.setOutAnimation(animation[3]);
                                    message.what = 0;
                                    handler.sendMessage(message);
                                    return true;
                                } else if (mCurPosX - mPosX < 0
                                        && (Math.abs(mCurPosX - mPosX) > 100)) {
                                    message=new Message();
                                    flipper.setInAnimation(animation[0]);
                                    flipper.setOutAnimation(animation[2]);
                                    message.what = 1;
                                    handler.sendMessage(message);
                                    return  true;
                                }
                                mCurPosX =mPosX;
                                break;
                        }
                    }
                    return false;
                }

            });
        final  String TAG="xxx";
        flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: A");
                if(flag==false){
                    Log.d(TAG, "onClick: B");
                    switch (Index){

                        case 0:
                            Log.d(TAG, "onClick: c");
                            Intent intent=new Intent(runActivity,activities[0].getClass());
                            runActivity.startActivity(intent);
                            break;
                    }
                }
            }
        });
    }
}
