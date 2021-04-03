package com.company.interfaces;

public class MyClass implements MyInterface{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.add(4, 5));
    }

}
