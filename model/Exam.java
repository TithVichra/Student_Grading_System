package model;
public class Exam {
    private String examName;   // exam name
    private String examDate;   // exam date

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
}