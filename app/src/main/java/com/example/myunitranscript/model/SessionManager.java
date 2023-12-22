package com.example.myunitranscript.model;

public class SessionManager {
    private static final SessionManager instance = new SessionManager();
    private User currentUser;

    private SessionManager() {
    }

    public static SessionManager getInstance() {
        return instance;
    }

    public void loginUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void logoutUser() {
        currentUser = null;
    }
}


/*
public class SessionManager {
    private static SessionManager instance;
    private ExamsManager examsManager;
    private User currentUser;

    private SessionManager() {
        this.examsManager = new ExamsManager();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void setCurrentUser(User utente) {
        this.currentUser = utente;
        // Initialize examsManager of current user with a new instance, only if not already instantiated
        if (currentUser != null && currentUser.getExamsManager() == null) {
            currentUser.setExamsManager(new ExamsManager());
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public ExamsManager getExamsManager() {
        return examsManager;
    }
}
*/
