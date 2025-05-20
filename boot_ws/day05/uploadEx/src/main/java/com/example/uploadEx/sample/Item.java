package com.example.uploadEx.sample;

import lombok.Data;

import java.util.List;


//DTO

@Data
public class Item {

    private Long id;
    private String itemName;  
    private List<UploadFile> imageFiles;

    
}
