package com.example.gfg.demojdbc;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    private int id;
    private String name;
    private String author;
    private int cost;

}
