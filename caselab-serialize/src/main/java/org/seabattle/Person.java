package org.seabattle;

import java.io.ObjectInputStream;
import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    private transient String job;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        job = getJob();
    }

    private void readObject(ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
        job = getJob();
    }

    public String getJob() {
        if (age >= 0 && age <= 3){
            return "at home";
        } else if (age>= 3 && age <=7){
            return "at kindergarten";
        } else if (age>= 7 && age <=18){
            return "at school";
        } else if (age>= 19 && age <=23){
            return "at university";
        } else if (age>= 24 && age <=65){
            return "at work";
        } else if (age>= 65){
            return "at pension";
        } else {
            return "unknown";
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
