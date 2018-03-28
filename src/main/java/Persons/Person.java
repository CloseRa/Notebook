package main.java.Persons;

public abstract class Person {

    private String name;
    private String surname;
    private int birthDate;
    private int phoneNum;

    public Person (String name, String surname, int birthDate, int phoneNum){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public int getPhoneNum() {
        return phoneNum;
    }
}
