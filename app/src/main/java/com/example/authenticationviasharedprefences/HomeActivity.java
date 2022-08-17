package com.example.authenticationviasharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView name;
    SharedPreferences ref;

    Button btnLogout;

    ImageView ivUserProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        name = findViewById(R.id.tvNameHA);
        ref = getSharedPreferences("myapp",MODE_PRIVATE);
        name.setText("Welcome "+ref.getString("SPname",""));


        btnLogout = findViewById(R.id.idBtnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutUser();
            }
        });

        ivUserProfile = findViewById(R.id.idIvUserProfile);
        ivUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, UserProfileActivity.class);
                startActivity(i);
            }
        });

    }


    private void logoutUser() {
        ref.edit().putBoolean("isLogin",false);
    }
}