package com.example.authenticationviasharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.snackbar.Snackbar;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText etNewPassword, etConfirmNewPassword;

    Button btnChangePassword;

    SharedPreferences ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etNewPassword = findViewById(R.id.idEtNewPassword);
        etConfirmNewPassword = findViewById(R.id.idEtConfirmNewPassword);

        btnChangePassword = findViewById(R.id.idBtnChangePassword);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePassword();
            }
        });

    }

    private void changePassword() {

        String passwordRPA = etNewPassword.getText().toString().trim();
        String confirmPasswordRPA = etConfirmNewPassword.getText().toString().trim();

        if (passwordRPA.equals(confirmPasswordRPA)){
            ref.edit().putString("SPpassword",passwordRPA).apply();
            ref.edit().putString("SPconfirmPassword",confirmPasswordRPA).apply();

            Toast.makeText(this, "Password Changed Successfully!", Toast.LENGTH_LONG).show();
            
            Intent i = new Intent(ResetPasswordActivity.this, LoginActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Error! The New Password & Confirm New Password are not same!", Toast.LENGTH_SHORT).show();
        }



    }
}