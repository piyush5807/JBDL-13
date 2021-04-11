package com.company.synchronizedkeyword;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        BankObject bankObject1 = new BankObject(1, 300);
        BankObject bankObject2 = new BankObject(2, 500);

        MyThread[]threads = new MyThread[6];

        threads[0] = new MyThread(bankObject1, 100, true);
        threads[1] = new MyThread(bankObject1, 200, false);
        threads[2] = new MyThread(bankObject1, 150, true);

        // 300 + 100 - 200 + 150 = 350


        threads[3] = new MyThread(bankObject2, 250, false);
        threads[4] = new MyThread(bankObject2, 100, true);
        threads[5] = new MyThread(bankObject2, 300, false);

        // 500 - 250 + 100 - 300 = 50

        Arrays.stream(threads).forEach(MyThread::start);

        Arrays.stream(threads).forEach(x -> {
            try {
                x.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(bankObject1);
        System.out.println(bankObject2);


    }

    private static class MyThread extends Thread{

        private BankObject bankObject;
        private int amount;
        private boolean isDeposit;

        public MyThread(BankObject bankObject, int amount, boolean isDeposit) {
            this.bankObject = bankObject;
            this.amount = amount;
            this.isDeposit = isDeposit;
        }

        @Override
        public void run() {
            if(this.isDeposit){
                deposit();
            }else{
                withdraw();
            }

        }

        public void deposit() {
            synchronized (this.bankObject) {
                System.out.println("In deposit function of thread - " + currentThread().getName() +
                        ", bankobject is " + this.bankObject);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.bankObject.setAmount(this.bankObject.getAmount() + this.amount);
            }
        }

        public void withdraw() {
            synchronized (this.bankObject) { // synchronized block
            System.out.println("In withdraw function of thread - " + currentThread().getName() +
                    ", bankobject is " + this.bankObject);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.bankObject.setAmount(this.bankObject.getAmount() - this.amount);
        }
    }
}}
