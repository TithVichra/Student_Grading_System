package model;

import java.util.ArrayList;
import util.Displayable;
import util.GradeService;


public class Student implements Displayable {

    private static int totalStudents = 0;
    private static int nextStudentId = 1;

    private int studentId;
    private String name;
    private Gender gender;
    private String className;

    // Removed local grades list - grades are now managed centrally by GradeManager

    public Student(String name, Gender gender, String className) {

        this.studentId = nextStudentId++;

        setName(name);
        setGender(gender);
        setClassName(className);

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

    public ArrayList<Grade> getGrades() {
        GradeService service = new GradeService();
        return service.getGradesByStudent(this.studentId);
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


    // ================= DISPLAY =================

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
                "Student ID: " + studentId +
                " | Name: " + name +
                " | Gender: " + gender +
                " | Class: " + className
        );
    }
}