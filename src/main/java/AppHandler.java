package main.java;

import main.java.Persons.Employee;
import main.java.Persons.Manager;
import main.java.Persons.Person;

import java.util.Comparator;
import java.util.Scanner;

import static main.java.Constants.*;

/**
 * The class is a handler.
 *
 * @autor Vlad
 */
public class AppHandler {

    private Notebook notebook;

    private Scanner in = new Scanner(System.in);

    /**
     * Runs main method and processes user commands.
     */
    void start() {

        notebook = new Notebook();

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

    /**
     * Asks to select an option, how to sort persons.
     */
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

    /**
     * Sorts persons by their birth years
     */
    private void sortPersonsByBirthYear() {
        notebook.getPersons().stream().sorted(Comparator.comparing(Person::getBirthYear)).forEach(this::showPerson);
    }

    /**
     * Sorts persons by their surnames
     */
    private void sortPersonsBySurname() {
        notebook.getPersons().stream().sorted(Comparator.comparing(Person::getSurname)).forEach(this::showPerson);
    }

    /**
     * Checks which instance of an object, employee or manager and prints message about them
     */
    private void showPerson(Person person) {
        if (person instanceof Employee) {
            System.out.println(NAME + person.getName() + ", " + SURNAME + person.getSurname()
                    + ", " + PHONENUMBER + person.getPhoneNum() + ", " + BIRTHYEAR + person.getBirthYear()
                    + ", " + MANAGER + ": " + ((Employee) person).getManager());
        } else if (person instanceof Manager) {
            System.out.println(NAME + person.getName() + ", " + SURNAME + person.getSurname() + ", " +
                    PHONENUMBER + person.getPhoneNum() + ", " + BIRTHYEAR + person.getBirthYear() + ", " +
                    DEPARTMENT + ": " + ((Manager) person).getDepartment());
        }
    }

    /**
     * Iterates collection persons and calls the method showPerson
     */
    private void showAllPersons() {
        for (Person person : notebook.getPersons()) {
            showPerson(person);
        }
    }

    /**
     * Reads information from user and create person based on data
     */
    private void createPerson() {

        System.out.println(CHOOSE);
        String answer = in.nextLine();

        System.out.println(ENTERNAME);
        String name = in.nextLine();

        System.out.println(ENTERSURNAME);
        String surname = in.nextLine();

        System.out.println(ENTERBIRTHYEAR);
        
        int birthDate = Integer.parseInt(in.nextLine());
        while (birthDate < 1930 || birthDate > 2018) {
            System.out.println(INPUTERROR);
            birthDate = Integer.parseInt(in.nextLine());
        }

        System.out.println(ENTERPHONE);
        String phoneNum = in.nextLine();

        while (!phoneNum.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            System.out.println(INPUTERROR);
            phoneNum = in.nextLine();
        }
        if (answer.equals(EMPLOYEE)) {
            System.out.println(ENTERMANAGER);
            String manager = in.nextLine();

            notebook.getPersons().add(new Employee(name, surname, phoneNum, birthDate, manager));

            showAllPersons();
        } else {

            System.out.println(ENTERDEPARTMENT);
            String department = in.nextLine();

            notebook.getPersons().add(new Manager(name, surname, phoneNum, birthDate, department));

            showAllPersons();

        }
    }

    /**
     * Deletes last added persons from collection
     */
    private void deletePerson() {
        while (!notebook.getPersons().isEmpty()) {
            in = new Scanner(System.in);
            System.out.println(ENTERDELETE);
            String answer = in.nextLine();
            if (answer.equals(DELETE)) {
                notebook.getPersons().remove(notebook.getPersons().size() - 1);
            }
        }
    }

    /**
     * Asks to select an option, how to find persons.
     */
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

    /**
     * Finds persons by their names
     */
    private void findPersonByName(String name) {
        System.out.println(ENTERNAME);
        for (Person person : notebook.getPersons()) {
            if (person.getName().equals(name)) {
                showPerson(person);
            }
        }
    }

    /**
     * Finds persons by their surnames
     */
    private void findPersonBySurname(String surname) {
        System.out.println(ENTERSURNAME);
        for (Person person : notebook.getPersons()) {
            if (person.getSurname().equals(surname)) {
                showPerson(person);
            }
        }
    }

    /**
     * Finds persons by their phone bumbers
     */
    private void findPersonByPhoneNum(String phoneNum) {
        System.out.println(ENTERPHONE);
        for (Person person : notebook.getPersons()) {
            if (person.getPhoneNum().equals(phoneNum)) {
                showPerson(person);
            }
        }
    }

    /**
     * Exits from programm, and saves all added persons
     */
    private void Exit() {
        notebook.Save();
        System.exit(0);
    }
}
