package com.example.myunitranscript.model;

import java.io.Serializable;

public class Exam implements Serializable {
    private String name;
    private int ects;
    private int grade;

    public Exam(String name, int ects, int grade) {
        this.name = name;
        this.ects = ects;
        this.grade = grade;
    }


    // Metodi getter e setter per accedere e modificare gli attributi

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

