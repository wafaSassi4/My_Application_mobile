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

public class inscription extends AppCompatActivity {
    SharedPreferences sharedPreferences;

    private TextView account=null;
    private EditText user=null;
    private EditText mail=null;
    private EditText password=null;
    private EditText verifpsw=null;
    private Button inscrire=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        sharedPreferences = getSharedPreferences("signup",MODE_PRIVATE);

        init();
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account();
            }
        });
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean username=false;
                boolean psw=false;
                boolean adrmail=false;
                boolean verifpswd = false;
                String pwd=password.getText().toString();
                String rpwd=verifpsw.getText().toString();


                if (!user.getText().toString().isEmpty()) {
                    username = true;
                } else {
                    Toast.makeText(inscription.this, "insert your username", Toast.LENGTH_SHORT).show();
                }

                if (!mail.getText().toString().isEmpty()) {
                    adrmail = true;
                } else {
                    Toast.makeText(inscription.this, "insert your email address", Toast.LENGTH_LONG).show();
                }
                if (!pwd.isEmpty()){
                    psw=true;
                }else {
                    Toast.makeText(inscription.this, "you need to enter a password", Toast.LENGTH_LONG).show();
                }
                if (!rpwd.isEmpty() && pwd.equals(rpwd)){
                    verifpswd=true;
                }else {
                    Toast.makeText(inscription.this, "you must enter the same password", Toast.LENGTH_LONG).show();
                }
                if(username && adrmail &&psw &&verifpswd){
                    saveData(user.getText().toString(),pwd);
                    inscrire();
                    Toast.makeText(inscription.this, "created succesffuly", Toast.LENGTH_SHORT).show();
                }

            }

        });


    }
    public void init(){
        account=findViewById(R.id.account);
        user=findViewById(R.id.user);
        password=findViewById(R.id.password);
        mail=findViewById(R.id.mail);
        verifpsw=findViewById(R.id.verifpsw);
        inscrire=findViewById(R.id.inscrire);
    }
    public void account(){
        Intent intent=new Intent(inscription.this, login_page.class);
        startActivity(intent);
    }
    public void inscrire(){
        Intent intent=new Intent(inscription.this, MainActivity.class);
        startActivity(intent);
    }
    private void saveData(String login,String pwd){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("login",login);
        editor.putString("password",pwd);
        editor.apply();
    }
}