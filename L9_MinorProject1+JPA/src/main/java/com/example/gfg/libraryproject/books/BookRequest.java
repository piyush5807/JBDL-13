package com.example.gfg.libraryproject.books;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@Getter
@Setter
@ToString
public class BookRequest {

    private String name;

    private String author;
    private int cost;
    private Genre genre;


    public Book createBook(){

        return Book.builder()
                .author(this.getAuthor())
                .name(this.getName())
                .genre(this.getGenre())
                .cost(this.getCost())
                .build();


    }
}
