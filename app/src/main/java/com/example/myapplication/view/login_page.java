package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class login_page extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private EditText login = null;
    private EditText psw = null;
    private Button compte = null;
    private Button btn2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        sharedPreferences = getSharedPreferences("signup",MODE_PRIVATE);

        init();
        compte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inscrire();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean  loginStr = false;
              boolean passeStr=false;
              String user=sharedPreferences.getString("login","");
              String pswd=sharedPreferences.getString("password","");

                if (!login.getText().toString().isEmpty()&&user.equals(login.getText().toString())){
                    loginStr=true;
                }else {
                    Toast.makeText(login_page.this,"verifier votre login",Toast.LENGTH_SHORT).show();
                }
                if (!psw.getText().toString().isEmpty()&&pswd.equals(psw.getText().toString())){
                    passeStr=true;
                }else {
                    Toast.makeText(login_page.this,"verifier votre password",Toast.LENGTH_LONG).show();
                }
                if (loginStr && passeStr){
                    connexion();
                }
            }
        });


    }
    public void init(){
        login=findViewById(R.id.login);
        psw=findViewById(R.id.psw);
        compte=findViewById(R.id.compte);
        btn2=findViewById(R.id.btn2);
    }
    public void inscrire(){
        Intent intent=new Intent(login_page.this, inscription.class);
        startActivity(intent);
    }
    public void connexion(){
        Intent intent=new Intent(login_page.this,MainActivity.class);
        startActivity(intent);
    }

}