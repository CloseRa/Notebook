package main.java;

import main.java.Persons.Employee;
import main.java.Persons.Manager;
import main.java.Persons.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.java.Constants.*;

public class AppHandler {

    private Storage storage;
    Scanner in = new Scanner(System.in);

    void start() {

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
        String answer = "";
        Scanner in = new Scanner(System.in);
        answer = in.nextLine();
        if (answer.equals(BYSURNAME)) {
            sortPersonsBySurname();
        }
        if (answer.equals(BYBIRTHDATE)) {
            sortPersonsByBirthDate();
        }
    }

    private void sortPersonsByBirthDate() {
        storage.getPersons().stream().sorted(Comparator.comparing(Person::getBirthDate)).forEach(this::showPerson);
    }

    private void sortPersonsBySurname() {
        storage.getPersons().stream().sorted(Comparator.comparing(Person::getSurname)).forEach(this::showPerson);
    }

    public void showPerson(Person person) {
        if (person instanceof Employee) {
            System.out.println(EMPLOYEE + " " + NAME + person.getName() + ", " + SURNAME + person.getSurname()
                    + ", " + PHONENUMBER + person.getPhoneNum() + ", " + DATEOFBIRTHDAY + person.getBirthDate()
                    + ", " + MANAGER + ": " + ((Employee) person).getManager());
        } else if (person instanceof Manager) {
            System.out.println(MANAGER + " " + NAME + person.getName() + ", " + SURNAME + person.getSurname() + ", " +
                    PHONENUMBER + person.getPhoneNum() + ", " + DATEOFBIRTHDAY + person.getBirthDate() + ", " +
                    DEPARTMENT + ": " + ((Manager) person).getDepartment());
        }
    }


    private void showAllPersons() {
        storage = new Storage();
        for (Person person : storage.getPersons()) {
            showPerson(person);
        }
    }

    private void createPerson() {

        storage = new Storage();

        System.out.println(CHOOSE);
        String answer = in.nextLine();

        if (answer.equals(EMPLOYEE)) {

            System.out.println(ENTERNAME);
            String name = in.nextLine();
            System.out.println(ENTERSURNAME);
            String surname = in.nextLine();
            System.out.println(ENTERDATEOFBIRTHDAY);
            String birthDate = in.nextLine();
            SimpleDateFormat simpleFormat2 = new SimpleDateFormat("MM/dd/yyyy");

            try {
                simpleFormat2.parse(birthDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            System.out.println(ENTERPHONE);
            String phoneNum = in.nextLine();
            System.out.println(ENTERMANAGER);
            String manager = in.nextLine();

            storage.getPersons().add(new Employee(name, surname, phoneNum, birthDate, manager));

            System.out.println(EMPLOYEE + " " + NAME + name + ", " + SURNAME + surname + ", " + PHONENUMBER + phoneNum
                    + ", " + DATEOFBIRTHDAY + birthDate + ", " + MANAGER + ": " + manager);
        }

        if (answer.equals(MANAGER)) {
            System.out.println(ENTERNAME);
            String name = in.nextLine();

            System.out.println(ENTERSURNAME);
            String surname = in.nextLine();

            System.out.println(ENTERDATEOFBIRTHDAY);
            String birthDate = in.nextLine();
            SimpleDateFormat simpleFormat2 = new SimpleDateFormat("dd/MM/yyyy");

            try {
                simpleFormat2.parse(birthDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(ENTERPHONE);
            String phoneNum = in.nextLine();

            String pattern = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(phoneNum);

            System.out.println(ENTERDEPARTMENT);
            String department = in.nextLine();

            storage.getPersons().add(new Manager(name, surname, phoneNum, birthDate, department));

            System.out.println(MANAGER + " " + NAME + name + ", " + SURNAME + surname + ", " + PHONENUMBER + phoneNum
                    + ", " + DATEOFBIRTHDAY + birthDate + ", " + DEPARTMENT + ": " + department);

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
        String answer = "";
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
