package main.java;

import main.java.Persons.Employee;
import main.java.Persons.Manager;
import main.java.Persons.Person;

import java.util.Comparator;
import java.util.Scanner;

import static main.java.Constants.*;

public class AppHandler {

    private Storage storage;
    private Scanner in = new Scanner(System.in);

    void start() {

        storage = new Storage();

        showAllPersons();
        String answer = "";

        while (!answer.equals(EXIT)) {

            System.out.println(STARTMESSAGE);
            answer = in.nextLine();

            if (answer.equals(ADDPERSON)) {
                createPerson();
            }
            if (answer.equals(EXIT)) {
                Exit();
            }
            if (answer.equals(DELETE)) {
                deletePerson();
            }
            if (answer.equals(SEARCH)) {
                findPerson();
            }
            if (answer.equals(SORT)) {
                sortPersons();
            }
        }
    }

    private void sortPersons() {
        System.out.println(ENTERSORT);
        String answer;
        Scanner in = new Scanner(System.in);
        answer = in.nextLine();
        if (answer.equals(BYSURNAME)) {
            sortPersonsBySurname();
        }
        if (answer.equals(BYBIRTHYEAR)) {
            sortPersonsByBirthYear();
        }
    }

    private void sortPersonsByBirthYear() {
        storage.getPersons().stream().sorted(Comparator.comparing(Person::getBirthYear)).forEach(this::showPerson);
    }

    private void sortPersonsBySurname() {
        storage.getPersons().stream().sorted(Comparator.comparing(Person::getSurname)).forEach(this::showPerson);
    }

    private void showPerson(Person person) {
        if (person instanceof Employee) {
            System.out.println(EMPLOYEE + " " + NAME + person.getName() + ", " + SURNAME + person.getSurname()
                    + ", " + PHONENUMBER + person.getPhoneNum() + ", " + BIRTHYEAR + person.getBirthYear()
                    + ", " + MANAGER + ": " + ((Employee) person).getManager());
        } else if (person instanceof Manager) {
            System.out.println(MANAGER + " " + NAME + person.getName() + ", " + SURNAME + person.getSurname() + ", " +
                    PHONENUMBER + person.getPhoneNum() + ", " + BIRTHYEAR + person.getBirthYear() + ", " +
                    DEPARTMENT + ": " + ((Manager) person).getDepartment());
        }
    }

    private void showAllPersons() {
        for (Person person : storage.getPersons()) {
            showPerson(person);
        }
    }

    private void createPerson() {

        System.out.println(CHOOSE);
        String answer = in.nextLine();

        System.out.println(ENTERNAME);
        String name = in.nextLine();

        System.out.println(ENTERSURNAME);
        String surname = in.nextLine();

        System.out.println(ENTERBIRTHYEAR);
        int birthDate = Integer.parseInt(in.nextLine());

        System.out.println(ENTERPHONE);
        String phoneNum = in.nextLine();

        while (!phoneNum.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            System.out.println("Sorry, try one more time");
            phoneNum = in.nextLine();
        }
        if (answer.equals(EMPLOYEE)) {
            System.out.println(ENTERMANAGER);
            String manager = in.nextLine();

            storage.getPersons().add(new Employee(name, surname, phoneNum, birthDate, manager));

            showAllPersons();
        } else {

            System.out.println(ENTERDEPARTMENT);
            String department = in.nextLine();

            storage.getPersons().add(new Manager(name, surname, phoneNum, birthDate, department));

            showAllPersons();

        }
    }

    private void deletePerson() {

        in = new Scanner(System.in);
        System.out.println(ENTERDELETE);
        String answer = in.nextLine();
        if (answer.equals(DELETE)) {
            storage.getPersons().remove(storage.getPersons().size() - 1);
        }
    }

    private void findPerson() {

        System.out.println(STARTSEARCH);
        String answer;
        in = new Scanner(System.in);
        answer = in.nextLine();
        if (answer.equals(BYNAME)) {
            answer = in.nextLine();
            findPersonByName(answer);
        }
        if (answer.equals(BYSURNAME)) {
            answer = in.nextLine();
            findPersonBySurname(answer);
        }
        if (answer.equals(BYPHONENUM)) {
            answer = in.nextLine();
            findPersonByPhoneNum(answer);
        }
    }

    private void findPersonByName(String name) {
        System.out.println(ENTERNAME);
        for (Person person : storage.getPersons()) {
            if (person.getName().equals(name)) {
                showPerson(person);
            }
        }
    }

    private void findPersonBySurname(String surname) {
        System.out.println(ENTERSURNAME);
        for (Person person : storage.getPersons()) {
            if (person.getSurname().equals(surname)) {
                showPerson(person);
            }
        }
    }

    private void findPersonByPhoneNum(String phoneNum) {
        System.out.println(ENTERPHONE);
        for (Person person : storage.getPersons()) {
            if (person.getPhoneNum().equals(phoneNum)) {
                showPerson(person);
            }
        }
    }

    private void Exit() {
        storage.Save();
        System.exit(0);
    }
}
