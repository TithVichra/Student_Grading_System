package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Exam;
import model.Grade;
import model.Student;
import model.Subject;

public class GradeManager {

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
    // GET GRADES BY STUDENT
    // =========================
    public static ArrayList<Grade> getGradesByStudent(int studentId) {

        ArrayList<Grade> result = new ArrayList<>();

        for (Grade grade : grades.values()) {

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

        for (Grade g : studentGrades) {
            sum += g.getScore();
        }

        return sum / studentGrades.size();
    }

    // =========================
    // GET ALL GRADES (FIXED)
    // =========================
    public static ArrayList<Grade> getAllGrades() {
        return new ArrayList<>(grades.values());
    }
}