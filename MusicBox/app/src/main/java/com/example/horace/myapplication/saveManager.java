package com.example.horace.myapplication;

import android.app.Activity;

public class saveManager {
     private  static steptwo runActivity;
     private  static SelectinstrumentActivity selectinstrumentActivity;
     public saveManager(steptwo activity){
         runActivity=activity;
     }
    public saveManager(SelectinstrumentActivity activity){
        selectinstrumentActivity=activity;
    }
     public saveManager(){

     };
     public void gotoStep(int Index,Activity run){
         runActivity.Test();
         runActivity.gotoStep(Index,run);
     }
    public void gotoStep(int Index,SelectinstrumentActivity run){
        runActivity.Test();
        runActivity.gotoStep(Index,run);
    }
     public  void Test(){

     }
     public  void killActivity(int ID){
         android.os.Process.killProcess(ID);
     }
}
