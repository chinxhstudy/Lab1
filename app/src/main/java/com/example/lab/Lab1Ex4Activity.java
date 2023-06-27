package com.example.lab;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab.action.ImageListener;
import com.example.lab.action.ImageLoader;

public class Lab1Ex4Activity extends AppCompatActivity {
    private EditText sleep;
    private TextView message;
    private ProgressDialog progressDialog;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);

        sleep = findViewById(R.id.sleep);
        Button runAsynctask = findViewById(R.id.runAsyntask);
        message = findViewById(R.id.message);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        runAsynctask.setOnClickListener(v -> {
            time = sleep.getText().toString().trim();
            String link = "https://images.pexels.com/photos/1379636/pexels-photo-1379636.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
            ImageLoader loader = new ImageLoader();
            loader.setImageListener(new ImageListener<Bitmap>() {
                @Override
                public void start() {
                    progressDialog.show();
                    progressDialog.setMessage("Loading for: " + time + " second");
                    Runnable progressRunnable = () -> {
                        progressDialog.cancel();
                        message.setText("Successful");
                        sleep.setText("");
                    };

                    Handler pdCanceller = new Handler();
                    pdCanceller.postDelayed(progressRunnable, Integer.parseInt(time) * 1000);
                    message.setText("Sleeping");
                }

                @Override
                public void finish(Bitmap o) {

                }
            });
            loader.execute(link);
        });
    }

}