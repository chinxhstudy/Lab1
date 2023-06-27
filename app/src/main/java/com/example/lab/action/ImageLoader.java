package com.example.lab.action;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoader extends AsyncTask<String, Integer, Bitmap> {

    public ImageLoader() {
    }

    public ImageListener imageListener;

    public void setImageListener(ImageListener imageListener) {
        this.imageListener = imageListener;
        imageListener.start();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            String link = strings[0];
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            return BitmapFactory.decodeStream(stream);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageListener.finish(bitmap);
    }
}
