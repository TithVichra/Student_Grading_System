package main;

import java.util.ArrayList;
import model.*;
import util.Averagable;
import util.GradeManager;
import util.GradeService;
import util.Searchable;

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
        // TEACHERS
        // =========================

        Teacher mathTeacher = new Teacher("Mr. Dara", Gender.MALE, "dara@school.edu", "Mathematics");
        Teacher javaTeacher = new Teacher("Mr. John", Gender.MALE, "john@school.edu", "Computer Science");

        // =========================
        // SUBJECTS
        // =========================

        Subject math = new Subject("M101", "Mathematics", mathTeacher);
        Subject java = new Subject("J102", "Java Programming", javaTeacher);

        // =========================
        // EXAMS
        // =========================

        Exam quiz = new Exam("Quiz", "10-May-2026");
        Exam midterm = new Exam("Midterm", "20-May-2026");
        Exam finalExam = new Exam("Final", "10-June-2026");

        // associate exams with their subject before adding
        quiz.setSubject(math);
        midterm.setSubject(math);
        finalExam.setSubject(math);

        math.addExam(quiz);
        math.addExam(midterm);
        math.addExam(finalExam);

        Exam javaQuiz = new Exam("Java Quiz", "15-May-2026");
        javaQuiz.setSubject(java);
        java.addExam(javaQuiz);

        // =========================
        // GRADE CREATION (ONLY via GradeManager)
        // =========================

        GradeManager.createGrade(s1, math, quiz, 85);
        GradeManager.createGrade(s1, math, midterm, 90);
        GradeManager.createGrade(s2, math, finalExam, 70);

        GradeManager.createGrade(s1, java, javaQuiz, 90);

        // Test duplicate grade prevention
        Grade duplicate = GradeManager.createGrade(s1, math, quiz, 95);
        if (duplicate == null) {
            System.out.println("Duplicate grade creation prevented!");
        }

        // =========================
        // SERVICE INITIALIZATION
        // =========================

        GradeService gradeService = new GradeService();
        Searchable searchService = gradeService;
        Averagable averageService = gradeService;


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

        System.out.println("\n=== SEARCH STUDENT by ID " + s1.getStudentId() + " ===");
        for (Grade g : searchService.getGradesByStudent(s1.getStudentId())) {
            g.displayInfo();
        }

        // =========================
        // AVERAGE SCORE
        // =========================

        System.out.println("\nAverage Score for " + s1.getName() + ": "
        + averageService.calculateAverageScore(s1.getStudentId()));

        // =========================
        // TOTAL STUDENTS
        // =========================

        System.out.println("\nTotal Students: " + Student.getTotalStudents());
    }
}