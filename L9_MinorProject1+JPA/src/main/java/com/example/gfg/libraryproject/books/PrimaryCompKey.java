package com.example.gfg.libraryproject.books;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

public class PrimaryCompKey implements Serializable {

    private int id;
    private String name;

    public PrimaryCompKey(int id, String name){
        this.id = id;
        this.name = name;
    }

    public PrimaryCompKey(){

    }
}
