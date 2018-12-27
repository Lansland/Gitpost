package com.example.horace.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ViewFlipper;

public class StageSelect extends AppCompatActivity {
/*
这个是关卡选择的activity
 */
   private FlipperController fc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_select);
        fc=new FlipperController(this,(ViewFlipper)findViewById(R.id.vf));
    }

}
