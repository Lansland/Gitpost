package com.example.horace.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SucessActivity extends AppCompatActivity {
    MediaPlayer mp;
    ImageButton homeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucess);
        homeBtn=findViewById(R.id.backtohome);

        mp=MediaPlayer.create(this, R.raw.celebration);
        mp.setLooping(false);
        mp.start();
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home=new Intent(SucessActivity.this,StageSelect.class);
                mp.stop();
                startActivity(home);

            }
        });
    }
    public void playerBtnClick(View view) {
        if(!mp.isPlaying()){
            //stopping
            mp.start();
        }else mp.pause();

    }
}
