package com.company.collections;

import java.util.ArrayList;

public class ArrayListOps {

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();

        al.add("Delhi");
        al.add("Bengal");
        al.add("Bangalore");

        System.out.println(al);

        String removedCity = al.remove(1);

        boolean isElementRemoved = al.remove("bangalore");

        System.out.println(removedCity + " " + isElementRemoved);


        ArrayList<Integer> intAl = new ArrayList<>();
        intAl.add(10);
        intAl.add(20);
        intAl.add(30);

        isElementRemoved = intAl.remove(new Integer(30));
        System.out.println(isElementRemoved);
        System.out.println(intAl);

        Integer removedElement = intAl.remove(1);
        System.out.println(removedElement + " " + isElementRemoved);
    }
}
