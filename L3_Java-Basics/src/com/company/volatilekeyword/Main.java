package com.company.volatilekeyword;

public class Main {

    private static int var = 0;

    public static void main(String[] args) {

        new Modifier().start();
        new Listener().start();
    }

    private static class Modifier extends Thread{

        @Override
        public void run() {
            int local_value = var;
            while(var < 3){
                System.out.println("Incrementing var " + (local_value + 1));
                var = ++local_value;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Listener extends Thread{

        @Override
        public void run() {
            int local_value = var;
            while(local_value < 3){
//                System.out.println("hello");
                if(local_value != var){
                    System.out.println("The var got changed by listener thread " + var);
                    local_value = var;
                }
            }
        }
    }
}
