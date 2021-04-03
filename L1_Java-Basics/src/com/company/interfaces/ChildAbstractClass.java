package com.company.interfaces;

public class ChildAbstractClass extends AbstractTestClass{



    public static void main(String[] args) {
        ChildAbstractClass childAbstractClass = new ChildAbstractClass();

        childAbstractClass.printSomething();
        childAbstractClass.printSomething2();

//        AbstractTestClass abstractTestClass = new AbstractTestClass() {
//            @Override
//            public void printSomething() {
//
//            }
//        };
    }

    @Override
    public void printSomething() {

    }
}
