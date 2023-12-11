package com.example.myunitranscript.model;

import java.io.Serializable;
import java.util.ArrayList;
        import java.util.List;

public class ExamsManager implements Serializable {
    private List<Exam> examsList;

    public ExamsManager() {
        examsList = new ArrayList<>();
    }

    public void addElement(Exam newExam) {
        examsList.add(newExam);
    }

    public List<Exam> getExamsList() {
        return examsList;
    }

    public String getAllExams() {
        StringBuilder result = new StringBuilder();

        for (Exam esame : examsList) {
            result.append(esame.getName()).append("\n");
            result.append("Crediti: ").append(esame.getEcts()).append("\n");
            result.append("Voto: ").append(esame.getGrade()).append("\n\n");
        }

        System.out.println(result.toString());

        return result.toString();
    }
}