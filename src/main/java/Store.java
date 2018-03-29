package main.java;

import main.java.Persons.Person;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {

   private ArrayList<Person> persons = new ArrayList<>();

   public Store() {
   }

   public ArrayList<Person> getPersons() {
      return persons;
   }


}
