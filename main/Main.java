package main;

import java.util.ArrayList;

import model.*;
import util.GradeManager;

public class Main {

    public static void main(String[] args) {

        // REQUIRED ARRAYLISTS
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Grade> grades = new ArrayList<>();

        // =========================
        // CREATE STUDENTS
        // =========================

        Student s1 =
                new Student("Vichra",
                        Gender.FEMALE,
                        "Year 2");

        Student s2 =
                new Student("Dara",
                        Gender.MALE,
                        "Year 2");

        students.add(s1);
        students.add(s2);

        // =========================
        // CREATE SUBJECTS
        // =========================

        Subject math =
                new Subject("M101",
                        "Mathematics",
                        "Mr. Dara");

        Subject java =
                new Subject("J102",
                        "Java Programming",
                        "Mr. John");

        // =========================
        // CREATE EXAMS
        // =========================

        Exam quiz =
                new Exam("Quiz",
                        "10-May-2026");

        Exam midterm =
                new Exam("Midterm",
                        "20-May-2026");

        Exam finalExam =
                new Exam("Final",
                        "10-June-2026");

        // add exams to subject
        math.addExam(quiz);
        math.addExam(midterm);
        math.addExam(finalExam);

        // =========================
        // ADD SUBJECTS TO STUDENTS
        // =========================

        s1.addSubject(math);
        s1.addSubject(java);

        s2.addSubject(math);

        // =========================
        // CREATE GRADE RECORDS
        // =========================

        Grade g1 =
                new Grade(s1, math, quiz, 85);

        Grade g2 =
                new Grade(s1, math, midterm, 90);

        Grade g3 =
                new Grade(s2, math, finalExam, 70);

        // duplicate checking
        if (GradeManager.addGrade(g1)) grades.add(g1);
        if (GradeManager.addGrade(g2)) grades.add(g2);
        if (GradeManager.addGrade(g3)) grades.add(g3);

        // =========================
        // DISPLAY STUDENTS
        // =========================

        System.out.println("=== STUDENTS ===");

        for (Student student : students) {
            student.displayInfo();
        }

        // =========================
        // DISPLAY SUBJECTS
        // =========================

        System.out.println("\n=== SUBJECTS ===");

        math.displayInfo();
        java.displayInfo();

        // =========================
        // DISPLAY GRADES
        // =========================

        System.out.println("\n=== ALL GRADES ===");

        for (Grade g : grades) {
            g.displayInfo();
        }

        // =========================
        // SEARCH BY STUDENT ID
        // =========================

        System.out.println("\n=== SEARCH STUDENT ===");

        ArrayList<Grade> result =
                GradeManager.getGradesByStudent(
                        s1.getStudentId());

        for (Grade g : result) {
            g.displayInfo();
        }

        // =========================
        // AVERAGE SCORE
        // =========================

        System.out.println(
                "\nAverage Score: "
                + s1.calculateAverageScore());

        // =========================
        // TOTAL STUDENTS
        // =========================

        System.out.println(
                "\nTotal Students: "
                + Student.getTotalStudents());
    }
}