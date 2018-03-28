package main.java.Persons;

public class Manager extends Person {

    private String department;

    public Manager(String name, String surname, int birthDate, int phoneNum, String department) {
        super(name, surname, birthDate, phoneNum);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
