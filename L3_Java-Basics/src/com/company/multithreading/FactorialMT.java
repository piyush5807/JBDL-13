package com.company.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FactorialMT {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(45000, 34000, 23300, 56000, 10000, 45000, 70000, 40000);

        MyThreadOuter[] threadOuters = new MyThreadOuter[numbers.size()];


        long start = System.currentTimeMillis();
        IntStream.range(0, numbers.size()).forEach(i -> {

            threadOuters[i] = new MyThreadOuter(numbers.get(i));
            threadOuters[i].start();
        });

        IntStream.range(0, numbers.size()).forEach(i -> {
            try {
                threadOuters[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


//        for(int i=0;i<numbers.size();i++){
//            threadOuters[i]= new MyThreadOuter(numbers.get(i));
//            threadOuters[i].start();
//        }


        System.out.println(System.currentTimeMillis() - start);

    }

}
