package com.example.myunitranscript.model;

import java.io.Serializable;
import java.util.ArrayList;
        import java.util.List;

public class ExamsManager implements Serializable {
    private List<Exam> examsList;

    public ExamsManager() {
        this.examsList = new ArrayList<>();
    }

    public void addElement(Exam newExam) {
        examsList.add(newExam);
    }

    /*j
    public ExamsManager getExamsManager(){
        if (examsList.isEmpty())
            return new ExamsManager();
        return this;
    }
    */

    public List<Exam> getExamsList() {
        if (examsList.isEmpty())
            return new ArrayList<>();
        return examsList;
    }


    public String getAllExams() {
        StringBuilder result = new StringBuilder();

        for (Exam exam : examsList) {
            result.append(exam.getName()).append("\n");
            result.append("Ects: ").append(exam.getEcts()).append("\n");
            result.append("Grade: ").append(exam.getGrade()).append("\n\n");
        }

        return result.toString();
    }

    public void removeElement(Exam exam) {
        examsList.remove(exam);
    }

}