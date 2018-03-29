package main.java;

import main.java.Persons.Person;

import java.io.*;
import java.util.ArrayList;

public class Store implements Serializable {

   private ArrayList<Person> persons = new ArrayList<>();
   private String filename = "persons.dat";

   public Store() {
   }
   public void Save(){
      try {
         FileOutputStream fos = new FileOutputStream(filename);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         Store store = new Store();
         oos.writeObject(store);
         oos.flush();
         oos.close();
      }catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
   }
   public void Load(){
      try {
         FileInputStream fis = new FileInputStream(filename);
         ObjectInputStream ois = new ObjectInputStream(fis);
         Store store = (Store) ois.readObject();
         ois.close();
      }catch (IOException ex){
         System.out.println(ex.getMessage());
      }catch (ClassNotFoundException ex1){
         System.out.println(ex1);
      }
   }

   public ArrayList<Person> getPersons() {
      return persons;
   }
}
