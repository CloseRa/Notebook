package main.java;

import java.io.*;

public class Main {
    public static void main(String[]args){
        File persons = new File("Persons.txt");
        try {
            PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(persons, true)));
            fileWriter.write("Лол");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
