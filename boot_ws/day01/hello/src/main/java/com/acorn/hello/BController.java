package com.acorn.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BController {



    @GetMapping("/param1")
    public String a( @RequestParam( name="paramData") String  paramData){


        System.out.println( paramData );
        return "view1";

    }


    @GetMapping("/param2")
    public String b(@RequestParam( name="paramData" ,required = false, defaultValue = "1") Integer paramData){

        System.out.println( paramData );


        return "view2";

    }
}
