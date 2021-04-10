package com.company.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Given a list of integers, you have to a new list with the squares of even nos

        // arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        // result = {4, 16, 36, 64, 100}

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> resultList = new ArrayList<>();
//        for (int n : numbers) {
//            if (n % 2 == 0) {
//                resultList.add(n * n);
//            }
//        }
//
//        System.out.println(resultList);
//


        // Rule: Non terminal functions won't be invoked if we don't have a terminal functions

        numbers.parallelStream()
                .filter(integer -> Main.isEven(integer))
                .map(integer -> Main.calculateSquare(integer))
                .forEach(x ->  System.out.println(x)); // terminal functions

//        System.out.println(numbers.stream()
//                .filter(integer -> integer % 2 == 0)
//                .mapToInt(integer -> integer * integer) // non terminal functions
//                .max().getAsInt());

    }

    public static boolean isEven(int num){
//        System.out.println("In isEven function for number " + num);
        return num % 2 == 0;
    }

    public static int calculateSquare(int num){
//        System.out.println("In caluclateSquare fucntion for num " + num);
        return num * num;
    }




}
