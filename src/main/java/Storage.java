package main.java;
/**
 * Class storage for persons.
 * @autor Vlad
 */
import main.java.Persons.Person;

import java.io.*;
import java.util.ArrayList;

public class Storage implements Serializable {

   /** Collection for storage persons */
   private ArrayList<Person> persons = new ArrayList<>();
   /**
    Specifies the file name */
   private String filename = "persons.txt";
   /** Create object file with the given name */
   private File f = new File(filename);
   /**
    * Constructor storage, performs load, if file exist.
    */
   public Storage() {
      if (f.exists()){
         Load();
      }else{
         System.out.println("File not exist");
      }
   }
   /**
    * Serialize an object and saves it to a file
    */
   public void Save(){
      try {
         FileOutputStream fos = new FileOutputStream(filename);
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         Storage storage = new Storage();
         oos.writeObject(storage);
         oos.flush();
         oos.close();
      }catch (IOException ex) {
         System.out.println(ex.getMessage());
      }
   }
   /**
    * Deserialize an object and read him.
    */
   private void Load(){
      try {
         FileInputStream fis = new FileInputStream(filename);
         ObjectInputStream ois = new ObjectInputStream(fis);
         ois.readObject();
         ois.close();
      }catch (IOException ex){
         System.out.println(ex.getMessage());
      }catch (ClassNotFoundException ex1){
         System.out.println(ex1);
      }
   }
   /**
    * Function getting an arraylist with employees.
    * @return persons
    */
   public ArrayList<Person> getPersons() {
      return persons;
   }
}
