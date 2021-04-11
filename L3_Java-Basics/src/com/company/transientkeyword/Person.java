package com.company.transientkeyword;


import java.io.*;

public class Person implements Serializable {

    private int age;
    private String name;
    private static transient int number = 3;
    private transient double money;

    public Person(int age, String name, double money) {
        this.age = age;
        this.name = name;
        this.money = money;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//         Write object to a file
        Person person = new Person(10, "ABC", 12.0);
        FileOutputStream fileOutputStream = new FileOutputStream("abc.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);

        // Read from a file
        FileInputStream fileInputStream = new FileInputStream("abc.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Person person2 = (Person) objectInputStream.readObject();


        System.out.println("age = " + person2.age
                + ", name = " + person2.name
                + ", money = " + person2.money + ", number = " + Person.number);
    }

}
