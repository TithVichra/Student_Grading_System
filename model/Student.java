package model;

import java.util.ArrayList;
import util.GradeManager;

public class Student {
    private static int totalStudents = 0;
    private static int nextStudentId = 1;

    private int studentId;
    private String name;
    private Gender gender;
    private String className;
    private ArrayList<String> subjectCodes;

    public Student(String name, Gender gender, String className) {
        this.studentId = nextStudentId++;
        setName(name);
        setGender(gender);
        setClassName(className);
        this.subjectCodes = new ArrayList<>();
        totalStudents++;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getClassName() {
        return className;
    }

    public ArrayList<String> getSubjectCodes() {
        return new ArrayList<>(subjectCodes);
    }

    public void setStudentId(int studentId) {
        if (studentId > 0) {
            this.studentId = studentId;
        } else {
            System.out.println("Invalid student ID! Using default value 0.");
            this.studentId = 0;
        }
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name! Using default 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            System.out.println("Invalid gender! Using default FEMALE.");
            this.gender = Gender.FEMALE;
        }
    }

    public void setClassName(String className) {
        if (className != null && !className.trim().isEmpty()) {
            this.className = className;
        } else {
            System.out.println("Invalid class name! Using default 'N/A'.");
            this.className = "N/A";
        }
    }

    // Methods to manage subject codes
    public void addSubjectCode(String subjectCode) {
        if (subjectCode != null && !subjectCode.isEmpty() && !subjectCodes.contains(subjectCode)) {
            subjectCodes.add(subjectCode);
        } else if (subjectCode != null) {
            System.out.println("Subject code already exists for this student.");
        }
    }

    public void removeSubjectCode(String subjectCode) {
        if (subjectCode != null) {
            subjectCodes.remove(subjectCode);
        }
    }

    // Calculate average score for this student using GradeManager
    public double calculateAverageScore() {
        return GradeManager.calculateAverageScore(this.studentId);
    }

    @Override
    public String toString() {
        return "Student [id=" + studentId +
               ", name=" + name +
               ", gender=" + gender +
               ", class=" + className + "]";
    }
}