package model;

import util.Displayable;
import util.GradeUtils;
public class Grade implements Displayable {

    private Student student;
    private Subject subject;
    private Exam exam;

    private double score;
    private String gradeLetter;

    public Grade(Student student, Subject subject,
          Exam exam, double score) {

        setStudent(student);
        setSubject(subject);
        setExam(exam);
        setScore(score);

        // Grade objects are created here, but they should be added to the system
        // through GradeManager.addGrade() so duplicate detection and student
        // synchronization happen in one place.
    }

    // ================= GETTERS =================

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public Exam getExam() {
        return exam;
    }

    public double getScore() {
        return score;
    }

    public String getGradeLetter() {
        return gradeLetter;
    }

    // ================= SETTERS =================

    public void setStudent(Student student) {
        if (student != null) {
            this.student = student;
        } else {
            System.out.println("Invalid student!");
        }
    }

    public void setSubject(Subject subject) {
        if (subject != null) {
            this.subject = subject;
        } else {
            System.out.println("Invalid subject!");
        }
    }

    public void setExam(Exam exam) {
        if (exam != null) {
            this.exam = exam;
        } else {
            System.out.println("Invalid exam!");
        }
    }

    public void setScore(double score) {

        if (score >= 0 && score <= 100) {

            this.score = score;

            // AUTO CALCULATE GRADE
            this.gradeLetter =
                    GradeUtils.calculateGrade(score);

        } else {
            System.out.println("Invalid score!");
        }
    }

    @Override
    public String toString() {

        return "Grade [student=" + (student != null ? student.getName() : "null")
                + ", subject=" + (subject != null ? subject.getSubjectName() : "null")
                + ", exam=" + (exam != null ? exam.getExamName() : "null")
                + ", score=" + score
                + ", grade=" + gradeLetter + "]";
    }
    @Override
    public void displayInfo() {

        System.out.println(
                "Student: " + (student != null ? student.getName() : "null")
                + " | Subject: " + (subject != null ? subject.getSubjectName() : "null")
                + " | Exam: " + (exam != null ? exam.getExamName() : "null")
                + " | Score: " + score
                + " | Grade: " + gradeLetter
        );
    }
}