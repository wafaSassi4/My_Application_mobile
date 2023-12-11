package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class Resultat extends AppCompatActivity {
    private TextView resultatTextView;
    private Button btn;

    String result=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        TextView resultatTextView=(TextView)findViewById(R.id.res);
        Button btn=(Button) findViewById(R.id.btn);

        // Retrieve the data from the Intent
        Intent intent = getIntent();
        if (intent != null) {
            result = intent.getStringExtra("result");
            resultatTextView.setText(result);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                if(result!=null){
                    setResult(RESULT_OK,intent);
                }else {
                    setResult(RESULT_CANCELED,intent);
                }
                finish();
            }
        });
    }

}