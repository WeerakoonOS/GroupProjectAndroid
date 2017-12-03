package com.example.tharindu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class FetchResultsActivity extends AppCompatActivity {
    public static TextView tvShowJason;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fetchresults_activity);

        init();
    }

    private void init(){
        tvShowJason = (TextView) findViewById(R.id.tvShowJason);
    }
}
