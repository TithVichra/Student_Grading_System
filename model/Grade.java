package model;

import util.GradeUtils;
import util.Displayable;
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

        // automatically connect grade to student
        if (student != null) {
            student.addGrade(this);
        }
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
        }
    }

    public void setSubject(Subject subject) {
        if (subject != null) {
            this.subject = subject;
        }
    }

    public void setExam(Exam exam) {
        if (exam != null) {
            this.exam = exam;
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

        return "Grade [student=" + student.getName()
                + ", subject=" + subject.getSubjectName()
                + ", exam=" + exam.getExamName()
                + ", score=" + score
                + ", grade=" + gradeLetter + "]";
    }
    @Override
    public void displayInfo() {

        System.out.println(
                "Student: " + student.getName()
                + " | Subject: " + subject.getSubjectName()
                + " | Exam: " + exam.getExamName()
                + " | Score: " + score
                + " | Grade: " + gradeLetter
        );
    }
}