package com.company.multithreading;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread() + " " + (5*5));

        MyThread[] threads = new MyThread[5];

        Arrays.stream(threads).forEach(x -> {
//            MyThread2 thread = new MyThread2();
            Thread thread = new Thread(new MyThread2());
            thread.start();
        });

//        Thread.sleep(1000);

//        System.out.println("In main function " + thread);
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am in thread - " + currentThread());
            System.out.println(5 * 7);
        }
    }

    private static class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("I am in thread - " + Thread.currentThread());
            System.out.println(5 * 7);
        }
    }
}

























