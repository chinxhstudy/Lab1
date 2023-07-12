
package com.example.lab.lesson5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab.Lab1Ex1Activity;
import com.example.lab.R;
import com.example.lab.SplashscreenActivity;

public class Lesson5Activity extends AppCompatActivity {

    private Button btnEx1;
    private Button btnEx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        btnEx1 = (Button) findViewById(R.id.btn_ex1);
        btnEx2 = (Button) findViewById(R.id.btn_ex2);

        btnEx1.setOnClickListener(view -> {
            Intent intent = new Intent(Lesson5Activity.this, PhotoUsing1Activity.class);
            startActivity(intent);
        });

        btnEx2.setOnClickListener(view -> {
            Intent intent = new Intent(Lesson5Activity.this, PhotoUsing2Activity.class);
            startActivity(intent);
        });

    }
}