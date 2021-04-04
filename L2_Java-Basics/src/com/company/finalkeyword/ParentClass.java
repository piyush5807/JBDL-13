package com.company.finalkeyword;

public class ParentClass {

    public ParentClass(int a) {
        System.out.println("In Constructor of ParentClass");
    }

    public final void function(int id){
        System.out.println("Hello!!" + id);
    }

    public final void function(String name){
        System.out.println("Hello!! from 2nd function " + name);
    }

    public void printSomething(){
        System.out.println("In printSomething function of ParentClass");
    }

    public static void main(String[] args) {
//        ParentClass parentClass = new ParentClass();
//        parentClass.function(1);
//        parentClass.function("ABC");
    }
}
