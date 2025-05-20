package com.example.uploadEx.sample;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FileItemController {

	@Autowired
	 ItemRepository dao;
	
	@Autowired
	FileManager store;
	
	@GetMapping("/uploadMulti")
	public String upload() {
		return  "sample/item-form";
	}
		

	@PostMapping("/uploadMulti")
	public String upload2(@ModelAttribute   ItemForm form, Model model)  throws IOException   {
		System.out.println( form );		
	        List<UploadFile> storeImageFiles = store.storeFiles(form.getImageFiles());	        
		    Item item = new Item();
		    item.setId( form.getItemId());
	        item.setItemName(form.getItemName());	     
	        item.setImageFiles(storeImageFiles);	       
	        dao.save(item); 	        
	        List<String> fileNames = getFileNames(storeImageFiles);	       
	        model.addAttribute("fileNames" ,fileNames); 	        
		return  "sample/upload-ok";
	}



	private List<String> getFileNames(List<UploadFile> storeImageFiles) {
		List<String> fileNames = new ArrayList<String>();
		for( UploadFile uploadFile : storeImageFiles) {
			 fileNames.add( uploadFile.getStoreFileName());
		}
		return fileNames;
	}
	
	
	
	/*
	 * Resource란?
	 * 
	 * 서버가 가진 자원을 응답할 때 사용하는 객체이다 
	 * 서버가 가진 자원을 응답하는 방법은 여러가지가 있다
	 */
	
	
	@ResponseBody	
	@RequestMapping( value="/images2/{fileName:.*}" , method=RequestMethod.GET)
	public Resource imageDownload(@PathVariable String  fileName) throws MalformedURLException {		
		System.out.println( "fileName" + fileName);
		return new  UrlResource("file:c:\\test\\upload\\"+ fileName);
		
	}
	
}
