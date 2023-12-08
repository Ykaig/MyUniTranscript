package com.example.myunitranscript;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goToRegistrationPage(View view) {
        // Intent per passare alla pagina di registrazione
        Intent registrationIntent = new Intent(this, RegistrationActivity.class);
        startActivity(registrationIntent);
    }

    public void goToExamsPage(View view) {
        // Intent per passare alla pagina degli esami
        Intent examsIntent = new Intent(this, ExamsActivity.class);
        startActivity(examsIntent);
    }


}