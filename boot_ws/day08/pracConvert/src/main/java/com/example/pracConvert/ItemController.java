package com.example.pracConvert;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class ItemController {



    //컨버터 등록하기
    @InitBinder
    public void initBinder(WebDataBinder binder) {

/*
        //날짜
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

*/


    }



    @GetMapping("/item-form")
    public String  itemForm(@ModelAttribute Item item){
        return "item-form";
    }



     @PostMapping("/item")

        public String  item( @ModelAttribute Item item , BindingResult bindingResult){
         log.info( "item ={}" , item);
         log.info( "bindingResult ={}" , bindingResult);
        if( bindingResult.hasErrors()){

            return  "item-form";

        }

        return "redirect:/home";
    }




    /*

    @PostMapping("/item")
    public String  item( @ModelAttribute Item item  ){
        log.info( "item ={}" , item);
        return "redirect:/home";
    }
*/

}
