package com.company.singletonpattern;

public class Test {

    public static void main(String[] args) {
        MySingletonClass obj1 = MySingletonClass.getInstance();
        MySingletonClass obj2 = MySingletonClass.getInstance();
        MySingletonClass obj3 = MySingletonClass.getInstance();
        MySingletonClass obj4 = MySingletonClass.getInstance();
        MySingletonClass obj5 = MySingletonClass.getInstance();
        MySingletonClass obj6 = MySingletonClass.getInstance();

        System.out.println(obj1 + " " + obj2 + " " + obj3 + " " + obj4 + " " + obj5 + " " + obj6);

    }
}
