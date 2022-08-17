package com.example.authenticationviasharedprefences;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailLA,etPasswordLA;
    Button btnLogin;

    TextView btnRegisterHere;
    TextView tvForgotPassword;

    // shared preference object
    SharedPreferences ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailLA = findViewById(R.id.idEtEmailLA);
        etPasswordLA = findViewById(R.id.idEtPasswordLA);


        btnLogin = findViewById(R.id.idBtnLogin);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

//        boolean autologin = ref.getBoolean("isLogin",true);
//        if (autologin){
//            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
//            startActivity(i);
//        }

        btnRegisterHere = findViewById(R.id.idBtnRegisterHere);

        btnRegisterHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(i);
            }
        });

        tvForgotPassword = findViewById(R.id.idTvForgotPassword);

        tvForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });


    }

    private void loginUser() {

        String emailLA = ref.getString("SPemail","");
        String passwordLA = ref.getString("SPpassword","");


        if (emailLA.equals(etEmailLA.getText().toString()) && passwordLA.equals(etPasswordLA.getText().toString())){
//            ref.edit().putBoolean("isLogin",true).apply();
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }

        else {
            Snackbar snackbar = Snackbar.
                    make(findViewById(android.R.id.content),
                            "Invalid User!",
                            Snackbar.LENGTH_LONG);
            snackbar.show();
           }




    }
}