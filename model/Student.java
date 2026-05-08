package model;

import java.util.ArrayList;
import util.GradeManager;
import util.Displayable;

public class Student implements Displayable {

    private static int totalStudents = 0;
    private static int nextStudentId = 1;

    private int studentId;
    private String name;
    private Gender gender;
    private String className;

    // UPDATED
    private ArrayList<Subject> subjects;

    private ArrayList<Grade> grades;

    public Student(String name, Gender gender, String className) {

        this.studentId = nextStudentId++;

        setName(name);
        setGender(gender);
        setClassName(className);

        subjects = new ArrayList<>();
        grades = new ArrayList<>();

        totalStudents++;
    }

    // ================= GETTERS =================

    public static int getTotalStudents() {
        return totalStudents;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }

    public ArrayList<Grade> getGrades() {
        return new ArrayList<>(grades);
    }

    // ================= SETTERS =================

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            this.gender = Gender.OTHER;
        }
    }

    public void setClassName(String className) {
        if (className != null && !className.trim().isEmpty()) {
            this.className = className;
        } else {
            this.className = "N/A";
        }
    }

    // ================= SUBJECT METHODS =================

    public void addSubject(Subject subject) {

        if (subject != null && !subjects.contains(subject)) {
            subjects.add(subject);
        }
    }

    public void removeSubject(Subject subject) {
        subjects.remove(subject);
    }

    // ================= GRADE METHODS =================

    public void addGrade(Grade grade) {

        if (grade != null && !grades.contains(grade)) {
            grades.add(grade);
        }
    }

    public void removeGrade(Grade grade) {
        grades.remove(grade);
    }

    // ================= BUSINESS LOGIC =================

    public double calculateAverageScore() {
        return GradeManager.calculateAverageScore(studentId);
    }

    @Override
    public String toString() {
        return "Student [id=" + studentId +
                ", name=" + name +
                ", gender=" + gender +
                ", class=" + className + "]";
    }
    @Override
    public void displayInfo() {

        System.out.println(
                "Student ID: " + studentId
                + " | Name: " + name
                + " | Gender: " + gender
                + " | Class: " + className
        );
    }
}