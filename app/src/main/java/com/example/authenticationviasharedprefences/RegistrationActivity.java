package com.example.authenticationviasharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    EditText etNameRA, etMobileNoRA, etEmailRA,etPasswordRA, etConfirmPasswordRA;
    Button btnRegister;

    // shared preference object
    SharedPreferences ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etNameRA = findViewById(R.id.idEtNameRA);
        etMobileNoRA = findViewById(R.id.idEtMobileNoRA);
        etEmailRA = findViewById(R.id.idEtEmailRA);
        etPasswordRA = findViewById(R.id.idEtPasswordRA);
        etConfirmPasswordRA = findViewById(R.id.idEtConfirmPasswordRA);

        btnRegister = findViewById(R.id.idBtnRegister);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

    }

    private void registerUser() {

        String nameRA = etNameRA.getText().toString().trim();
        String mobileNumberRA = etMobileNoRA.getText().toString().trim();
        String emailRA = etEmailRA.getText().toString().trim();
        String passwordRA = etPasswordRA.getText().toString().trim();
        String confirmPasswordRA = etConfirmPasswordRA.getText().toString().trim();


        ref.edit().putString("SPname",nameRA).apply();
        ref.edit().putString("SPmobileNO",mobileNumberRA).apply();
        ref.edit().putString("SPemail",emailRA).apply();
        ref.edit().putString("SPpassword",passwordRA).apply();
        ref.edit().putString("SPconfirmPassword",confirmPasswordRA).apply();

        ref.edit().putBoolean("isLogin",true).apply();


        Intent i = new Intent(RegistrationActivity.this, HomeActivity.class);
        startActivity(i);

    }
}