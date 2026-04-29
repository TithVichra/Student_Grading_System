package util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Grade;

public class GradeManager {
    private static Map<String, Grade> grades = new HashMap<>();

    // Composite key: studentId-subjectCode-examName
    private static String createKey(int studentId, String subjectCode, String examName) {
        return studentId + "-" + subjectCode + "-" + examName;
    }

    public static void addGrade(Grade grade) {
        if (grade == null) return;
        String key = createKey(grade.getStudent().getStudentId(),
                               grade.getSubject().getSubjectCode(),
                               grade.getExam().getExamName());
        if (!grades.containsKey(key)) {
            grades.put(key, grade);
        }
    }

    public static ArrayList<Grade> getGradesByStudent(int studentId) {
        ArrayList<Grade> result = new ArrayList<>();
        for (Grade grade : grades.values()) {
            if (grade.getStudent().getStudentId() == studentId) {
                result.add(grade);
            }
        }
        return result;
    }

    public static double calculateAverageScore(int studentId) {
        ArrayList<Grade> studentGrades = getGradesByStudent(studentId);
        if (studentGrades.isEmpty()) return 0.0;
        double sum = 0.0;
        for (Grade g : studentGrades) {
            sum += g.getScore();
        }
        return sum / studentGrades.size();
    }

    public static Map<String, Grade> getAllGrades() {
        return new HashMap<>(grades);
    }
}