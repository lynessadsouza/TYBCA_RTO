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

public class Backgroundvehicle extends AsyncTask< String,Void,String> {
    Context ctx;
    Backgroundvehicle (Context ctx)
    {
        this.ctx=ctx;

    }




    @Override
    protected String doInBackground(String... params) {
        //String reg_urlveh ="http://scape360.website/peter/vehinsert.php?classofvehicle=+'&classofvehicle'+typeofbody=+'&typeofbody'+makersname=+'&makersname'+purpose=+'&purpose' + axeltype=+'&axeltype' +noofcylinder=+'&noofcylinder'+cc=+'&cc'+chassisno=+'&chassisno'+engineno=+'&engineno'+unladenweigh=+'&unladenweigh'+fuel=+'&fuel'+color=+'&color'ownersname=+'&ownersname'";
        String reg_urlveh ="http://scape360.website/peter/vehinsert.php";
        String method = params[0];


        if (method.equals("vehregister"))
        {
            String classofvehicle=params[1];
            String typeofbody = params[2];
            String makersname = params[3];
            String purpose=params[4];
            String axeltype = params[5];
            String noofcylinder = params[6];
            String cc = params[7];
            String chassisno = params[8];
            String engineno = params[9];
            String unladenweigh = params[10];
            String fuel = params[11];
            String color = params[12];
            String ownersname = params[13];

            try{
                URL url=  new URL(reg_urlveh);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("classofvehicle", "UTF-8") + "=" + URLEncoder.encode(classofvehicle, "UTF-8") + "&" +
                        URLEncoder.encode("typeofbody", "UTF-8") + "=" + URLEncoder.encode(typeofbody, "UTF-8") + "&" +
                        URLEncoder.encode("makersname", "UTF-8") + "=" + URLEncoder.encode(makersname, "UTF-8") + "&" +
                        URLEncoder.encode("purpose", "UTF-8") + "=" + URLEncoder.encode(purpose, "UTF-8") + "&" +
                        URLEncoder.encode("axeltype", "UTF-8") + "=" + URLEncoder.encode(axeltype, "UTF-8") + "&" +
                        URLEncoder.encode("noofcylinder", "UTF-8") + "=" + URLEncoder.encode(noofcylinder, "UTF-8") + "&" +
                        URLEncoder.encode("cc", "UTF-8") + "=" + URLEncoder.encode(cc, "UTF-8") + "&" +
                        URLEncoder.encode("chassisno", "UTF-8") + "=" + URLEncoder.encode(chassisno, "UTF-8") + "&" +
                        URLEncoder.encode("engineno", "UTF-8") + "=" + URLEncoder.encode(engineno, "UTF-8")+ "&" +
                        URLEncoder.encode("unladenweigh", "UTF-8") + "=" + URLEncoder.encode(unladenweigh, "UTF-8") + "&" +
                        URLEncoder.encode("fuel", "UTF-8") + "=" + URLEncoder.encode(fuel, "UTF-8") + "&" +
                        URLEncoder.encode("color", "UTF-8") + "=" + URLEncoder.encode(color, "UTF-8") + "&" +
                        URLEncoder.encode("ownersname", "UTF-8") + "=" + URLEncoder.encode(ownersname, "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return " REGISTERED SUCCESSFULLY";


            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
        return "not successfull";

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
