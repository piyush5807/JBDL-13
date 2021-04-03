package com.company.interfaces;

public class TestClass implements Runnable, MyInterface{

    public static void main(String[] args) {

        AbstractTestClass abstractTestClass = new AbstractTestClass() {
            @Override
            public void printSomething() {
                return;
            }
        };

        abstractTestClass.printSomething2();

        MyInterface myClass = new MyClass();
//        myClass.variable = 5;

        int result = myClass.multiply(2, 3);

        System.out.println(result);

        System.out.println(MyInterface.getVariable());

//        TestClass testClass = new TestClass();
//        testClass.printSomething();
    }

    public void printSomething(){
        System.out.println("Hello World!!");
    }

    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    @Override
    public void run() {

    }
}
