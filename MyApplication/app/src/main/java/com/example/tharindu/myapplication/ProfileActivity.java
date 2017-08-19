package com.example.tharindu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
    private Button btnReveiews, btnEdit, btnChangePassword, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        init();
        clickReviews();
        clickEdit();
        clickChangePassword();
        clickBack();
    }

    private void init(){
        btnReveiews = (Button)findViewById(R.id.btnReviews);
        btnEdit = (Button)findViewById(R.id.btnEdit);
        btnChangePassword = (Button)findViewById(R.id.btnChangePassword);
        btnBack = (Button)findViewById(R.id.btnBack);

    }

    private void clickReviews(){

    }

    private void clickEdit(){

    }

    private void clickChangePassword(){

    }

    private void clickBack(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ProfileActivity.this, MainMenuActivity.class);
                startActivity(i);
            }
        });
    }
}
