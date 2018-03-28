package main.java;

import main.java.Persons.Employer;
import main.java.Persons.Manager;
import main.java.Persons.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AppHandler {

    private List<Person> createPerson(){

        List<Person> persons = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        System.out.println("Add Employer or Manager?");
        String answer  = in.next();

        if (answer.equals("Employeer")){

            System.out.println("Enter a name: ");
            String name = in.nextLine();
            System.out.println("Enter a surname ");
            String surname = in.nextLine();
            System.out.println("Enter a date of birthday ");
            int birthDate = in.nextInt();
            System.out.println("Enter a phone number ");
            int phoneNum = in.nextInt();
            System.out.println("Enter a manager ");
            String manager = in.nextLine();

            persons.add(new Employer(name, surname, phoneNum, birthDate, manager));

            System.out.println("Employer: Name - " + name + "Surname - " + surname + "Phone number - " + phoneNum
                    + "Date of birthDay - " + birthDate + "Manager" + manager);
        }
        if (answer.equals("Manager")){
            System.out.println("Enter a name: ");
            String name = in.nextLine();
            System.out.println("Enter a surname ");
            String surname = in.nextLine();
            System.out.println("Enter a date of birthday ");
            int birthDate = in.nextInt();
            System.out.println("Enter a phone number ");
            int phoneNum = in.nextInt();
            System.out.println("Enter a department ");
            String department = in.nextLine();

            persons.add(new Manager(name, surname, phoneNum, birthDate, department));

            System.out.println("Employer: Name - " + name + "Surname - " + surname + "Phone number - " + phoneNum
                    + "Date of birthDay - " + birthDate + "Department" + department);
        }else{
            System.out.println("Wrong answer! Try again!");
        }
        return persons;
    }
}
