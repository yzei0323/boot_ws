package com.example.uploadPrac;


import org.apache.tomcat.util.file.ConfigurationSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;

@Controller
public class UploadController {


    @GetMapping("/uploadForm")
    public  String uplaodForm(){
        return "uploadForm";
    }



    @PostMapping("/form")
    public  String uplaod(@RequestParam(name="name") String name,
                          @RequestParam(name="multipartFile"  ) MultipartFile  multipartFile  , Model model){


        String path ="c:\\test\\upload\\";

        //원본이름
        String fileName  = multipartFile.getOriginalFilename();
          //  저장이름  UUID
        String uuid = UUID.randomUUID().toString();
        //  원본파일의 확장자 추출하기
        int pos = fileName.lastIndexOf(".");
        String  ext  = fileName.substring(pos + 1);

        String saveFileName = uuid+"." + ext;
        System.out.println( saveFileName);


        try {
            multipartFile.transferTo( new File(path+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("fileName", fileName);
        return "uploadok";
    }


    //
    @GetMapping("/images/{fileName:.*}")
    public ResponseEntity<Resource> image(@PathVariable( name="fileName") String fileName) throws MalformedURLException {
        Resource resource  = new UrlResource("file:c:\\test\\upload\\" + fileName);
        return  ResponseEntity.ok().body(resource);
    }



    /*
    @ResponseBody
    @GetMapping("/images/{fileName:.*}")
    public  Resource image(@PathVariable( name="fileName") String fileName) throws MalformedURLException {
        Resource resource  = new UrlResource("file:c:\\test\\upload\\" + fileName);
        return  resource;
    }
    */



}
