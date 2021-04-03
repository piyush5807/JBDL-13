package com.company.objects;

public class User {
    private int age;
    private String name;
    private double money;

    public User(int age, String name, double money) {
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
}
