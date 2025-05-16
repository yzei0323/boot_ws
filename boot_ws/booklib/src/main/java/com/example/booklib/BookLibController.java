package com.example.booklib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookLibController {
    @Autowired
    BookLibRepository libRepo;

    @RequestMapping ("/libSearch")
    public String getLibList(SearchCondition condition, Model model) throws Exception {
        List<BookLibDTO> bookLibDTOList = libRepo.getBookLibList(condition);
        model.addAttribute("libList", bookLibDTOList);
        return "index";
    }
}
