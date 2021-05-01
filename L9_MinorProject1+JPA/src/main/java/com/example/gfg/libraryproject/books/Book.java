package com.example.gfg.libraryproject.books;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "my_book")
@Builder
//@IdClass(PrimaryCompKey.class)
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Id
    private String name;

    private String author;
    private int cost;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    public Book(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
