package model;

public class Person {
    protected int id;
    protected String name;
    protected Gender gender;

    public Person(int id, String name, Gender gender) {
        this.id = id;
        setName(name);
        setGender(gender);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            this.name = "Unknown";
        }
    }

    public void setGender(Gender gender) {
        if (gender != null) {
            this.gender = gender;
        } else {
            this.gender = Gender.OTHER;
        }
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", gender=" + gender + "]";
    }
}
