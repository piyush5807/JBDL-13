package com.company.interfaces;

import java.util.List;

public interface MyInterface {

    static int variable = 3;

    public int add(int a, int b);

    public int subtract(int a, int b);

    default int multiply(int a, int b){
        return a * b;
    }

    static int getVariable(){
        return variable;
    }
}
