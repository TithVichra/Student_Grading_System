package model;

import java.util.ArrayList;
import util.Displayable;

public class Subject implements Displayable {
    private String subjectCode;
    private String subjectName;
    private Teacher teacher;
    private ArrayList<Exam> exams;

    // constructor → uses setters for validation
    public Subject(String subjectCode, String subjectName, Teacher teacher) {
        setSubjectCode(subjectCode);
        setSubjectName(subjectName);
        setTeacher(teacher);
        this.exams = new ArrayList<>();
    }

    // getter methods
    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getTeacherName() {
        return teacher != null ? teacher.getName() : "Unknown";
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    // setter methods with validation

    public void setSubjectCode(String subjectCode) {
        if (subjectCode != null && !subjectCode.isEmpty()) {
            this.subjectCode = subjectCode;
        } else {
            System.out.println("Invalid subject code!");
        }
    }

    public void setSubjectName(String subjectName) {
        if (subjectName != null && !subjectName.isEmpty()) {
            this.subjectName = subjectName;
        } else {
            System.out.println("Invalid subject name!");
        }
    }

    public void setTeacher(Teacher teacher) {
        if (teacher != null) {
            this.teacher = teacher;
        } else {
            System.out.println("Invalid teacher!");
        }
    }

    // Methods to manage exams
    public void addExam(Exam exam) {
        if (exam != null && !exams.contains(exam)) {
            exams.add(exam);
        } else if (exam != null) {
            System.out.println("Exam already exists for this subject.");
        }
    }

    public void removeExam(Exam exam) {
        if (exam != null) {
            exams.remove(exam);
        }
    }

    @Override
    public String toString() {
        return "Subject [subjectCode=" + subjectCode +
               ", subjectName=" + subjectName +
               ", teacherName=" + getTeacherName() + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Subject Code: " + subjectCode
                + " | Subject Name: " + subjectName
                + " | Teacher: " + getTeacherName()
        );
    }
}