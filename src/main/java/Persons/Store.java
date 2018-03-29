package main.java.Persons;

import java.io.Serializable;
import java.util.ArrayList;

public class Store implements Serializable {

   private Store store;
   private ArrayList<Person> persons = new ArrayList<>();


   public ArrayList<Person> getPersons() {
      return persons;
   }

   public Store() {

      store = new Store();


   }

}
