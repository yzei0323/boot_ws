package com.acorn.Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    /*
    public List<Book> getSearchBook(List<String> bookId){
        return repository.selectSearch(bookId);
    }
*/

    public List<Book> getSearchBook(SearchCondition search){
        return repository.selectBookSearch(search);
    }

}
