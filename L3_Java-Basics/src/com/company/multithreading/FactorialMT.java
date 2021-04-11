package com.company.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FactorialMT {

    public static void main(String[] args) {

        // Thrashing - thread is context switched a lot that it cannot perform the basic operation

        List<Integer> numbers = Arrays.asList(45000, 34000, 23300, 560000, 100000, 45000, 700000, 40000);

        MyThreadOuter[] threadOuters = new MyThreadOuter[numbers.size()];


        long start = System.currentTimeMillis();
        IntStream.range(0, numbers.size()).forEach(i -> {

            threadOuters[i] = new MyThreadOuter(numbers.get(i));
            threadOuters[i].start();
        });

        Arrays.stream(threadOuters).forEach(x -> {
            try {
                x.join();
                System.out.println("for number - " + x.num + ", the result is " + x.result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        Arrays.stream(threadOuters).forEach(x -> {
//            System.out.println("for number - " + x.num + ", the result is " + x.result);
//        });

//        IntStream.range(0, numbers.size()).forEach(i -> {
//            try {
//                threadOuters[i].join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });


//        for(int i=0;i<numbers.size();i++){
//            threadOuters[i]= new MyThreadOuter(numbers.get(i));
//            threadOuters[i].start();
//        }


        System.out.println(System.currentTimeMillis() - start);

    }

}
