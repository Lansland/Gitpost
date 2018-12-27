package com.example.horace.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class RegisterActivity extends AppCompatActivity {
    private ImageButton regisubmitbtn;
    private EditText username,pwd,confirmpwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        regisubmitbtn=findViewById(R.id.regisubmitBtn);
        username=findViewById(R.id.username);
        pwd=findViewById(R.id.password);
        confirmpwd=findViewById(R.id.confirmpwd);
        regisubmitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlogin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intentlogin);

            }
        });



    }
}

