package com.example.gfg.demospringbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class Utils {

    private int count;

    public Utils(){
        count = 10;
        System.out.println("Creating an object of Utils class " + this);
    }

    public void testFunc(Class cls){
        System.out.println("Invoked from class " + cls.getName() + ", this = " + this);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
