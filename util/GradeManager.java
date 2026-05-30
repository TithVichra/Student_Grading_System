package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Exam;
import model.Grade;
import model.Student;
import model.Subject;

public class GradeManager implements Displayable {

    // make grades a shared static map (still shared across all instances)
    private static Map<String, Grade> grades = new HashMap<>();

    // =========================
    // KEY GENERATION
    // =========================
    private static String createKey(int studentId, String subjectCode, String examName) {

        String normalizedSubject = (subjectCode == null)
                ? ""
                : subjectCode.trim().toUpperCase();

        String normalizedExam = (examName == null)
                ? ""
                : examName.trim().toLowerCase();

        return studentId + "-" + normalizedSubject + "-" + normalizedExam;
    }

    // =========================
    // ADD GRADE (WITH DUPLICATE CHECK)
    // =========================
    public static boolean addGrade(Grade grade) {

        if (grade == null) return false;

        int studentId =
                (grade.getStudent() == null)
                        ? 0
                        : grade.getStudent().getStudentId();

        String subjectCode =
                (grade.getSubject() == null)
                        ? null
                        : grade.getSubject().getSubjectCode();

        String examName =
                (grade.getExam() == null)
                        ? null
                        : grade.getExam().getExamName();

        String key = createKey(studentId, subjectCode, examName);

        if (grades.containsKey(key)) {
            System.out.println("Duplicate grade detected for student " + studentId);
            return false;
        }

        grades.put(key, grade);

        return true;
    }
// OVERLOAD: build and add a grade using raw IDs/strings (useful for data import)
// Searches for matching student/subject/exam in existing grades — simple lookup approach
    
public static boolean addGrade(int studentId, String subjectCode, String examName, double score) {
        // Find matching student and subject+exam from stored grades
        Student foundStudent = null;
        Subject foundSubject = null;
        Exam    foundExam    = null;
 
        for (Grade g : grades.values()) {
            if (g.getStudent() != null && g.getStudent().getStudentId() == studentId)
                foundStudent = g.getStudent();
            if (g.getSubject() != null && g.getSubject().getSubjectCode().equalsIgnoreCase(subjectCode))
                foundSubject = g.getSubject();
            if (g.getExam() != null && g.getExam().getExamName().equalsIgnoreCase(examName))
                foundExam = g.getExam();
        }
 
        if (foundStudent == null || foundSubject == null || foundExam == null) {
            System.out.println("addGrade(int,String,String,double): could not resolve references.");
            return false;
        }
        return addGrade(new Grade(foundStudent, foundSubject, foundExam, score));
    }
    // =========================
    // CREATE AND ADD GRADE (COMBINED)
    // =========================
    public static Grade createGrade(Student student, Subject subject, Exam exam, double score) {
        Grade grade = new Grade(student, subject, exam, score);
        if (addGrade(grade)) {
            return grade;
        } else {
            return null; // Duplicate detected
        }
    }

    // =========================
    // GET GRADES BY STUDENT //
    // =========================

    public static ArrayList<Grade> getGradesByStudent(int studentId) {
        ArrayList<Grade> result = new ArrayList<>();
        for (Grade grade : new ArrayList<>(grades.values())) {
            if (grade.getStudent() != null &&
                grade.getStudent().getStudentId() == studentId) {
                result.add(grade);
            }
        }
        return result;
    }

    // =========================
    // AVERAGE SCORE
    // =========================
    
    public static double calculateAverageScore(int studentId) {
        ArrayList<Grade> studentGrades = getGradesByStudent(studentId);
        if (studentGrades.isEmpty()) return 0.0;
        double sum = 0;
        for (Grade g : studentGrades) sum += g.getScore();
        return sum / studentGrades.size();
    }
    // OVERLOAD: average using a Student object directly (delegates to ID version)
    public static double calculateAverageScore(Student student) {
        if (student == null) return 0.0;
        return calculateAverageScore(student.getStudentId());
    }

    // =========================
    // GET ALL GRADES (FIXED)
    // =========================
    public static ArrayList<Grade> getAllGrades() {
        return new ArrayList<>(grades.values());
    }

    @Override
    public void displayInfo() {
        System.out.println("GradeManager: " + grades.size() + " grade(s) stored.");
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }
        for (Grade grade : grades.values()) {
            grade.displayInfo();
        }
    }
}