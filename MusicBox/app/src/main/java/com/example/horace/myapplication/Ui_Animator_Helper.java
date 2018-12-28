package com.example.horace.myapplication;
import android.annotation.SuppressLint;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;

public class Ui_Animator_Helper {
    public void myAnimation(final View view){
        final ViewPropertyAnimatorCompat animation= ViewCompat.animate(view);
                animation
                .setDuration(60)
                .alpha(1f)
                .translationY(0)
                .start();
     @SuppressLint("HandlerLeak")
        final android.os.Handler  handler3 =new android.os.Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                animation
                        .setDuration(50)
                        .scaleX(1f)
                        .scaleY(1f)
                        .alpha(1f)
                        .translationY(40f)
                        .start();
            }
        };
      @SuppressLint("HandlerLeak")
        final android.os.Handler handler2=new android.os.Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                animation
                        .setDuration(50)
                        .scaleX(1f)
                        .scaleY(1f)
                        .alpha(1f)
                        .translationY(0f)
                        .start();
                Message message =new Message();
                handler3.sendMessageDelayed(message,50);
            }
        };

      @SuppressLint("HandlerLeak")
        final android.os.Handler handler =new android.os.Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                animation
                        .setDuration(50)
                        .translationY(-40f)
                        .alpha(1f)
                        .start();
                Message message =new Message();
                handler2.sendMessageDelayed(message,50);
            }
        };
        Message message =new Message();
        handler.sendMessageDelayed(message,60);
    }

    public void btnAnimation(final View view){
        final ViewPropertyAnimatorCompat btnClickedAnimation=ViewCompat.animate(view);
              btnClickedAnimation
                      .setDuration(60)
                      .start();
        final android.os.Handler handler1=new android.os.Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                btnClickedAnimation
                        .setDuration(80)
                        .scaleX(1f)
                        .scaleY(1f)
                        .start();
            }
        };

        final android.os.Handler handler=new android.os.Handler(){
            @Override
            public void handleMessage(Message msg){
                super.handleMessage(msg);
                btnClickedAnimation
                        .setDuration(80)
                        .scaleX(0.5f)
                        .scaleY(0.5f)
                        .start();
                Message message =new Message();
                handler1.sendMessageDelayed(message,80);
            }
        };
        Message message =new Message();
        handler.sendMessageDelayed(message,60);


    }

}
