package com.example.lab;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab.action.ImageListener;
import com.example.lab.action.ImageLoader;

public class Lab1Ex3Activity extends AppCompatActivity {
    private ImageView image;
    private TextView message;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);

        image = findViewById(R.id.image);
        message = findViewById(R.id.message);
        Button loadImage = findViewById(R.id.loadImage);

        progressDialog = new ProgressDialog(this);

        loadImage.setOnClickListener(v -> {
            String link = "https://img.freepik.com/premium-vector/businesswoman-character-avatar-with-cv-icon_24877-19867.jpg?w=740";
            ImageLoader loader = new ImageLoader();
            loader.setImageListener(new ImageListener<Bitmap>() {
                @Override
                public void start() {
                    message.setText("Loading ...");
                }

                @Override
                public void finish(Bitmap o) {
                    progressDialog.dismiss();
                    image.setImageBitmap(o);
                    message.setText("Load successful");
                }
            });
            loader.execute(link);
        });
    }

}