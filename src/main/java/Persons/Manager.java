package main.java.Persons;
/*
  Manager class with properties.
 */

import java.io.Serializable;

public class Manager extends Person implements Serializable {
    /**
     * Field department, exclusive for manager
     */
    private String department;

    /**
     * Constructor - creating a new object with certain values
     *
     * @param name       - employee's name
     * @param surname    - manager's surname
     * @param phoneNum   - manager's phone number
     * @param birthYear  - manager's birth date
     * @param department - manager's department
     */
    public Manager(String name, String surname, String phoneNum, int birthYear, String department) {
        super(name, surname, phoneNum, birthYear);
        this.department = department;
    }

    /**
     * Function getting a department for a manger.
     *
     * @return department
     */
    public String getDepartment() {
        return department;
    }
}
