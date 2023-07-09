package com.example.lab;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Lab2Ex1Activity extends AppCompatActivity implements View.OnClickListener {

    TextView tvkq;
    String link;
    EditText txtName, txtScore;
    Button btnLoad;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_ex1);

        tvkq = findViewById(R.id.l2e1_txt_result);
        link = "http://192.168.1.5/CHINXH-PH13080/student_GET.php";
        txtName = findViewById(R.id.l2e1_edt_name);
        txtScore = findViewById(R.id.l2e1_edt_score);
        btnLoad = findViewById(R.id.l2e1_btn_send);

        btnLoad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        L21AsyncTaskGet l21AsyncTaskGet = new L21AsyncTaskGet(this, link, txtName.getText().toString(), txtScore.getText().toString(), tvkq);
        l21AsyncTaskGet.execute();
    }
}
