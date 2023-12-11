package com.example.myunitranscript;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myunitranscript.model.Exam;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;

import com.example.myunitranscript.model.ExamsManager;

import java.util.ArrayList;
import java.util.List;


public class ExamsActivity extends AppCompatActivity {

    private TextView textViewExamsList;

    private ExamsManager examsManager;

    BottomNavigationView bnv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exams);

        bnv = findViewById(R.id.navbar);
        bnv.setSelectedItemId(R.id.exams);

        textViewExamsList = findViewById(R.id.textViewExamsList);

        MaterialButton addExamBtn = findViewById(R.id.addExamBtn);

        // examsManager = new ExamsManager();
        Intent intent = getIntent();
        if (intent.hasExtra("examsManager")) {
            examsManager = (ExamsManager) intent.getSerializableExtra("examsManager");
        } else {
            examsManager = new ExamsManager();
        }

        // Exam test = new Exam("esame_prova", 5, 25);
        // Exam test2 = new Exam("esame_prova 2", 10, 30);
        // examsManager.addElement(test);
        // examsManager.addElement(test2);

        refreshAllExams();

        setNavigationMenu(bnv);

        addExamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNewExamPage();
            }
        });
    }

    private void setNavigationMenu(BottomNavigationView bnv){
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

    @Override
    protected void onRestart() {
        super.onRestart();
        refreshAllExams();
    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        refreshAllExams();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshAllExams();
    }
    */

    private void refreshAllExams() {
        // Ottieni la lista degli esami dal GestoreEsami
        String examsList = examsManager.getAllExams();

        /*
        List examsList = examsManager.getExamsList();

        // Ottieni il layout lineare verticale dal layout XML
        LinearLayout linearLayout = findViewById(R.id.linear_layout_container);

        // Cancella il contenuto precedente
        linearLayout.removeAllViews();

        // Aggiungi una TextView e una View per ogni esame
        for (Exam exam : examsList) {
            addExamToLayout(exam, linearLayout);
        }
        */

        // Aggiorna la TextView con la lista degli esami
        textViewExamsList.setText("");
        if (examsList.equals(""))
            textViewExamsList.setText("No exam present, try adding one");
        else
            textViewExamsList.setText(examsList);

        Log.d("Debug", "Lista degli esami in ExamsActivity: " + examsList);
    }

    private void addExamToLayout(Exam exam, LinearLayout linearLayout) {
        // Aggiungi la TextView per l'esame
        TextView textView = new TextView(this);
        textView.setText(exam.toString()); // Personalizza come vuoi mostrare l'esame
        linearLayout.addView(textView);

        // Aggiungi la linea divisoria
        View dividerView = new View(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 1); // Altezza della linea divisoria
        params.setMargins(0, 4, 0, 4); // Personalizza i margini se necessario
        dividerView.setLayoutParams(params);
        dividerView.setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
        linearLayout.addView(dividerView);
    }


    public void goToNewExamPage(){
        // Intent per passare alla pagina di aggiunta degli esami
        Intent addExamsIntent = new Intent(this, NewExamActivity.class);
        addExamsIntent.putExtra("examsManager", examsManager);
        startActivityForResult(addExamsIntent, 1);
    }

    // TODO: solve backButton behaviour

}
