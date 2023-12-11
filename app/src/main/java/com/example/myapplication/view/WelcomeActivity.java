package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapplication.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        resultat();
    }
    public void resultat(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent intent=new Intent(WelcomeActivity.this, login_page.class);
                startActivity(intent);

            }
        },2000);

    }
}