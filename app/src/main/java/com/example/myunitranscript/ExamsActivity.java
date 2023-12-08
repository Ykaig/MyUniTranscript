package com.example.myunitranscript;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ExamsActivity extends AppCompatActivity {

    BottomNavigationView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        bnv = findViewById(R.id.navbar);
        bnv.setSelectedItemId(R.id.exams);


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.exams:
                        return true;

                    case R.id.calculator:
                        // Intent per passare alla pagina di calcolo delle medie
                        Intent meanIntent = new Intent(getApplicationContext(), MeanActivity.class);
                        startActivity(meanIntent);
                        overridePendingTransition(0, 0);
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
