package com.example.horace.myapplication;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ViewFlipper;

public class ScaleTipsActivity extends AppCompatActivity {
    private TipsController tipvf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_tips);
        tipvf=new TipsController(this,(ViewFlipper) findViewById(R.id.tipvf));




    }
}


