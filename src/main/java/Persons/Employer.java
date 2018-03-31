package main.java.Persons;

public class Employer extends Person {

    private String manager;

    public Employer(String name, String surname, String phoneNum, String birthDate, String manager) {
        super(name, surname, phoneNum, birthDate);
        this.manager = manager;
    }

    public String getManager() {
        return manager;
    }
}
