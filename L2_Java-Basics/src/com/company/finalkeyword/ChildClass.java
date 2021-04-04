package com.company.finalkeyword;

public class ChildClass extends ParentClass{

    // 1. variables - (at the time of declaration or in constructor)
    // 2. functions - (you cannot override final functions )
    // 3. class - (you cannot extend final class)

    private int a;


    ChildClass(){
        super(6);
    }

    public void function(){
        System.out.println("Hello from Child Class");
    }

    @Override
    public void printSomething() {
        System.out.println("In printSomething of childClass");
        super.printSomething();
    }

    public static void main(String[] args) {

        ChildClass childClass = new ChildClass();
        childClass.printSomething();
    }
}
