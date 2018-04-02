package main.java;
/**
 * Class storage for persons.
 *
 * @autor Vlad
 */

import main.java.Persons.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage implements Serializable {

    /** Collection for storage persons */
    private List<Person> persons = new ArrayList<>();
    /**
     Specifies the file name */
    private String filename = "persons.txt";
    /** Create object file with the given name */
    private File f = new File(filename);
    /**
     * Constructor storage, performs load, if file exist.*/

    public Storage() {
        if (f.exists()) {
            Load();
        } else {
            System.out.println("File not exist");
        }
    }
    /**
     * Serialize an object and saves it to a file
     */

    public void Save() {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.flush();
            oos.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Deserialize an object and read him.
     */

    private void Load() {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ois = new ObjectInputStream(fis);
            ois.readObject();

        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }catch (ClassNotFoundException ex1){
            ex1.printStackTrace();
        }finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Function getting an arraylist with employees.
     * @return persons
     */

    public List<Person> getPersons() {
        return persons;
    }
}
