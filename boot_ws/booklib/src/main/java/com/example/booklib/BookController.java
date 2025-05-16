package com.example.booklib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookRepository bookRepo;

    @RequestMapping ("/books")
    public String SearchForm() {
        return "index";
    }


    @RequestMapping ("/bookSearch")
    public String getLibList(SearchCondition condition, Model model) throws Exception {
        List<BookLibDTO> bookDTOList = bookRepo.getBookList(condition);
        model.addAttribute("bookList", bookDTOList);
        return "searchBooks";
    }
}
