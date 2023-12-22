package com.example.myunitranscript.model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class UsersManager {
    private static final UsersManager instance = new UsersManager();
    private final Map<String, User> registeredUsers;

    private UsersManager() {
        registeredUsers = new HashMap<>();
    }

    public static UsersManager getInstance() {
        return instance;
    }

    public void saveUsers(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (Map.Entry<String, User> entry : registeredUsers.entrySet()) {
            editor.putString(entry.getKey(), gson.toJson(entry.getValue()));
        }

        editor.apply();
    }

    public void loadUsers(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("users", Context.MODE_PRIVATE);

        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            User user = gson.fromJson(entry.getValue().toString(), User.class);
            registeredUsers.put(entry.getKey(), user);
        }
    }

    public boolean registerUser(String name, String surname, String birthdate, String password) {
        /*
        // Verifica se l'utente esiste già
        String username = set(name, surname);
        if (utentiRegistrati.containsKey(username)) {
            return false; // Utente già registrato
        }
        */

        // Crea un nuovo utente e aggiungilo al GestoreUtenti
        User newUser = new User(name, surname, birthdate, password);
        registeredUsers.put(newUser.getSurname(), newUser);
        return true; // Registrazione avvenuta con successo
    }

    public User autenticateUser(String username, String password) {
        // Carica gli utenti
        loadUsers(context);

        if (registeredUsers.containsKey(username)) {
            User user = registeredUsers.get(username);

            if (user != null && user.getPassword().equals(password)) {
                return user; // Autenticazione avvenuta con successo
            }
        }
        return null; // Autenticazione fallita
    }
}

