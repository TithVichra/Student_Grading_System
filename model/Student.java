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

    // ================= DISPLAY (OVERRIDING)=================
    // Overide: student-specific displayInfo shows id, name, gender, + classname

    //Overload: displayInfo with falg to show grades as well
    public void displayInfo(boolean showGrades) {
        displayInfo(); // Call the original displayInfo for basic info
        if (showGrades) {
            ArrayList<Grade> grades = getGrades();
            if (grades.isEmpty()) {
                System.out.println("No grades recorded.");
            } else {
                for (Grade g: grades) {
                    System.out.print(" -> ");
                    g.displayInfo(); // Call Grade's displayInfo to show grade details
                }
            }
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(
            " | Class: " + className
        );
    }
}