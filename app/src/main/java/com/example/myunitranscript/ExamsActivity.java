package com.example.myunitranscript;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myunitranscript.model.Exam;
import com.example.myunitranscript.model.SessionManager;
import com.example.myunitranscript.model.User;
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

        // Retrieve current user from session
        User currentUser = SessionManager.getInstance().getCurrentUser();
        ExamsManager examsManager = currentUser.getExamsManager();

        /*
        if (currentUser != null && currentUser.getExamsManager() != null) {

            // Ora puoi accedere al gestore degli esami dell'utente corrente
            ExamsManager examsManagerUtente = currentUser.getExamsManager();

            } else {
                // L'utente non ha un gestore di esami valido
                // Gestisci l'errore o esegui un'azione appropriata
                Toast.makeText(this, "Errore nel recupero del gestore degli esami dell'utente", Toast.LENGTH_SHORT).show();
            }
        } else {
            // L'utente corrente è nullo, potrebbe non essere stato correttamente autenticato
            // Gestisci l'errore o esegui un'azione appropriata
            Toast.makeText(this, "Errore nel recupero dell'utente corrente", Toast.LENGTH_SHORT).show();
        }
        */

        /* USER LOGIN */
        /*
        SessionManager sessionManager = SessionManager.getInstance();
        User currentUser = sessionManager.getCurrentUser();

        examsManager = user.getExamsManager();

        List<Exam> userExams = examsManager.getExamsList();

         */

        /*
        // Se non è già stato inizializzato, verifica se ci sono extra nell'intent
        Intent intent = getIntent();
        if (intent.hasExtra("examsManager")) {
            examsManager = (ExamsManager) intent.getSerializableExtra("examsManager");
        } else {
            // Controlla se examsManager è già stato inizializzato
            // Se non ci sono extra, inizializza examsManager con una nuova istanza
            examsManager = new ExamsManager();
        }
         */

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


    private void refreshAllExams() {
        List examsList = examsManager.getExamsList();

        // Ottieni il layout lineare verticale dal layout XML
        LinearLayout linearLayout = findViewById(R.id.linear_layout_container);

        // Cancella il contenuto precedente
        linearLayout.removeAllViews();

        textViewExamsList.setText("");
        if (examsList.isEmpty())
            textViewExamsList.setText("No exam inserted, try adding one");
        else {
            // Aggiungi una TextView e una View per ogni esame
            for (Object exam : examsList) {
                addExamToLayout((Exam) exam, linearLayout);
            }
        }



        /* First method */
        /*
        // Ottieni la lista degli esami dal GestoreEsami
        String examsList = examsManager.getAllExams();

        // Aggiorna la TextView con la lista degli esami
        textViewExamsList.setText("");
        if (examsList.equals(""))
            textViewExamsList.setText("No exam present, try adding one");
        else
            textViewExamsList.setText(examsList);
         */

        /* Second method */
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



        Log.d("Debug", "Lista degli esami in ExamsActivity: " + examsList);
    }

    private void showDeleteConfirmationDialog(final Exam exam) {
        // Crea un dialog di conferma per la cancellazione
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete Exam");
        builder.setMessage("Are you sure you want to delete this exam?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Elimina l'esame e aggiorna la visualizzazione
                examsManager.removeElement(exam);
                refreshAllExams();
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void addExamToLayout(Exam exam, LinearLayout linearLayout) {
        TextView textView = new TextView(this);
        textView.setText(exam.toString());

        textView.setPadding(30, 15, 0, 15);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);

        // Aggiungi l'OnLongClickListener
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Visualizza un dialog di conferma per la cancellazione
                showDeleteConfirmationDialog(exam);
                return true;
            }
        });

        linearLayout.addView(textView);

        // Aggiungi la linea divisoria
        View dividerView = new View(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 2); // Altezza della linea divisoria
        // params.setMargins(0, 4, 0, 4); // Personalizza i margini se necessario
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
