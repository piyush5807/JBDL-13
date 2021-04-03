package com.company.collections;

import java.util.*;

public class HashMapOps {

    public static void main(String[] args) {

        // Given a list of cities, you need to find the occurrence of every city present in the list

        List<String> al = Arrays.asList("Delhi", "Kolkata",
                "Mumbai", "Pune", "Mumbai", "Pune", "Delhi", "Bangalore");

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String str : al){
            if(hashMap.containsKey(str)){
                hashMap.put(str, hashMap.get(str) + 1);
            }else{
                hashMap.put(str, 1);
            }
        }

        System.out.println(hashMap);
    }
}
