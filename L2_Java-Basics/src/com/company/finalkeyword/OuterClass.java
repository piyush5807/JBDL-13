package com.company.finalkeyword;

public class OuterClass {

    public static void main(String[] args) {
        InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.printSomething();
    }

    private class InnerClass{

        public void printSomething(){

        }
    }
}
