package main.java.Persons;

import java.io.Serializable;

public class Manager extends Person implements Serializable {

    private String department;

    public Manager(String name, String surname, String phoneNum, String birthDate, String department) {
        super(name, surname, phoneNum, birthDate);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
