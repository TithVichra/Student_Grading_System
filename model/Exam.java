package model;

import util.Displayable;

public class Exam implements Displayable {
    private String examName;   // exam name
    private String examDate;   // exam date
    private Subject subject;   // associated subject (may be null until set)

    // constructor (uses setters for validation)
    public Exam(String examName, String examDate) {
        setExamName(examName);
        setExamDate(examDate);
    }

    // getter methods
    public String getExamName() {
        return examName;
    }

    public String getExamDate() {
        return examDate;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    // setter methods with validation
    public void setExamName(String examName) {
        if (examName != null && !examName.isEmpty()) {
            this.examName = examName;
        } else {
            System.out.println("Invalid exam name!");
        }
    }

    public void setExamDate(String examDate) {
        if (examDate != null && !examDate.isEmpty()) {
            this.examDate = examDate;
        } else {
            System.out.println("Invalid exam date!");
        }
    }

    @Override
    public String toString() {
        return "Exam [examName=" + examName + ", examDate=" + examDate + "]";
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Exam: " + examName +
                " | Date: " + examDate
        );
    }
}