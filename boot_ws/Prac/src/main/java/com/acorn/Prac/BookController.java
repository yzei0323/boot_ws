package com.acorn.Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService service;

/*
    @GetMapping("/bookSearch")
    public String searchBook(@RequestParam(name="bookId")List<String> bookId, Model model){
        System.out.println(bookId);

        List<Book> list = service.getSearchBook(bookId);

        model.addAttribute("list", list);

        return "bookList";
    }
*/


    @GetMapping("/book")
    public String searchBook(@ModelAttribute SearchCondition search, Model model){
        System.out.println(search);

        List<Book> list = service.getSearchBook(search);

        model.addAttribute("list", list);

        return "bookList2";
    }
}
