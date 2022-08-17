package com.example.authenticationviasharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText etForgotPasswordMobilNo, etForgotPasswordEmail;
    Button btnSubmitt;

    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etForgotPasswordMobilNo = findViewById(R.id.idEtForgotPasswordMobilNo);
        etForgotPasswordEmail = findViewById(R.id.idEtForgotPasswordEmail);
        btnSubmitt = findViewById(R.id.idBtnSubmitt);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);


        btnSubmitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgotPassword();

            }
        });
    }

    private void forgotPassword() {

        String mobileNumberFPA = ref.getString("SPmobileNO","");
        String emailFPA = ref.getString("SPemail","");


        if(mobileNumberFPA.equals(etForgotPasswordMobilNo.getText().toString().trim()) &&
                emailFPA.equals(etForgotPasswordEmail.getText().toString().trim())
        )
        {
            Intent i = new Intent(ForgotPasswordActivity.this,ResetPasswordActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Invalid Mobile Number or Email", Toast.LENGTH_SHORT).show();
        }

        }
}