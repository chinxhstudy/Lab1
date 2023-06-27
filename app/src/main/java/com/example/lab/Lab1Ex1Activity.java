
package com.example.lab;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

public class Lab1Ex1Activity extends Activity implements View.OnClickListener {

    private ImageView image;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);

        image = findViewById(R.id.image);
        message = findViewById(R.id.message);
        Button loadImage = findViewById(R.id.loadImage);

        loadImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final Thread thread = new Thread(() -> {
            final Bitmap bitmap = loadImageFromNetWork();
            image.post(() -> {
                image.setImageBitmap(bitmap);
                message.setText("Image loaded!");
            });
        });
        thread.start();
    }
    private Bitmap loadImageFromNetWork(){
        URL url;
        Bitmap bitmap = null;
        try{
            url = new URL("https://img.freepik.com/premium-vector/businesswoman-character-avatar-with-cv-icon_24877-19867.jpg?w=740");
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}