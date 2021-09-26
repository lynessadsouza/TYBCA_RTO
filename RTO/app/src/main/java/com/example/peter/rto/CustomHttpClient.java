package com.example.peter.rto;

/**
 * Created by admin on 3/22/2018.
 */


        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.net.URI;
        import java.util.ArrayList;
       import org.apache.http.HttpResponse;
        import org.apache.http.NameValuePair;
        import org.apache.http.client.HttpClient;
        import org.apache.http.client.entity.UrlEncodedFormEntity;
        import org.apache.http.client.methods.HttpGet;
        import org.apache.http.client.methods.HttpPost;
        import org.apache.http.conn.ClientConnectionManager;
        import org.apache.http.conn.params.ConnManagerParams;
        import org.apache.http.impl.client.DefaultHttpClient;
        import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
        import org.apache.http.params.HttpConnectionParams;
        import org.apache.http.params.HttpParams;
        import org.json.JSONObject;

        import android.content.Context;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;

public class CustomHttpClient {




    /** The time it takes for our client to timeout */
    public static final int HTTP_TIMEOUT = 100 * 1000; // milliseconds
    /** Single instance of our HttpClient */
    private static HttpClient mHttpClient;

    public Context appContext;

    public CustomHttpClient(Context ctx){
        appContext = ctx;
    }

    /**
     * Get our single instance of our HttpClient object.
     *
     * @return an HttpClient object with connection parameters set
     */
    private static HttpClient getHttpClient() {
        if (mHttpClient == null) {
            mHttpClient = new DefaultHttpClient();
            final HttpParams params = mHttpClient.getParams();
            HttpConnectionParams.setConnectionTimeout(params, HTTP_TIMEOUT);
            HttpConnectionParams.setSoTimeout(params, HTTP_TIMEOUT);
            ConnManagerParams.setTimeout(params, HTTP_TIMEOUT);
            ClientConnectionManager mgr = mHttpClient.getConnectionManager();
            mHttpClient = new DefaultHttpClient((ClientConnectionManager) new ThreadSafeClientConnManager(params,
                    mgr.getSchemeRegistry()), params);
        }
        return mHttpClient;
    }

    /**
     * Performs an HTTP Post request to the specified url with the specified
     * parameters.
     *
     * @param url
     *            The web address to post the request to
     * @param postParameters
     *            The parameters to send via the request
     * @return The result of the request
     * @throws Exception
     */
    public static String executeHttpPost(String url, ArrayList postParameters)
            throws Exception {
        BufferedReader in = null;
        try {
            HttpClient client = getHttpClient();
            HttpPost request = new HttpPost(url);


            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(



                    postParameters);
            request.setEntity(formEntity);
            HttpResponse response = client.execute(request);
            in = new BufferedReader(new InputStreamReader(response.getEntity()
                    .getContent()));
            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            String result = sb.toString();
            return result;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String executeHttpGet(String url) throws Exception {
        BufferedReader in = null;
        try {
            HttpClient client = getHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(url));
            HttpResponse response = client.execute(request);


            in = new BufferedReader(new InputStreamReader(response.getEntity()
                    .getContent()));


            StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) {
                sb.append(line + NL);
            }
            in.close();
            String result = sb.toString();
            return result;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isConnected(){
        final ConnectivityManager conMgr =  (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            //notify user you are online
            return true;
        } else {
            //notify user you are not online
            return false;
        }
    }
}