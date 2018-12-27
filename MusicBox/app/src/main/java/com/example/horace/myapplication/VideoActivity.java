package com.example.horace.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

public class VideoActivity extends AppCompatActivity {
    private  SurfaceView sf;
    private  VideoController vc;


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            (vc=new VideoController(VideoActivity.this)).Create(sf);
        }
    };
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        Toast.makeText(this,"进入教程，双击退出",Toast.LENGTH_SHORT);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        sf=findViewById(R.id.sv);
        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i==2){
                    finish();
                }
            }
        });
        handler.sendMessageDelayed(new Message(),50);
    }
    @Override
    public void finish() {
        super.finish();
        try {
            vc.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
