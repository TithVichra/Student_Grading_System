package model;

import util.Displayable;

public abstract class Person implements Displayable {

    protected int id;
    protected String name;
    protected Gender gender;

    public Person(int id, String name, Gender gender) {
        setId(id);
        this.name = cleanText(name, "Unknown Name");
        setGender(gender);
    }

    private String cleanText(String value, String defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return value.trim();
    }

    private void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            this.id = 0;
        }
    }

    // ================= GETTERS =================

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    // ================= SETTERS =================

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public void setGender(Gender gender) {
        if (gender == null) {
            this.gender = Gender.OTHER;
        } else {
            this.gender = gender;
        }
    }

    // Shared method

    public void displayBasicInfo() {
        System.out.print(
            "ID: " + id +
            " | Name: " + name +
            " | Gender: " + gender
        );
    }

    public void displayInfo() {
    displayBasicInfo();
}
}