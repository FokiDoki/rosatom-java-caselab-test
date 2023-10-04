package org.seabattle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("John", 30);
            FileOutputStream fileOutputStream = new FileOutputStream("person.out");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person);
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("person.out");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person personFromFile = (Person) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println(personFromFile.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}