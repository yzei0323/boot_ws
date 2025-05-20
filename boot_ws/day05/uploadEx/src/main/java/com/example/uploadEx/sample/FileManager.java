package com.example.uploadEx.sample;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileManager {

    
    private String fileDir="c:\\test\\upload\\";

    
    
    //전체경로 얻어오기
    public String getFullPath(String filename) {
        return fileDir + filename;
    }

    //List<MultipartFile>   ->  List<UploadFile> 
    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(saveFile(multipartFile));
            }
        }
        return storeFileResult;
    }


    //MultipartFile  = >  원본이름과 저장이름  ( UploadFile ) 만들고 , 파일업로드 함
    public UploadFile saveFile(MultipartFile multipartFile) throws IOException {

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createUUIDFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));
        return new UploadFile(originalFilename, storeFileName);
    }


    //저장파일 겹치지 않는 이름 만들기
    private String  createUUIDFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }


    //확장자 추출하기 (반환하기)
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }


}
