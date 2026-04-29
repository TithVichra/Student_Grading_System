package model;

import java.util.ArrayList;

public class Subject {
    private String subjectCode;
    private String subjectName;
    private String teacherName;
    private ArrayList<Exam> exams;

    // constructor → uses setters for validation
    public Subject(String subjectCode, String subjectName, String teacherName) {
        setSubjectCode(subjectCode);
        setSubjectName(subjectName);
        setTeacherName(teacherName);
        this.exams = new ArrayList<>();
    }

    // getter methods
    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    // setter methods with validation

    public void setSubjectCode(String subjectCode) {
        if (subjectCode != null && !subjectCode.isEmpty()) {
            this.subjectCode = subjectCode;
        } else {
            System.out.println("Invalid subject code!");
        }
    }

    public void setSubjectName(String subjectName) {
        if (subjectName != null && !subjectName.isEmpty()) {
            this.subjectName = subjectName;
        } else {
            System.out.println("Invalid subject name!");
        }
    }

    public void setTeacherName(String teacherName) {
        if (teacherName != null && !teacherName.isEmpty()) {
            this.teacherName = teacherName;
        } else {
            System.out.println("Invalid teacher name!");
        }
    }

    // Methods to manage exams
    public void addExam(Exam exam) {
        if (exam != null && !exams.contains(exam)) {
            exams.add(exam);
        } else if (exam != null) {
            System.out.println("Exam already exists for this subject.");
        }
    }

    public void removeExam(Exam exam) {
        if (exam != null) {
            exams.remove(exam);
        }
    }

    @Override
    public String toString() {
        return "Subject [subjectCode=" + subjectCode +
               ", subjectName=" + subjectName +
               ", teacherName=" + teacherName + "]";
    }
}