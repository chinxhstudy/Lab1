package com.example.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Lab2Ex3Activity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLength;
    private Button btnSend;
    private TextView txtResult;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_ex3);

        edtLength = (EditText) findViewById(R.id.edt_length);
        btnSend = (Button) findViewById(R.id.btn_send);
        txtResult = (TextView) findViewById(R.id.txt_result);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String link = "http://192.168.1.5/CHINXH-PH13080/rectangle_POST.php";
        L23BackgroundTask_POST l23BackgroundTask_post = new L23BackgroundTask_POST(this, link, edtLength.getText().toString(), txtResult);
        l23BackgroundTask_post.execute();
    }
}
