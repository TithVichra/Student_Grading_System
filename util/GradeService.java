package util;

import java.util.ArrayList;
import model.Grade;
import model.Student;

public class GradeService
        implements Searchable, Averagable, Displayable {

    @Override
    public ArrayList<Grade> getGradesByStudent(int studentId) {

        return GradeManager.getGradesByStudent(studentId);
    }
    // OVERLOAD: search using a Student object (delegates to ID version)

    public ArrayList<Grade> getGradesByStudent(Student student) {
        if (student == null) return new ArrayList<>();
        return getGradesByStudent(student.getStudentId());
    }

    @Override
    public double calculateAverageScore(int studentId) {

        return GradeManager.calculateAverageScore(studentId);
    }
    
    // OVERLOAD: average using a Student object
    public double calculateAverageScore(Student student) {
        return GradeManager.calculateAverageScore(student);
    }

    @Override
    public void displayInfo() {
        System.out.println("GradeService: provides grade lookup and average score calculation.");
        System.out.println("Available operations: getGradesByStudent(studentId), calculateAverageScore(studentId)");
    }
}