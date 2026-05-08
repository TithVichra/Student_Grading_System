package util;

import java.util.ArrayList;
import model.Grade;

public interface Searchable {

    ArrayList<Grade> getGradesByStudent(int studentId);
}