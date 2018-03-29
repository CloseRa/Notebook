package main.java;

import main.java.Persons.Store;

import java.io.*;

public class Main {
    public static void main(String[]args) throws IOException, ClassNotFoundException {
        AppHandler handler = new AppHandler();

        FileOutputStream   fos = new FileOutputStream("persons.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        FileInputStream fis = new FileInputStream("persons.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);


        Store store = (Store)ois.readObject();
        oos.writeObject(store);
        ois.close();
        oos.close();

    }
}
