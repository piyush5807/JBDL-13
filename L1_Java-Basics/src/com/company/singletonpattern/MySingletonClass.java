package com.company.singletonpattern;

public class MySingletonClass{

    private static MySingletonClass singletonClass = null;

    private MySingletonClass(){

    }

    public static MySingletonClass getInstance(){

        if(singletonClass != null){
            return singletonClass;
        }
        return singletonClass = new MySingletonClass();
    }


}
