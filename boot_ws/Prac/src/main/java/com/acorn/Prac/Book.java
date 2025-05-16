package com.acorn.Prac;

import lombok.Data;

/*
BOOK_ID     NOT NULL VARCHAR2(20)
BOOK_NAME   NOT NULL VARCHAR2(20)
BOOK_AUTHOR NOT NULL VARCHAR2(20)
BOOK_GENRE  NOT NULL VARCHAR2(20)
*/

@Data
public class Book {
    String book_id;
    String book_name;
    String book_author;
    String book_genre;
    String book_image;
}
