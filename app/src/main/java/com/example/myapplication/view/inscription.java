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
import com.example.myapplication.controoler.LoginController;

public class inscription extends AppCompatActivity {

    private TextView account=null;
    private EditText user=null;
    private EditText mail=null;
    private EditText password=null;
    private EditText verifpsw=null;
    private Button inscrire=null;
    LoginController loginController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

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

                if (!mail.getText().toString().isEmpty() && mail.getText().toString().contains("@") && mail.getText().toString().contains(".") && !mail.getText().toString().contains(" ")) {
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
                    loginController.CreateUser(user.getText().toString(),password.getText().toString(),inscription.this);
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
        loginController=LoginController.getInstance(this);
    }
    public void account(){
        Intent intent=new Intent(inscription.this, login_page.class);
        startActivity(intent);
    }
    public void inscrire(){
        Intent intent=new Intent(inscription.this, MainActivity.class);
        startActivity(intent);
    }
}