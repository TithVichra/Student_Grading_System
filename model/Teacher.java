package model;

public class Teacher extends Person {

    private static int nextTeacherId = 1;
    private String email;
    private String department;

    public Teacher(String name, Gender gender, String email, String department) {
        super(nextTeacherId++, name, gender);
        setEmail(email);
        setDepartment(department);
    }

    // ================= GETTERS =================

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }

    // ================= SETTERS =================

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            this.email = "N/A";
        }
    }

    public void setDepartment(String department) {
        if (department != null && !department.trim().isEmpty()) {
            this.department = department;
        } else {
            this.department = "General";
        }
    }
    // ================= DISPLAY (OVERRIDING) =================
 
    // OVERRIDE: Teacher-specific displayInfo shows id, name, gender + email + department
    
  
    // OVERLOAD: displayInfo with flag to show only contact info (email)
    public void displayInfo(boolean showContact) {
        if (showContact) {
            System.out.println(
                    "Teacher Name: " + name +
                    " | Email: " + email
            );
        } else {
            displayInfo(); // Call the original displayInfo for full details
        }
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(
            " | Email: " + email +
            " | Department: " + department
        );
    }
}
