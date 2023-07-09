package com.example.lab;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class L22AsyncTaskPost extends AsyncTask<Void, Void, Void> {

    private Context context;
    private String link, rong, dai;
    private String result = "";
    private TextView tvKQ;
    private String kq = "";

    public L22AsyncTaskPost(Context context, String link, String rong, String dai, TextView tvKQ)
    {
        this.context = context;
        this.rong = rong;
        this.dai = dai;
        this.tvKQ = tvKQ;
        this.link = link;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(link);
            String ts = "chieurong=" + URLEncoder.encode(rong, "utf-8") +
                    "&chieudai=" + URLEncoder.encode(dai, "utf-8");

            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");

            urlConnection.setFixedLengthStreamingMode(ts.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter p = new PrintWriter(urlConnection.getOutputStream());
            p.print(ts);
            p.close();

            String line = "";
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();

            while ((line = br.readLine()) != null)
            {
                sb.append(line);
            }
            result = sb.toString();
            urlConnection.disconnect();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void avoid) {
        super.onPostExecute(avoid);
        tvKQ.setText(result);
    }
}
