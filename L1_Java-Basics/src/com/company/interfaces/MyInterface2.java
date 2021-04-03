package com.company.interfaces;

public interface MyInterface2 {

    default int multiply(int a, int b){
        System.out.println("In interface 2");
        return a * b + 2;
    }
}
