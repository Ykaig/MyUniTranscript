package com.example.myunitranscript;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity{

    BottomNavigationView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        bnv = findViewById(R.id.navbar);
        bnv.setSelectedItemId(R.id.profile);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.exams:
                        // Intent per passare alla pagina degli esami
                        Intent examsIntent = new Intent(getApplicationContext(), ExamsActivity.class);
                        startActivity(examsIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.calculator:
                        // Intent per passare alla pagina di calcolo delle medie
                        Intent meanIntent = new Intent(getApplicationContext(), MeanActivity.class);
                        startActivity(meanIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.profile:
                        return true;
                }

                return false;

            }
        });
    }

    // TODO: solve backButton behaviour

}
