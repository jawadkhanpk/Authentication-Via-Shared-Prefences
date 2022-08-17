package com.example.authenticationviasharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

public class UserProfileActivity extends AppCompatActivity {

    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);


        

    }
}