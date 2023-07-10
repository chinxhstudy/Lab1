package com.example.lab;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class L24BackgroundTask_POST extends AsyncTask<Void, Void, Void> {


    private Context context;
    private String link, a, b, c;
    private String result = "";
    private TextView tvKQ;
    private String kq = "";

    ProgressDialog pDialog;

    public L24BackgroundTask_POST(Context context, String link, String a, String b, String c, TextView tvKQ)
    {
        this.context = context;
        this.a = a;
        this.b = b;
        this.c = c;
        this.tvKQ = tvKQ;
        this.link = link;
    }

    public L24BackgroundTask_POST(Lab2Ex4Activity context, String link, String a, String b, String c, String toString, String toString1, TextView txtResult) {
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(link);
            String ts = "a=" + URLEncoder.encode(a, "utf-8") +
                    "&b=" + URLEncoder.encode(b, "utf-8") +
                    "&c=" + URLEncoder.encode(c, "utf-8");

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
    protected void onPreExecute( ) {
        super.onPreExecute();
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Calculating...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
        tvKQ.setText(result);
    }

    @Override
    protected void onPostExecute(Void avoid) {
        super.onPostExecute(avoid);
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
        tvKQ.setText(result);
    }

}
