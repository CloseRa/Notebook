package main.java;

import main.java.Persons.Employer;
import main.java.Persons.Manager;
import main.java.Persons.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class AppHandler implements Constants {

    private Store store;

    void start() {
        showAllPersons();
        String answer = "";
        Scanner in = new Scanner(System.in);
        while (!answer.equals(EXIT)) {
            try  {

                System.out.println("If you wanna add new person, enter 'add', if you wanna find person, enter 'search'");
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sortPersons() {

    }

    private void showPerson(Person person) {
        if (person instanceof Employer) {
            System.out.println(EMPLOYER + " " + NAME + person.getName() + ", " + SURNAME + person.getSurname()
                    + ", " + PHONENUMBER + person.getPhoneNum() + ", " + DATEOFBIRTHDAY + person.getBirthDate()
                    + ", " + MANAGER + ": " + ((Employer) person).getManager());
        } else if (person instanceof Manager) {
            System.out.println(MANAGER + " " + NAME + person.getName() + ", " + SURNAME + person.getSurname() + ", " +
                    PHONENUMBER + person.getPhoneNum() + ", " + DATEOFBIRTHDAY + person.getBirthDate() + ", " +
                    DEPARTMENT + ": " + ((Manager) person).getDepartment());
        }
    }


    private void showAllPersons() {
        store = new Store();
        for (Person person : store.getPersons()) {
            showPerson(person);
        }
    }

    private void createPerson() {

        try (Scanner in = new Scanner(System.in);) {

            store = new Store();

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

                store.getPersons().add(new Employer(name, surname, phoneNum, birthDate, manager));

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
                System.out.println(ENTERDEPARTMENT);
                String department = in.nextLine();

                store.getPersons().add(new Manager(name, surname, phoneNum, birthDate, department));

                System.out.println(MANAGER + " " + NAME + name + ", " + SURNAME + surname + ", " + PHONENUMBER + phoneNum
                        + ", " + DATEOFBIRTHDAY + birthDate + ", " + DEPARTMENT + ": " + department);

            } else {
                System.out.println(WRONGANSWER);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void deletePerson() {
        try (Scanner in = new Scanner(System.in);) {
            System.out.println(ENTERDELETE);
            String answer = in.nextLine();
            if (answer.equals(DELETE)) {
                store.getPersons().remove(store.getPersons().size() - 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findPerson() {
        System.out.println(STARTSEARCH);
        String answer = "";
        try (Scanner in = new Scanner(System.in);) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void findPersonByName(String name) {
        for (Person person : store.getPersons()) {
            if (person.getName().equals(name)) {
                showPerson(person);
            }
        }
    }

    private void findPersonBySurname(String surname) {
        for (Person person : store.getPersons()) {
            if (person.getSurname().equals(surname)) {
                showPerson(person);
            }
        }
    }

    private void findPersonByPhoneNum(String phoneNum) {
        for (Person person : store.getPersons()) {
            if (person.getPhoneNum().equals(phoneNum)) {
                showPerson(person);
            }
        }
    }

    private void Exit() {
        try (Scanner in = new Scanner(System.in);) {
            System.out.println(ENTEREXIT);
            String answer = in.nextLine();
            if (answer.equals(EXIT)) {
                store.Save();
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
