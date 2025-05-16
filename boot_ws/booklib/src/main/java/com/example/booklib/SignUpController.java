package com.example.booklib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SignUpController {

   @Autowired
   private SignUpRepository signUpRepository;

    public String signUp(UserDTO user) {
         try {
              int result = signUpRepository.insertUser(user);
              if (result > 0) {
                return "redirect:/login";
              } else {
                return "redirect:/signUp";
              }
         } catch (Exception e) {
              e.printStackTrace();
              return "redirect:/signUp";
         }
    }
}
