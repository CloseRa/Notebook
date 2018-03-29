package main.java;

import main.java.Persons.Employer;
import main.java.Persons.Manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AppHandler implements Constants {

    private Store store;

    private BufferedReader in;

    public AppHandler(){

    }

    private Store createPerson() {
        try {
            store = new Store();
            in = new BufferedReader(new InputStreamReader(System.in));

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

                store.getPersons().add(new Employer(name, surname, phoneNum, birthDate, manager));

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

                store.getPersons().add(new Manager(name, surname, phoneNum, birthDate, department));

                System.out.println(EMPLOYER + NAME + name + SURNAME + surname + PHONENUMBER + phoneNum
                        + DATEOFBIRTHDAY + birthDate + DEPARTMENT + department);

            } else {
                System.out.println(WRONGANSWER);
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return store;
    }
    private Store deletePerson(){
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(ENTERDELETE);
            String answer = in.readLine();
            if(answer.equals(DELETE)){
                store.getPersons().remove(store.getPersons().size()-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return store;
    }
}
