package main.java.Persons;

public abstract class Person {

    private String name;
    private String surname;
    private String birthDate;
    private String phoneNum;

    public Person (String name, String surname, String phoneNum, String birthDate){
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

    public String getBirthDate() {
        return birthDate;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
}
