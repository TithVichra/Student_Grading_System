package model;

public class Grade {
    private Student student;
    private Subject subject;
    private Exam exam;
    private double score;
    private String gradeLetter;

    public Grade(Student student, Subject subject, Exam exam, double score, String gradeLetter) {
        this.student = student;
        this.subject = subject;
        this.exam = exam;
        this.score = score;
        this.gradeLetter = gradeLetter;
    }

    // Getters
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

    // Setters with validation
    public void setStudent(Student student) {
        if (student != null) {
            this.student = student;
        } else {
            System.out.println("Invalid student! Student cannot be null.");
        }
    }

    public void setSubject(Subject subject) {
        if (subject != null) {
            this.subject = subject;
        } else {
            System.out.println("Invalid subject! Subject cannot be null.");
        }
    }

    public void setExam(Exam exam) {
        if (exam != null) {
            this.exam = exam;
        } else {
            System.out.println("Invalid exam! Exam cannot be null.");
        }
    }

    public void setScore(double score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("Invalid score! Score must be between 0 and 100.");
        }
    }

    public void setGradeLetter(String gradeLetter) {
        if (gradeLetter != null && !gradeLetter.isEmpty()) {
            this.gradeLetter = gradeLetter;
        } else {
            System.out.println("Invalid grade letter!");
        }
    }

    @Override
    public String toString() {
        return "Grade [student=" + student +
               ", subject=" + subject +
               ", exam=" + exam +
               ", score=" + score +
               ", grade=" + gradeLetter + "]";
    }
}