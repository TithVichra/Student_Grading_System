package util;

import java.util.ArrayList;
import model.Grade;

public class GradeService
        implements Searchable, Averagable, Displayable {

    @Override
    public ArrayList<Grade> getGradesByStudent(int studentId) {

        return GradeManager.getGradesByStudent(studentId);
    }

    @Override
    public double calculateAverageScore(int studentId) {

        return GradeManager.calculateAverageScore(studentId);
    }

    @Override
    public void displayInfo() {
        System.out.println("GradeService: provides grade lookup and average score calculation.");
        System.out.println("Available operations: getGradesByStudent(studentId), calculateAverageScore(studentId)");
    }
}