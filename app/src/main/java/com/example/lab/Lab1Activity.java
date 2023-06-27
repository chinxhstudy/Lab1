
package com.example.lab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Lab1Activity extends AppCompatActivity {

    Button switchToEx1Activity;
    Button switchToEx2Activity;
    Button switchToEx3Activity;
    Button switchToEx4Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);

        switchToEx1Activity = findViewById(R.id.lab1_ex1_btn);
        switchToEx2Activity = findViewById(R.id.lab1_ex2_btn);
        switchToEx3Activity = findViewById(R.id.lab1_ex3_btn);
        switchToEx4Activity = findViewById(R.id.lab1_ex4_btn);

        switchToEx1Activity.setOnClickListener(view -> {
                    Intent intent = new Intent(Lab1Activity.this, Lab1Ex1Activity.class);
                    startActivity(intent);
        });

        switchToEx2Activity.setOnClickListener(view -> {
            Intent intent = new Intent(Lab1Activity.this, SplashscreenActivity.class);
            startActivity(intent);
        });

        switchToEx3Activity.setOnClickListener(view -> {
            Intent intent = new Intent(Lab1Activity.this, Lab1Ex3Activity.class);
            startActivity(intent);
        });

        switchToEx4Activity.setOnClickListener(view -> {
            Intent intent = new Intent(Lab1Activity.this, Lab1Ex4Activity.class);
            startActivity(intent);
        });
    }
}