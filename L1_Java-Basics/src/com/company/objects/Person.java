package com.company.objects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Person {

    private int age;
    private String name;
    private double money;

    public Person() {
    }

    public Person(int age, String name, double money) {
        this.age = age;
        this.name = name;
        this.money = money;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Double.compare(person.money, money) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    @Override
    public int hashCode(){
        return Objects.hash(age, name, money);
    }


    // This is just a comment to test bytecode functionality

    public static void main(String[] args) {

        HashMap<Person, Boolean> peopleMap = new HashMap<>();

        HashSet<Person> peopleSet = new HashSet<>();

        Person p1 = new Person(10, "ABC", 10.0);
//        User u1 = new User(10, "ABC", 10.0);
        Person p2 = new Person(10, "ABC", 10.0);

        System.out.println(p1.equals(p2));

        peopleMap.put(p1, true);
        peopleMap.put(p2, true);

        peopleMap.get(p1);

        peopleSet.add(p1);
        peopleSet.add(p2);

        System.out.println(peopleSet);

        int hashCodep1 = p1.hashCode();
        int hashCodep2 = p2.hashCode();

        System.out.println(hashCodep1 + " " + hashCodep2);
//
        System.out.println(peopleMap);
    }
}
