package main;

import java.util.ArrayList;
import model.*;
import util.GradeManager;

public class Main {

    public static void main(String[] args) {

        // =========================
        // STUDENTS
        // =========================

        Student s1 = new Student("Vichra", Gender.FEMALE, "Year 2");
        Student s2 = new Student("Dara", Gender.MALE, "Year 2");

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);

        // =========================
        // SUBJECTS
        // =========================

        Subject math = new Subject("M101", "Mathematics", "Mr. Dara");
        Subject java = new Subject("J102", "Java Programming", "Mr. John");

        // =========================
        // EXAMS
        // =========================

        Exam quiz = new Exam("Quiz", "10-May-2026");
        Exam midterm = new Exam("Midterm", "20-May-2026");
        Exam finalExam = new Exam("Final", "10-June-2026");

        math.addExam(quiz);
        math.addExam(midterm);
        math.addExam(finalExam);

        // =========================
        // GRADE CREATION (ONLY via GradeManager)
        // =========================

        Grade g1 = new Grade(s1, math, quiz, 85);
        Grade g2 = new Grade(s1, math, midterm, 90);
        Grade g3 = new Grade(s2, math, finalExam, 70);

        GradeManager.addGrade(g1);
        GradeManager.addGrade(g2);
        GradeManager.addGrade(g3);

        // =========================
        // DISPLAY STUDENTS
        // =========================

        System.out.println("=== STUDENTS ===");
        for (Student s : students) {
            s.displayInfo();
        }

        // =========================
        // DISPLAY SUBJECTS
        // =========================

        System.out.println("\n=== SUBJECTS ===");
        math.displayInfo();
        java.displayInfo();

        // =========================
        // DISPLAY ALL GRADES (FROM MANAGER)
        // =========================

        System.out.println("\n=== ALL GRADES ===");
        for (Grade g : GradeManager.getAllGrades()) {
            g.displayInfo();
        }

        // =========================
        // SEARCH GRADES BY STUDENT
        // =========================

        System.out.println("\n=== SEARCH STUDENT ===");
        for (Grade g : GradeManager.getGradesByStudent(s1.getStudentId())) {
            g.displayInfo();
        }

        // =========================
        // AVERAGE SCORE
        // =========================

        System.out.println("\nAverage Score: " + s1.calculateAverageScore());

        // =========================
        // TOTAL STUDENTS
        // =========================

        System.out.println("\nTotal Students: " + Student.getTotalStudents());
    }
}