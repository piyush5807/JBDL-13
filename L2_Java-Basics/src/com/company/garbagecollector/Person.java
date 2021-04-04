package com.company.garbagecollector;

public class Person {

    private String name;
    private int age;
    private Double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("I am going to be destroyed in sometime");

        System.out.println(1 / 2);

        System.out.println("After exception");
    }

    public static void main(String[] args) throws Throwable {
        someFunction();
    }

    public static void someFunction() throws Throwable {
        Person person = new Person();
        person.setAge(10);
        System.out.println(person);

//        person.finalize();
//
        person = null;
        System.gc();
    }
}
