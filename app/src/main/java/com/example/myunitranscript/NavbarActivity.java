package com.example.myunitranscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NavbarActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btnExams;
    private ImageButton btnCalculator;
    private ImageButton btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navbar);

        btnExams = findViewById(R.id.btn1);
        btnCalculator = findViewById(R.id.btn2);
        btnProfile = findViewById(R.id.btn3);

        // Imposta un listener per ogni pulsante
        btnExams.setOnClickListener(this);
        btnCalculator.setOnClickListener(this);
        btnProfile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // Gestisci il click su ciascun pulsante
        switch (view.getId()) {
            case R.id.btn1:
                goToExamsPage(view);
                break;
            case R.id.btn2:
                goToMeanPage(view);
                break;
            case R.id.btn3:
                goToProfilePage(view);
                break;
        }
    }

    public void goToExamsPage(View view) {
        // Intent per passare alla pagina degli esami
        Intent examsIntent = new Intent(this, ExamsActivity.class);
        startActivity(examsIntent);
    }

    public void goToMeanPage(View view) {
        // Intent per passare alla pagina di calcolo delle medie
        Intent meanIntent = new Intent(this, MeanActivity.class);
        startActivity(meanIntent);
    }

    public void goToProfilePage(View view) {
        // Intent per passare alla pagina di calcolo delle medie
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        startActivity(profileIntent);
    }

}
