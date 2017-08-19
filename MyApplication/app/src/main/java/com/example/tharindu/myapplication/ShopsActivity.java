package com.example.tharindu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ShopsActivity extends AppCompatActivity {
    private Button btnAvailabilities, btnRateShop, btnShopDetails, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shops_activity);

        init();
        clickAvailabilites();
        clickRateShop();
        clickShopDetails();
        clickBack();
    }

    private void init(){
        btnAvailabilities = (Button)findViewById(R.id.btnAvailabilities);
        btnRateShop = (Button)findViewById(R.id.btnRateShop);
        btnShopDetails = (Button)findViewById(R.id.btnShopDetails);
        btnBack = (Button)findViewById(R.id.btnBack);

    }

    private void clickAvailabilites(){

    }

    private void clickRateShop(){

    }

    private void clickShopDetails(){

    }

    private void clickBack(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShopsActivity.this, MainMenuActivity.class);
                startActivity(i);
            }
        });
    }
}
