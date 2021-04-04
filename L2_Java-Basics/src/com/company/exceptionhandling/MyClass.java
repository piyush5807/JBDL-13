package com.company.exceptionhandling;

import java.io.File;
import java.io.FileOutputStream;

public class MyClass {

    public static void main(String[] args) throws Exception {
//        try {
//            someFunction();
//        }catch (ArithmeticException e){
//            System.out.println("Something went wrong with numbers");
//        } catch (Exception e){
//            e.printStackTrace();
//        }

//        useCaseOfTryWithResources();
        try {
            tryWithResources();
        }catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println("After calling someFunction");
    }

    public static void someFunction() throws Exception{
        try {
            int a = 1;
        }catch (ArithmeticException e){
            System.out.println("Some error occurred");
            e.printStackTrace();
            throw e;
        }finally{
            System.out.println("In finally block");
        }
    }

    public static void useCaseOfTryWithResources() throws Exception{
        MyDriver driver;
        try {
            driver = new MyDriver();
            System.out.println(driver.getDivision(0));
        }catch (ArithmeticException e){
            System.out.println("Some error occurred");
            e.printStackTrace();
            throw e;
        }finally{
            System.out.println("In finally block");
            driver = null;
        }
    }


    public static void tryWithResources() throws Exception{

        try(MyDriver driver = new MyDriver();
            FileOutputStream fileOutputStream = new FileOutputStream("sample.txt");
        ){
            System.out.println(driver.getDivision(0));
        }catch (Exception e){
            System.out.println("Some error occurred");
            e.printStackTrace();
            throw e;
        }

//        try(FileOutputStream fileOutputStream = new FileOutputStream("sample.txt")) {
////            System.out.println(driver.getDivision(0));
//        }catch (ArithmeticException e){
//            System.out.println("Some error occurred");
//            e.printStackTrace();
//            throw e;
//        }
    }

}
