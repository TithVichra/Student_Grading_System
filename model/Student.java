package model;

import java.util.ArrayList;
import util.GradeService;

public class Student extends Person {

    private static int totalStudents = 0; //static? shared by all
    private static int nextStudentId = 1;

    private String className;

    public Student(String name, Gender gender, String className) { // constructor   //instance? name, each student has a different name
        super(nextStudentId++, name, gender);       //initialization
        setClassName(className);                    // null
        totalStudents++;
    }                                         

    public static int getTotalStudents() {  //counting
        return totalStudents;
    }

    public int getStudentId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<Grade> getGrades() {               //collab, find its grade          //Abstraction
        GradeService service = new GradeService();      //divison, easier, exact role
        return service.getGradesByStudent(getStudentId());
    }

    public void setClassName(String className) {
        if (className != null && !className.trim().isEmpty()) {
            this.className = className; // here cuz parameter would shadow the field or attribute
        } else {                        // bug? self-asigned, confusion
            this.className = "N/A";
        }
    }

    // OVERLOAD

    public void displayInfo(boolean showGrades) {  //instance based method, specific person's info
        displayInfo();                             //no operate on object state, reducing encapsulation and object behavior.

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
         super.displayInfo();
        System.out.println(
            " | Class: " + className
        );
    }
}