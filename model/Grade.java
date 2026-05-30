package model;

import util.Displayable;
import util.Gradable;
import util.GradeUtils;

public class Grade implements Displayable, Gradable {

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
            this.gradeLetter = calculateGrade();

        } else {
            System.out.println("Invalid score!");
        }
    }

    @Override
    public String calculateGrade() {
        return GradeUtils.calculateGrade(score);
    }
    // ================= DISPLAY (OVERRIDING + OVERLOADING) =================
 
    // OVERRIDE: default displayInfo shows all fields

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
    // OVERLOAD: show or hide the student name column

    public void displayInfo(boolean showStudent) {
        if (showStudent) {
            displayInfo(); // reuse the full version
        } else {
            // Hide student name — useful when listing grades under a specific student
            System.out.println(
                    "Subject: " + (subject != null ? subject.getSubjectName() : "null")
                    + " | Exam: " + (exam != null ? exam.getExamName() : "null")
                    + " | Score: " + score
                    + " | Grade: " + gradeLetter
            );
        }
    }
    // OVERLOAD: individually control which columns appear

    public void displayInfo(boolean showStudent, boolean showSubject) {
        StringBuilder sb = new StringBuilder();
        if (showStudent)
            sb.append("Student: ").append(student != null ? student.getName() : "null").append(" | ");
        if (showSubject)
            sb.append("Subject: ").append(subject != null ? subject.getSubjectName() : "null").append(" | ");
        sb.append("Exam: ").append(exam != null ? exam.getExamName() : "null")
          .append(" | Score: ").append(score)
          .append(" | Grade: ").append(gradeLetter);
        System.out.println(sb.toString());
    }   
    @Override
    public String toString() {

        return "Grade [student=" + (student != null ? student.getName() : "null")
                + ", subject=" + (subject != null ? subject.getSubjectName() : "null")
                + ", exam=" + (exam != null ? exam.getExamName() : "null")
                + ", score=" + score
                + ", grade=" + gradeLetter + "]";
    }
}