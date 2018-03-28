package main.java.Persons;

public class Employer extends Person {

    private String manager;

    public Employer(String name, String surname, int birthDate, int phoneNum, String manager) {
        super(name, surname, birthDate, phoneNum);
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }
}
