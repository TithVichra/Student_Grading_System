package util;

import java.util.ArrayList;
import model.Grade;

public class GradeService
        implements Searchable, Averagable {

    @Override
    public ArrayList<Grade> getGradesByStudent(int studentId) {

        return GradeManager.getGradesByStudent(studentId);
    }

    @Override
    public double calculateAverageScore(int studentId) {

        return GradeManager.calculateAverageScore(studentId);
    }
}