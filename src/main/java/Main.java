package main.java;

import main.java.Persons.Person;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[]args){
        try {
            File persons = new File("Persons.txt");
            PrintWriter fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(persons, true)));
            fileWriter.write("Лол");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
