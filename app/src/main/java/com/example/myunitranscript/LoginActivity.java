package com.example.myunitranscript;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myunitranscript.model.SessionManager;
import com.example.myunitranscript.model.User;
import com.example.myunitranscript.model.UsersManager;


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

    public void loginUser(View view) {
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        UsersManager userManager = UsersManager.getInstance();
        User auth_user = userManager.autenticateUser(username, password);

        if (auth_user != null) {
            // L'utente è autenticato con successo
            SessionManager.getInstance().loginUser(auth_user);
            userManager.saveUsers(this); // Salva gli utenti dopo il login

            Intent examsIntent = new Intent(this, ExamsActivity.class);
            startActivity(examsIntent);
        } else {
            // L'utente non è stato autenticato
            Toast.makeText(this, "Autenticazione fallita. Verifica le credenziali.", Toast.LENGTH_SHORT).show();
        }
    }

    /*
    public void loginUser(View view) {
        // Esempio di autenticazione utente
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        UsersManager userManager = UsersManager.getInstance();
        User auth_user = userManager.autenticateUser(username, password);

        if (auth_user != null) {
            // L'utente è autenticato con successo
            // Puoi passare alla pagina degli esami o fare altre operazioni
            Intent examsIntent = new Intent(this, ExamsActivity.class);
            startActivity(examsIntent);
        } else {
            // L'utente non è stato autenticato
            // Puoi mostrare un messaggio di errore o fare altre operazioni
            Toast.makeText(this, "Autenticazione fallita. Verifica le credenziali.", Toast.LENGTH_SHORT).show();
        }
     */
}