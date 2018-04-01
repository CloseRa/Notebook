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


public class AppHandler implements Constants {

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
        try (Scanner in = new Scanner(System.in);) {
            answer = in.nextLine();
            if (answer.equals(BYSURNAME)) {
                answer = in.nextLine();
                sortPersonsBySurname();
            }
            if (answer.equals(BYBIRTHDATE)) {
                answer = in.nextLine();
                sortPersonsByBirthDate();
            }
        }
    }

    private void sortPersonsByBirthDate() {
        storage = new Storage();
        Collections.sort(storage.getPersons(), Comparator.comparing(Person::getBirthDate));
        for (Person person : storage.getPersons()) {
            showPerson(person);
        }
    }

    private void sortPersonsBySurname() {
        storage = new Storage();
        Collections.sort(storage.getPersons(), Comparator.comparing(Person::getSurname));
        for (Person person : storage.getPersons()) {
            showPerson(person);
        }
    }

    public void showPerson(Person person) {
        if (person instanceof Employee) {
            System.out.println(EMPLOYER + " " + NAME + person.getName() + ", " + SURNAME + person.getSurname()
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

        if (answer.equals(EMPLOYER)) {

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

            System.out.println(EMPLOYER + " " + NAME + name + ", " + SURNAME + surname + ", " + PHONENUMBER + phoneNum
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

        Scanner in = new Scanner(System.in);
        System.out.println(ENTERDELETE);
        String answer = in.nextLine();
        if (answer.equals(DELETE)) {
            storage.getPersons().remove(storage.getPersons().size() - 1);
        }
    }

    private void findPerson() {

        System.out.println(STARTSEARCH);
        String answer = "";
        Scanner in = new Scanner(System.in);
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
        for (Person person : storage.getPersons()) {
            if (person.getName().equals(name)) {
                showPerson(person);
            }
        }
    }

    private void findPersonBySurname(String surname) {
        for (Person person : storage.getPersons()) {
            if (person.getSurname().equals(surname)) {
                showPerson(person);
            }
        }
    }

    private void findPersonByPhoneNum(String phoneNum) {
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
