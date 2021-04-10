package com.company.multithreading;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Factorial {

    public static void main(String[] args) {

        // list - {45000, 34000, 23300, 56000, 10000, 45000, 70000, 40000}

        List<Integer> numbers = Arrays.asList(45000, 34000, 23300, 56000, 10000, 45000, 70000, 40000);

        long start = System.currentTimeMillis();
        numbers.stream()
                .map(Factorial::getFactorial)
                .forEach(System.out::println);

        System.out.println("time taken - " + (System.currentTimeMillis() - start));

    }

    public static BigInteger getFactorial(int num){

        BigInteger result = BigInteger.ONE;

        for(int i = 2; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
