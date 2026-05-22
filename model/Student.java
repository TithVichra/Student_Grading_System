package model;

import java.util.ArrayList;
import util.GradeService;

public class Student extends Person {

    private static int totalStudents = 0;
    private static int nextStudentId = 1;
    private String className;

    public Student(String name, Gender gender, String className) {
        super(nextStudentId++, name, gender);
        setClassName(className);
        totalStudents++;
    }

    // ================= GETTERS =================

    public static int getTotalStudents() {
        return totalStudents;
    }

    public int getStudentId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<Grade> getGrades() {
        GradeService service = new GradeService();
        return service.getGradesByStudent(getStudentId());
    }

    // ================= SETTERS ==================

    public void setClassName(String className) {
        if (className != null && !className.trim().isEmpty()) {
            this.className = className;
        } else {
            this.className = "N/A";
        }
    }

    // ================= DISPLAY =================

    @Override
    public String toString() {
        return "Student [id=" + id +
                ", name=" + name +
                ", gender=" + gender +
                ", class=" + className + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Student ID: " + id +
                " | Name: " + name +
                " | Gender: " + gender +
                " | Class: " + className
        );
    }
}