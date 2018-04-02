package main.java.Persons;

import java.io.Serializable;

public abstract class Person implements Serializable {
    /** Field name*/
    private String name;
    /** Field surname*/
    private String surname;
    /** Field birth date*/
    private int birthDate;
    /** Field phone number*/
    private String phoneNum;
    /** Constructor - creating a new object with certain values
     * @param name - person's name
     * @param surname - person's surname
     * @param phoneNum - person's phone number
     * @param birthYear - person's birth date
     * */
    public Person (String name, String surname, String phoneNum, int birthYear){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthYear;
        this.phoneNum = phoneNum;
    }
    /**
     * Function getting a  person's name.
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Function getting a person's surname.
     * @return surname
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Function getting a  person's birth date.
     * @return birthDate
     */
    public int getBirthYear() {
        return birthDate;
    }
    /**
     * Function getting a person's phone number.
     * @return phoneNum
     */
    public String getPhoneNum() {
        return phoneNum;
    }
}
