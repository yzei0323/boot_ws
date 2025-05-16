package com.example.booklib;

import lombok.Data;

@Data
public class BookDTO {
    String lib_id;
    String lib_name;
    String book_id;
    String book_name;
    String book_author;
    String book_genre;
}
