package main.java.Persons;

public class Manager extends Person {

    private String department;

    public Manager(String name, String surname, String phoneNum, String birthDate, String department) {
        super(name, surname, phoneNum, birthDate);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
