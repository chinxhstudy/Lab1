package com.example.lab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Lab2Ex2Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView textview1;
    private EditText l2e2EdtWidth;
    private EditText l2e2EdtLength;
    private Button l2e2BtnSend;
    private TextView l2e2TxtResult;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_ex2);



        textview1 = (TextView) findViewById(R.id.textview1);
        l2e2EdtWidth = (EditText) findViewById(R.id.l2e2_edt_width);
        l2e2EdtLength = (EditText) findViewById(R.id.l2e2_edt_length);
        l2e2BtnSend = (Button) findViewById(R.id.l2e2_btn_send);
        l2e2TxtResult = (TextView) findViewById(R.id.l2e2_txt_result);


        l2e2BtnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String link = "http://192.168.1.5/CHINXH-PH13080/rectangle_POST.php";
        L22AsyncTaskPost l22AsyncTaskPost = new L22AsyncTaskPost(this, link, l2e2EdtWidth.getText().toString(), l2e2EdtLength.getText().toString(), l2e2TxtResult);
        l22AsyncTaskPost.execute();
    }
}
