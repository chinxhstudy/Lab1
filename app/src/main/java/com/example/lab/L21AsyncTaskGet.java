package com.example.lab;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class L21AsyncTaskGet extends AsyncTask<String, Void, String> {

    private Context context;
    private String link, name, score;
    private TextView tvKQ;
    private String kq = "";

    public L21AsyncTaskGet(Context context, String link, String name, String score, TextView tvKQ)
    {
        this.context = context;
        this.link = link;
        this.name = name;
        this.score = score;
        this.tvKQ = tvKQ;
    }

    @Override
    protected String doInBackground(String... strings) {
        link+= "?name=" + name + "&score=" + score;
        try {
            URL url = new URL(link);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = br.readLine())!= null){
                sb.append(line);
            }
            kq = sb.toString();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvKQ.setText(kq); // kết quả nhả về rỗng
    }
}
