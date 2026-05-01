package main;
// Main class to demonstrate the functionality of the student grading system
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.*;
import util.GradeManager;
import util.GradeUtils;

public class Main {
    private static Map<Integer, Student> students = new HashMap<>();
    private static Map<String, Subject> subjects = new HashMap<>();

    public static void main(String[] args) {
        // Create students with auto-incrementing IDs
        Student s1 = new Student("Vichra", Gender.FEMALE, "Year 2");
        Student s2 = new Student("Dara", Gender.MALE, "Year 2");

        addStudent(s1);
        addStudent(s2);

        // Create subjects
        Subject math = new Subject("M101", "Mathematics", "Mr. Dara");
        Subject english = new Subject("E102", "English", "Ms. Linda");

        addSubject(math);
        addSubject(english);

        // Create exams and link them to subjects
        Exam finalMath = new Exam("Final Exam", "10-June-2026");
        Exam midtermMath = new Exam("Midterm", "15-May-2026");
        Exam finalEnglish = new Exam("Final Exam", "12-June-2026");

        math.addExam(finalMath);
        math.addExam(midtermMath);
        english.addExam(finalEnglish);

        // Link subject codes to students
        s1.addSubjectCode(math.getSubjectCode());
        s1.addSubjectCode(english.getSubjectCode());
        s2.addSubjectCode(math.getSubjectCode());

        // Create grades
        Grade g1 = new Grade(s1, math, finalMath, 85.5, GradeUtils.calculateGrade(85.5));
        Grade g2 = new Grade(s1, math, midtermMath, 90.0, GradeUtils.calculateGrade(90.0));
        Grade g3 = new Grade(s1, english, finalEnglish, 78.5, GradeUtils.calculateGrade(78.5));
        Grade g4 = new Grade(s2, math, finalMath, 92.0, GradeUtils.calculateGrade(92.0));

        addGrade(g1);
        addGrade(g2);
        addGrade(g3);
        addGrade(g4);

        // Attempt duplicate grade entry (same student, subject, exam)
        addGrade(new Grade(s1, math, finalMath, 85.5, GradeUtils.calculateGrade(85.5)));

        // Display all students
        System.out.println("=== STUDENTS ===");
        for (Student student : students.values()) {
            System.out.println(student);
        }

        // Display all subjects and their exams
        System.out.println("\n=== SUBJECTS ===");
        for (Subject subject : subjects.values()) {
            System.out.println(subject);
            for (Exam exam : subject.getExams()) {
                System.out.println("  " + exam);
            }
        }

        // Search by student and display grades per student
        System.out.println("\n=== GRADES FOR STUDENTS ===");
        for (Student student : students.values()) {
            System.out.println("Student: " + student.getName() + " (ID: " + student.getStudentId() + ")");
            ArrayList<Grade> studentGrades = GradeManager.getGradesByStudent(student.getStudentId());
            if (studentGrades.isEmpty()) {
                System.out.println("  No grades found.");
            } else {
                for (Grade grade : studentGrades) {
                    System.out.println("  " + grade);
                }
            }
        }

        // Display average scores per student
        System.out.println("\n=== AVERAGE SCORES ===");
        for (Student student : students.values()) {
            System.out.printf("%s: %.2f\n", student.getName(), student.calculateAverageScore());
        }

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

    private static void addGrade(Grade grade) {
        GradeManager.addGrade(grade);
    }
}
