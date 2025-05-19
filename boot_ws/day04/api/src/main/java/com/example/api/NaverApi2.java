package com.example.api;

 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;


//데이터 받아오기를 매서드로 분리하기
 
public class NaverApi2 {


    public static void main(String[] args) {
        NaverApi2   api = new NaverApi2();
        String data=api.getData();
        System.out.println( data);
        
        
        //다음단계에서는  원하는 데이터만 추출하기
    }
    public String getData( ) {
       String clientId = "QaMZOIzquZ2XCHAFDEMN"; //애플리케이션 클라이언트 아이디
       String clientSecret = "GhQcIoHq8g"; //애플리케이션 클라이언트 시크릿 
       
       String text = null; // 검색어
        try {
            text = URLEncoder.encode("bread", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }
        
        //요청 URL
         String apiURL = "https://openapi.naver.com/v1/search/shop?query=" + text;    // JSON 결과
        //  String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;  
 
        HttpURLConnection  con; //  네이버서버에 api요청시 사용
        StringBuilder body ;    // 문자열연결시 사용
        
        try {
            URL url = new URL(apiURL);
            con= (HttpURLConnection)url.openConnection();            
            con.setRequestProperty("X-Naver-Client-Id" , clientId);
            con.setRequestProperty("X-Naver-Client-Secret" , clientSecret);             
            con.setRequestMethod("GET");  
            
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
            	 InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
                 try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                    body = new StringBuilder();
                     String line;
                     while ((line = lineReader.readLine()) != null) {
                         body.append(line);
                     }                      
                 } catch (IOException e) {
                     throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
                 }
             
            } else { // 오류 발생
            	
           	 InputStreamReader streamReader = new InputStreamReader(con.getInputStream());
             try (BufferedReader lineReader = new BufferedReader(streamReader)) {
                  body = new StringBuilder();
                 String line;
                 while ((line = lineReader.readLine()) != null) {
                     body.append(line);
                 }                  
             } catch (IOException e) {
                 throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
             }                
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiURL, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiURL, e);
        }  
        
        System.out.println( body.toString());


        return body.toString();
    } 
 
    
}
