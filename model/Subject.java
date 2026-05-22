package model;

import java.util.ArrayList;
import util.Displayable;

public class Subject implements Displayable {
    private String subjectCode;
    private String subjectName;
    private Teacher teacher;
    private ArrayList<Exam> exams;
    private static int subjectCount = 0;

    public Subject(String subjectCode, String subjectName, Teacher teacher) {
        this.subjectCode = cleanText(subjectCode, "NO_CODE");
        this.subjectName = cleanText(subjectName, "Unknown Subject");
        this.teacher = teacher;
        this.exams = new ArrayList<>();
        subjectCount++;
    }

    private String cleanText(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setSubjectName(String subjectName) {
        if (subjectName != null && !subjectName.trim().isEmpty()) {
            this.subjectName = subjectName.trim();
        }
    }

    public void setTeacher(Teacher teacher) {
        if (teacher != null) {
            this.teacher = teacher;
        }
    }

    public boolean addExam(Exam exam) {
        if (exam == null) {
            System.out.println("Cannot add a null exam.");
            return false;
        }

        if (exam.getSubject() != this) {
            System.out.println("Cannot add exam " + exam.getExamName() + " to " + subjectName + ".");
            System.out.println("This exam belongs to another subject.");
            return false;
        }

        for (Exam existingExam : exams) {
            if (existingExam.getExamName().equalsIgnoreCase(exam.getExamName())) {
                System.out.println("Duplicate exam name in this subject: " + exam.getExamName());
                return false;
            }
        }

        exams.add(exam);
        return true;
    }

    public ArrayList<Exam> getExamsCopy() {
        return new ArrayList<>(exams);
    }

    public int getExamCount() {
        return exams.size();
    }

    public void displayExamList() {
        System.out.println("\nExams for " + subjectName + ":");

        if (exams.isEmpty()) {
            System.out.println("No exams yet.");
            return;
        }

        for (Exam exam : exams) {
            exam.displayInfo();
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Subject Code: " + subjectCode
                + " | Subject Name: " + subjectName
                + " | Teacher: " + (teacher != null ? teacher.getName() : "No Teacher Assigned")
                + " | Exams: " + exams.size()
        );
    }

    public static int getSubjectCount() {
        return subjectCount;
    }
}