package main.java;

import main.java.Persons.Employer;
import main.java.Persons.Manager;
import main.java.Persons.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AppHandler implements Constants {

    private ArrayList<Person> persons;

    private ArrayList<Person> createPerson() {
        try {
            persons = new ArrayList<>();

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(CHOOSE);
            String answer = in.readLine();

            if (answer.equals(EMPLOYER)) {

                System.out.println(ENTERNAME);
                String name = in.readLine();
                System.out.println(ENTERSURNAME);
                String surname = in.readLine();
                System.out.println(ENTERDATEOFBIRTHDAY);
                int birthDate = Integer.parseInt(in.readLine());
                System.out.println(ENTERPHONE);
                int phoneNum = Integer.parseInt(in.readLine());
                System.out.println(ENTERMANAGER);
                String manager = in.readLine();

                persons.add(new Employer(name, surname, phoneNum, birthDate, manager));

                System.out.println(EMPLOYER + NAME + name + SURNAME + surname + PHONENUMBER + phoneNum
                        + DATEOFBIRTHDAY + birthDate + MANAGER + manager);
            }
            if (answer.equals(MANAGER)) {
                System.out.println(ENTERNAME);
                String name = in.readLine();
                System.out.println(ENTERSURNAME);
                String surname = in.readLine();
                System.out.println(ENTERDATEOFBIRTHDAY);
                int birthDate = Integer.parseInt(in.readLine());
                System.out.println(ENTERPHONE);
                int phoneNum = Integer.parseInt(in.readLine());
                System.out.println(ENTERDEPARTMENT);
                String department = in.readLine();

                persons.add(new Manager(name, surname, phoneNum, birthDate, department));

                System.out.println(EMPLOYER + NAME + name + SURNAME + surname + PHONENUMBER + phoneNum
                        + DATEOFBIRTHDAY + birthDate + DEPARTMENT + department);

            } else {
                System.out.println(WRONGANSWER);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return persons;
    }
}
