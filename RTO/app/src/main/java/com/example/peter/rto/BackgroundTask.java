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
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String, Void, String> {

    Context ctx;

    BackgroundTask(Context ctx) {
        this.ctx = ctx;
    }


    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://scape360.website/peter/return.php?name=+'&name'+username=+'&username'+DOB=+'&DOB'+email=+'&email'+password=+'&password'+confirmpassword=+'&confirmpassword'+voterid=+'&voterid'+phonenumber=+'&phonenumber'";
        String method = params[0];
        if (method.equals("register")) ;
        {
            String name = params[1];
            String username = params[2];
            String DOB = params[3];
            String email = params[4];
            String password = params[5];
            String confirmpassword = params[6];
            String voterid = params[7];
            String phonenumber = params[8];

            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" +URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("DOB", "UTF-8") + "=" + URLEncoder.encode(DOB, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&" +
                        URLEncoder.encode("confirmpassword", "UTF-8") + "=" + URLEncoder.encode(confirmpassword, "UTF-8") + "&" +
                        URLEncoder.encode("voterid", "UTF-8") + "=" + URLEncoder.encode(voterid, "UTF-8") + "&" +
                        URLEncoder.encode("phonenumber", "UTF-8") + "=" + URLEncoder.encode(phonenumber, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return " REGISTERED SUCCESSFULLY...Please LogIn";

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






