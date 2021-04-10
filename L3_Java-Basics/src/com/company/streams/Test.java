package com.company.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        // Q1. Find the first number in the array which is divisible by 6

        List<Integer> numbers = Arrays.asList(1, 2, 36, 4, 5, 6, 72, 84, 9, 10);
//        for (int n : numbers) {
//            if (n % 6 == 0) {
//                System.out.println("No found: " + n);
//                break;
//            }
//        }


        System.out.println("found no " + numbers.parallelStream()
                .filter(x -> Test.isMultipleOf6(x))
                .findFirst());

//        System.out.println("found no in sequential stream " + numbers.stream()
//                .filter(x -> Test.isMultipleOf6(x))
//                .findFirst());


    }

    public static boolean isMultipleOf6(int num){
        System.out.println("In isMultipleOf6 function for number "
                + num + ", thread = " + Thread.currentThread().getName());
        return num % 6 == 0;
    }
}
