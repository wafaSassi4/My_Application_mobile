package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.view.Resultat;

public class HistoryActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private TextView history;
    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        TextView history=(TextView)findViewById(R.id.history);
        Intent intent = getIntent();




    }

}