package main.java.Persons;

/**
 * Employee class with properties.
 *
 */
public class Employee extends Person {
    /**
     * Field manager, exclusive for employee
     */
    private String manager;

    /**
     * Constructor - creating a new object with certain values
     *
     * @param name      - employee's name
     * @param surname   - employee's surname
     * @param phoneNum  - employee's phone number
     * @param birthYear - emloyee's birth date
     * @param manager   - employee's manager
     */
    public Employee(String name, String surname, String phoneNum, int birthYear, String manager) {
        super(name, surname, phoneNum, birthYear);
        this.manager = manager;
    }

    /**
     * Function getting a manager for a employee.
     *
     * @return manager
     */
    public String getManager() {
        return manager;
    }
}
