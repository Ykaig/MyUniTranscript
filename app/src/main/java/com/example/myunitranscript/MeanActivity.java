package com.example.myunitranscript;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MeanActivity extends AppCompatActivity {

    BottomNavigationView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean);

        bnv = findViewById(R.id.navbar);
        bnv.setSelectedItemId(R.id.calculator);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.exams:
                        // Intent per passare alla pagina degli esami
                        Intent examsIntent = new Intent(getApplicationContext(), ExamsActivity.class);
                        startActivity(examsIntent);
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.calculator:
                        return true;

                    case R.id.profile:
                        // Intent per passare alla pagina di calcolo delle medie
                        Intent profileIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(profileIntent);
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;

            }
        });
    }

    // TODO: solve backButton behaviour
}
