package com.company.interfaces;

public abstract class AbstractTestClass {

    private static int variable = 5;

    public abstract void printSomething();

    public void printSomething2(){
        System.out.println("In abstract class, printSomething2 function");
    }

    public static int getVariable(){
        return variable;
    }

    // 1. In interfaces, all the variables are public and final but similar is not the case with abstract classes
    // 2. We can define private and protected methods in abstract class
    // 3. We cannot extend from multiple abstract classes but we can implement multiple interfaces



}
