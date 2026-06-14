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

    public void setClassName(String className) {
        if (className != null && !className.trim().isEmpty()) {
            this.className = className;
        } else {
            this.className = "N/A";
        }
    }

    // OVERLOAD

    public void displayInfo(boolean showGrades) {
        displayInfo();

        if (showGrades) {

            ArrayList<Grade> grades = getGrades();

            if (grades.isEmpty()) {
                System.out.println("No grades recorded.");
            } else {

                for (Grade g : grades) {
                    System.out.print(" -> ");
                    g.displayInfo();
                }
            }
        }
    }

    @Override
    public void displayInfo() {
        displayBasicInfo();
        System.out.println(
            " | Class: " + className
        );
    }
}