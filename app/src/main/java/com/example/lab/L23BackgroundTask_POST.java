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

public class L23BackgroundTask_POST extends AsyncTask<Void, Void, Void> {


    private Context context;
    private String link, dai;
    private String result = "";
    private TextView tvKQ;
    private String kq = "";

    ProgressDialog pDialog;

    public L23BackgroundTask_POST(Context context, String link, String dai, TextView tvKQ)
    {
        this.context = context;
        this.dai = dai;
        this.tvKQ = tvKQ;
        this.link = link;
    }

    public L23BackgroundTask_POST(Lab2Ex4Activity context, String link, String dai, String toString, String toString1, TextView txtResult) {
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(link);
            String ts = "canh=" + URLEncoder.encode(dai, "utf-8");

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
