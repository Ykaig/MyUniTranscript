package com.example.myunitranscript;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myunitranscript.model.Exam;
import com.google.android.material.button.MaterialButton;

import com.example.myunitranscript.model.ExamsManager;

public class NewExamActivity extends AppCompatActivity {

    private EditText editTextExamName;
    private EditText editTextEcts;
    private EditText editTextGrade;

    private ExamsManager examsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_exam);

        editTextExamName = findViewById(R.id.editTextExamName);
        editTextEcts = findViewById(R.id.editTextEcts);
        editTextGrade = findViewById(R.id.editTextGrade);

        MaterialButton saveExamBtn = findViewById(R.id.saveExamBtn);

        // Recupera l'istanza di ExamsManager dall'intent
        Intent intent = getIntent();
        if (intent.hasExtra("examsManager")) {
            examsManager = (ExamsManager) intent.getSerializableExtra("examsManager");
        } else {
            examsManager = new ExamsManager(); // Fallback se l'istanza non è stata passata
        }

        saveExamBtn.setOnClickListener(v -> {
            addExam();
            goToExams();
        });
    }

    private void addExam() {
        String name = editTextExamName.getText().toString();
        int ects = Integer.parseInt(editTextEcts.getText().toString());
        int grade = Integer.parseInt(editTextGrade.getText().toString());

        examsManager.addElement(new Exam(name, ects, grade));
        Log.d("Debug", "Contenuto di examsManager in NewExamActivity: " + examsManager.getAllExams());
    }


    public void goToExams(){
        // Intent per passare alla pagina di aggiunta degli esami
        Intent examsIntent = new Intent(this, ExamsActivity.class);
        examsIntent.putExtra("examsManager", examsManager);
        startActivity(examsIntent);
    }
}