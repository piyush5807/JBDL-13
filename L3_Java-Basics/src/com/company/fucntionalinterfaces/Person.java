package com.company.fucntionalinterfaces;

import java.util.Arrays;
import java.util.Comparator;

public class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Person[] arr = new Person[5];

        arr[0] = new Person(10, "ABC");
        arr[1] = new Person(10, "DEF");
        arr[2] = new Person(7, "XYZ");
        arr[3] = new Person(12, "GHI");
        arr[4] = new Person(11, "PQRS");

        Arrays.sort(arr, (o1, o2) -> {

            if(o1.age == o2.age){
                return o1.getName().compareTo(o2.getName());
            }

            return o1.getAge() - o2.getAge();
        });

        for(int i = 0; i < arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
