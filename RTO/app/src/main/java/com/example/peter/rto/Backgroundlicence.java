package com.example.peter.rto;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Backgroundlicence extends AsyncTask<String,Void,String> {
    Context ctx;

    Backgroundlicence(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        String regLic = "";
        String method = params[0];
        if (method.equals("register")) ;
        {
            String name = params[1];
            String SWD_of = params[2];
            String permanent_address = params[3];
            String temporary_address = params[4];
            String duration_of_stay = params[5];
            String DOB = params[6];
            String migration = params[7];
            String educational_qualification = params[8];
            String identification_mark = params[9];
            String blood_group = params[10];
            String existing_driving_licence = params[11];
            String date_of_conviction = params[12];
            String disqualified = params[13];
            String driving_test = params[14];

            try {
                URL url = new URL(regLic);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("SWD_of", "UTF-8") + "=" + URLEncoder.encode(SWD_of, "UTF-8") + "&" +
                        URLEncoder.encode("permanent_address", "UTF-8") + "=" + URLEncoder.encode(permanent_address, "UTF-8") + "&" +
                        URLEncoder.encode("temporary_address", "UTF-8") + "=" + URLEncoder.encode(temporary_address, "UTF-8") + "&" +
                        URLEncoder.encode("duration_of_stay", "UTF-8") + "=" + URLEncoder.encode(duration_of_stay, "UTF-8") + "&" +
                        URLEncoder.encode("DOB", "UTF-8") + "=" + URLEncoder.encode(DOB, "UTF-8") + "&" +
                        URLEncoder.encode("migration", "UTF-8") + "=" + URLEncoder.encode(migration, "UTF-8") + "&" +
                        URLEncoder.encode("educational_qualification", "UTF-8") + "=" + URLEncoder.encode(educational_qualification, "UTF-8") + "&" +
                        URLEncoder.encode("identification_mark", "UTF-8") + "=" + URLEncoder.encode(identification_mark, "UTF-8") + "&" +
                        URLEncoder.encode("blood_group", "UTF-8") + "=" + URLEncoder.encode(blood_group, "UTF-8") + "&" +
                        URLEncoder.encode("existing_driving_licence", "UTF-8") + "=" + URLEncoder.encode(existing_driving_licence, "UTF-8") + "&" +
                        URLEncoder.encode("date_of_conviction", "UTF-8") + "=" + URLEncoder.encode(date_of_conviction, "UTF-8") + "&" +
                        URLEncoder.encode("disqualified", "UTF-8") + "=" + URLEncoder.encode(disqualified, "UTF-8") + "&" +
                        URLEncoder.encode("driving_test", "UTF-8") + "=" + URLEncoder.encode(driving_test, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return " FORM REGISTERED";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
