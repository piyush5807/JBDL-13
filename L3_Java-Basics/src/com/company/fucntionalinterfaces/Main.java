package com.company.fucntionalinterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Consumer<String> consumer = s -> {
            System.out.println("Hello!!" + s);
            System.out.println("Bye !!" + s);
        };

        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + "!!!");
            }
        };

        Runnable runnable = () -> System.out.println("Hello");

        runnable.run();

        consumer.accept("ABC");
//        consumer.andThen(consumer1)
//        consumer1.accept("hello");


        Function<String, Integer> converttoInteger = (str) -> Integer.parseInt(str);

//        System.out.println(converttoInteger.apply("hi"));

        Function<String, String> toLowerCase = (str) -> str.toLowerCase();

        System.out.println(toLowerCase.apply("Piyush"));


//        JBDLInterface<String> jbdlInterface = new JBDLInterface<String>() {
//            @Override
//            public void func(String s) {
//                System.out.println("Hello " + s);
//            }
//        };
//
//        jbdlInterface.func("John");

//        JBDLInterface<String> jbdlInterface = (s) -> System.out.println(s);
//
//        jbdlInterface.func("John");

    }


}
