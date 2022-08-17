package com.example.authenticationviasharedprefences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfileActivity extends AppCompatActivity {

    TextView nameUserProfileActivity, emailUserProfileActivity;

    Button btnDeleteAccount;

    SharedPreferences ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ref = getSharedPreferences("myapp",MODE_PRIVATE);

        nameUserProfileActivity  =findViewById(R.id.idNameUserProfileActivity);
        emailUserProfileActivity = findViewById(R.id.idEmailUserProfileActivity);

        btnDeleteAccount = findViewById(R.id.idBtnDeleteAccount);

        nameUserProfileActivity.setText("Account Name: "+ref.getString("SPname",""));
        emailUserProfileActivity.setText("Account Email: "+ref.getString("SPemail",""));


        btnDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAccount();
            }
        });
    }

    private void deleteAccount() {


        ref.edit().putString("SPname","").apply();
        ref.edit().putString("SPemail","").apply();


        Toast.makeText(this, "Account Deleted Successfully", Toast.LENGTH_LONG).show();

        Intent i = new Intent(UserProfileActivity.this, LoginActivity.class);
        startActivity(i);



    }
}