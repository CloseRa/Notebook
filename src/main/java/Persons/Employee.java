package main.java.Persons;

public class Employee extends Person {
    /** Field manager, exclusive for employee*/
    private String manager;

    /** Constructor - creating a new object with certain values
     * @param name - employee name
     * @param surname - employee surname
     * @param phoneNum - employee phone number
     * @param birthDate - emloyee birth date
     * @param manager - manager employee
     * */
    public Employee(String name, String surname, String phoneNum, String birthDate, String manager) {
        super(name, surname, phoneNum, birthDate);
        this.manager = manager;
    }
    /**
     * Function getting a manager employee.
     * @return manager
     */
    public String getManager() {
        return manager;
    }
}
