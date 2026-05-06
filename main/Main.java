package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.*;
import util.GradeManager;

public class Main {
    private static Map<Integer, Student> students = new HashMap<>();
    private static Map<String, Subject> subjects = new HashMap<>();

    public static void main(String[] args) {

        // REQUIRED: ArrayLists
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Grade> gradeList = new ArrayList<>();

        // Create students
        Student s1 = new Student("Vichra", Gender.FEMALE, "Year 2");
        Student s2 = new Student("Dara", Gender.MALE, "Year 2");

        addStudent(s1);
        addStudent(s2);

        studentList.add(s1);
        studentList.add(s2);

        // Create subjects
        Subject math = new Subject("M101", "Mathematics", "Mr. Dara");
        Subject english = new Subject("E102", "English", "Ms. Linda");

        addSubject(math);
        addSubject(english);

        // Create exams
        Exam finalMath = new Exam("Final Exam", "10-June-2026");
        Exam midtermMath = new Exam("Midterm", "15-May-2026");
        Exam finalEnglish = new Exam("Final Exam", "12-June-2026");

        math.addExam(finalMath);
        math.addExam(midtermMath);
        english.addExam(finalEnglish);

        // Add subjects to students
        s1.addSubjectCode(math.getSubjectCode());
        s1.addSubjectCode(english.getSubjectCode());
        s2.addSubjectCode(math.getSubjectCode());

        // Create grades
        Grade g1 = new Grade(s1, math, finalMath, 85.5);
        Grade g2 = new Grade(s1, math, midtermMath, 90.0);
        Grade g3 = new Grade(s1, english, finalEnglish, 78.5);
        Grade g4 = new Grade(s2, math, finalMath, 92.0);

        if (addGrade(g1)) gradeList.add(g1);
        if (addGrade(g2)) gradeList.add(g2);
        if (addGrade(g3)) gradeList.add(g3);
        if (addGrade(g4)) gradeList.add(g4);

        // Attempt duplicate grade
        Grade duplicateGrade = new Grade(s1, math, finalMath, 85.5);
        if (addGrade(duplicateGrade)) {
            gradeList.add(duplicateGrade);
        }

        // =========================
        // STUDENTS
        // =========================
        System.out.println("=== STUDENTS ===");
        for (Student student : students.values()) {
            System.out.println(student);
        }

        // =========================
        // SUBJECTS
        // =========================
        System.out.println("\n=== SUBJECTS ===");
        for (Subject subject : subjects.values()) {
            System.out.println(subject);
            for (Exam exam : subject.getExams()) {
                System.out.println("  " + exam);
            }
        }

        // =========================
        // REQUIRED: LOOP THROUGH GRADES (NEW ADDITION)
        // =========================
        System.out.println("\n=== ALL GRADES (DETAILED) ===");
        for (Grade grade : gradeList) {
            System.out.println(
                "Student: " + grade.getStudent().getName() +
                " | Subject: " + grade.getSubject().getSubjectName() +
                " | Exam: " + grade.getExam().getExamName() +
                " | Score: " + grade.getScore() +
                " | Grade: " + grade.getGradeLetter()
            );
        }

        // =========================
        // SEARCH BY STUDENT ID
        // =========================
        System.out.println("\n=== GRADES FOR STUDENT ID: " + s1.getStudentId() + " ===");

        ArrayList<Grade> studentGrades = GradeManager.getGradesByStudent(s1.getStudentId());
        double sum = 0;

        for (Grade grade : studentGrades) {
            System.out.println(grade);
            sum += grade.getScore();
        }

        double avg = studentGrades.isEmpty() ? 0 : sum / studentGrades.size();

        // =========================
        // AVERAGE (SEPARATE HEADER KEPT)
        // =========================
        System.out.println("\n=== AVERAGE SCORES ===");
        for (Student student : students.values()) {
            System.out.printf("%s: %.2f\n",
                student.getName(),
                student.calculateAverageScore()
            );
        }

        // =========================
        // TOTAL STUDENTS
        // =========================
        System.out.println("\nTotal Students: " + Student.getTotalStudents());
    }

    private static void addStudent(Student student) {
        if (student != null && !students.containsKey(student.getStudentId())) {
            students.put(student.getStudentId(), student);
        }
    }

    private static void addSubject(Subject subject) {
        if (subject != null && !subjects.containsKey(subject.getSubjectCode())) {
            subjects.put(subject.getSubjectCode(), subject);
        }
    }

    private static boolean addGrade(Grade grade) {
        return GradeManager.addGrade(grade);
    }
}