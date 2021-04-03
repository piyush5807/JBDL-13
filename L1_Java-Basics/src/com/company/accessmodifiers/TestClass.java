package com.company.accessmodifiers;

public class TestClass {

    private int var1; // accessible only in the current class
    int var2; // default scope (accessible only in the current package)
    protected int var3; // accessible in current package as well as in child classes outside package
    public int var4; // accessible everywhere

    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        testClass.var1 = 5;
    }
}
