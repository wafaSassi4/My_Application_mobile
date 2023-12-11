package com.example.myapplication.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.controoler.Controller;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences SharedPreferences;
    private final int REQUEST_CODE=1;

    private TextView tvage = null;
    private SeekBar sbage = null;
    private RadioGroup rgGrp;
    private RadioButton rboui = null, rbnon = null;
    private EditText etmesure = null;

    private Button bconsulter = null;
    private String resultat = null;
    private Controller controller=Controller.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        sbage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information", "onProgressChanged:" + progress);
                tvage.setText("votre age :" + sbage.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Start tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Merci", Toast.LENGTH_SHORT).show();
            }
        });

        bconsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age;
                double mesure;
                boolean verifage = false, verifvaleur = false;

                if (sbage.getProgress() != 0) {
                    verifage = true;
                } else {
                    Toast.makeText(MainActivity.this, "verifiez votre age", Toast.LENGTH_SHORT).show();
                }

                if (!etmesure.getText().toString().isEmpty()) {
                    verifvaleur = true;
                } else {
                    Toast.makeText(MainActivity.this, "verifier votre valeur mesurée", Toast.LENGTH_SHORT).show();
                }

                if (verifage && verifvaleur) {
                    age = sbage.getProgress();
                    mesure = Double.valueOf(etmesure.getText().toString());

                    controller.createPatient(mesure,age,rboui.isChecked());

                    resultat=controller.getResponse();

                    resultat();

                }
            }
        });

    }
    public void init() {
        bconsulter = findViewById(R.id.bconsulter);
        tvage = (TextView) findViewById(R.id.tvage);
        sbage = (SeekBar) findViewById(R.id.sbage);
        rboui = (RadioButton) findViewById(R.id.rboui);
        rbnon = (RadioButton) findViewById(R.id.rbnon);
        etmesure = (EditText) findViewById(R.id.etmesure);
    }

    public void resultat() {
        // Create an Intent to start the Const_Activity
        Intent intent = new Intent(MainActivity.this, Resultat.class);

        // Pass the 'res' value to Const_Activity
        intent.putExtra("result", resultat);

        // Start the Const_Activity
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
            if(resultCode==RESULT_CANCELED){
                Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"good",Toast.LENGTH_SHORT).show();
            }
    }
}
