package com.company.exceptionhandling;

import java.io.Closeable;

public class MyDriver implements AutoCloseable {

    private String connectionString;

    private MyDriver driver;

    MyDriver(){
        this.driver = new MyDriver();
    }

    public int getDivision(int num){
        return 100 / num;
//        return connectionString = "jdbc:mysql://localhost:3306/db";
    }

    @Override
    public void close() throws Exception {
     this.driver = null;
    }
}
