package com.example.tharindu.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetDataClass extends AsyncTask<Void, Void, Void> {       /*this class is used to perform jason operations*/
    String data;

    @Override
    protected Void doInBackground(Void... voids) {      /* Backgroud thread */
        try {
            URL url = new URL("http://date.jsontest.com/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {      /*UI thread*/
        super.onPostExecute(aVoid);
        FetchResultsActivity.tvShowJason.setText(data);     /*pass data to the textview in fetchresultactivity activity*/
    }
}
