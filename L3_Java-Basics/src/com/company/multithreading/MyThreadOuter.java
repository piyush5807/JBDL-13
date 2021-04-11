package com.company.multithreading;

import java.math.BigInteger;

public class MyThreadOuter extends Thread{

    int num;
    BigInteger result;

    MyThreadOuter(int num){
        this.num = num;
        this.result = BigInteger.TWO;
    }

    @Override
    public void run() {
        this.result = getFactorial(this.num);
//        System.out.println("for num " + this.num + " result = " + getFactorial(this.num));
    }

    public BigInteger getFactorial(int num){
        System.out.println(currentThread().getName());
        BigInteger result = BigInteger.ONE;

        for(int i = 3; i <= num; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
