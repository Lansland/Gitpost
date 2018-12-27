package com.example.horace.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ScaleActivity extends AppCompatActivity {
  /*
   音节的APP
     */

    private ImageButton scaleTips,menuBtn,testBtn;
    private ImageButton[] imageButtons=new ImageButton[8];
    private ImageView[] imageViews=new ImageView[8];
    private  ScalePerformer scalePerformer;
    private  Musician musician;
    private  int Index=0;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        scaleTips=(ImageButton)findViewById(R.id.scaletip);
        menuBtn=(ImageButton)findViewById(R.id.menuBtn);
        testBtn=(ImageButton)findViewById(R.id.test);
        imageButtons[0]=(ImageButton)findViewById(R.id.imageButton0);
        imageButtons[1]=(ImageButton)findViewById(R.id.imageButton1);
        imageButtons[2]=(ImageButton)findViewById(R.id.imageButton2);
        imageButtons[3]=(ImageButton)findViewById(R.id.imageButton3);
        imageButtons[4]=(ImageButton)findViewById(R.id.imageButton4);
        imageButtons[5]=(ImageButton)findViewById(R.id.imageButton5);
        imageButtons[6]=(ImageButton)findViewById(R.id.imageButton6);
        imageButtons[7]=(ImageButton)findViewById(R.id.imageButton7);


        imageViews[0]=findViewById(R.id.imageView0);
        imageViews[1]=findViewById(R.id.imageView1);
        imageViews[2]=findViewById(R.id.imageView2);
        imageViews[3]=findViewById(R.id.imageView3);
        imageViews[4]=findViewById(R.id.imageView4);
        imageViews[5]=findViewById(R.id.imageView5);
        imageViews[6]=findViewById(R.id.imageView6);
        imageViews[7]=findViewById(R.id.imageView7);
        final Intent intent=new Intent(this,StageSelect.class);
        findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                musician.Stop();
                startActivity(intent);
            }
        });

        scalePerformer=new ScalePerformer(this,imageButtons,imageViews);
        musician=new Musician(scalePerformer);


        final String[] items4 = new String[]{"小星星", "欢乐颂", "铃儿响叮当"};//创建item
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog alertDialog4 = new AlertDialog.Builder(ScaleActivity.this)
                        .setTitle("选择你想学的歌曲")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(items4, 0, new DialogInterface.OnClickListener() {//添加单选框
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Index = i;
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ScaleActivity.this, "你选择的" + "歌曲是：" + items4[Index], Toast.LENGTH_SHORT).show();
                            }
                        })

                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(ScaleActivity.this, "取消", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .create();
                alertDialog4.show();


            }
        });

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ScaleActivity.this, "现在测试的" + "歌曲是：" + items4[Index], Toast.LENGTH_SHORT).show();

            }
        });


        findViewById(R.id.sp1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musician.PlaySongsIndex(Index);
            }
        });

        scaleTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tips=new Intent(ScaleActivity.this,ScaleTipsActivity.class);
                startActivity(tips);
            }
        });



    }

    @Override
    public void finish() {
        super.finish();
        musician.Stop();
    }
}

