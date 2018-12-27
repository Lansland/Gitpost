package com.example.horace.myapplication;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
public class VideoController {
    private ImageButton play, pause, stop;
    private boolean noPlay = true;
    private Activity runA=null;
    private MediaPlayer mediaPlayer=null;
    private SurfaceHolder sh;
    public VideoController(Activity runActivity) {
        runA = runActivity;
    }
    public  void Create(SurfaceView sf){
        this.surfaceView=sf;
        Play();
    }
    public  void Play(){
        if(noPlay){
            if(mediaPlayer!=null)
                mediaPlayer.stop();
            mediaPlayer=MediaPlayer.create(runA,R.raw.lesson1);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Toast.makeText(runA, "教程播放完毕", Toast.LENGTH_SHORT).show();
                    noPlay=true;
                }
            });
            Uri mUri = Uri.parse("android.resource://" + runA.getPackageName() + "/"+ R.raw.lesson1);
            sh=surfaceView.getHolder();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDisplay(sh);
            mediaPlayer.start();
            noPlay=false;
        }
    }
    public void Stop(){
        if(noPlay==false){
            mediaPlayer.stop();
        }
    }
    private Boolean isPlay = false;
    private LinearLayout L1, L2;
    private SurfaceView surfaceView;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Stop();
    }
}

