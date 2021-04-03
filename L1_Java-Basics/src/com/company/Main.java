package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        ArrayList<String> al = new ArrayList<>();
        al.add("hello");

        Thread thread = new Thread();
        thread.sleep(10);
        System.out.println(al);
    }
}
