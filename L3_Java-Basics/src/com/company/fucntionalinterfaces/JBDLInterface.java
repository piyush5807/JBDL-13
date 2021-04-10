package com.company.fucntionalinterfaces;

//@FunctionalInterface // Override
public interface JBDLInterface<D> {
    void func(D t);

    void func2(D t);

    default void func1(D t){
        System.out.println("In func1");
    }
}
