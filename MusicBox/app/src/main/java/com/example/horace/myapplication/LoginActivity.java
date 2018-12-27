package com.example.horace.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private ImageButton submitbtn;
    private EditText username,pwd;
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        submitbtn=findViewById(R.id.submitBtn);
        username=findViewById(R.id.username);
        pwd=findViewById(R.id.password);
        register=findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentregi = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentregi);

            }
        });

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentmain = new Intent(LoginActivity.this, StageSelect.class);
                startActivity(intentmain);
                Log.d("haha", "onClick: 123");


            }
        });
    }
}

