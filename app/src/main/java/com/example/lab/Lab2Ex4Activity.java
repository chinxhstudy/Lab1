package com.example.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Lab2Ex4Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtA;
    private EditText edtB;
    private EditText edtC;
    private Button btnSend;
    private TextView txtResult;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_ex4);

        edtA = (EditText) findViewById(R.id.edt_a);
        edtB = (EditText) findViewById(R.id.edt_b);
        edtC = (EditText) findViewById(R.id.edt_c);
        btnSend = (Button) findViewById(R.id.btn_send);
        txtResult = (TextView) findViewById(R.id.txt_result);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String link = "http://172.16.0.122/CHINXH-PH13080/nghiem_POST.php";
        L24BackgroundTask_POST l24BackgroundTask_post = new L24BackgroundTask_POST(this, link, edtA.getText().toString(), edtB.getText().toString(), edtC.getText().toString(), txtResult);
        l24BackgroundTask_post.execute();
    }
}
