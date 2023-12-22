package com.example.myunitranscript.model;

public class User {

    private String name, surname, birthdate, password;
    private String username;
    private ExamsManager examsManager;

    public User(String name, String surname, String birthdate, String password) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.password = password;

        setUsername();
        this.examsManager = new ExamsManager();
    }

    public ExamsManager getExamsManager() {
        return this.examsManager;
    }

    public void setExamsManager(ExamsManager examsManager) {
        this.examsManager = examsManager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() {
        // username = first letter in name + "." + surname
        // this.username = String.valueOf(this.name.charAt(0)) + "." + this.surname;
        this.username = this.name + "." + this.surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
