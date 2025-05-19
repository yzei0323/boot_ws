package com.acorn.publicData.sample6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ApiExplorer2 {
    public String getDatas() throws IOException {
    	
   
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=QhQU6hPSqySfZuJvQ%2FNA8WvXbUEy1GW9tcRTtrwr86aLMuDh3mqlfZrLHuUJ38pdR2RTZL089VtEziVZQ6NI1Q%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*xml 또는 json*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호(조회 날짜로 검색 시 사용 안함)*/
        urlBuilder.append("&" + URLEncoder.encode("searchDate","UTF-8") + "=" + URLEncoder.encode("2025-05-14", "UTF-8")); /*통보시간 검색(조회 날짜 입력이 없을 경우 한달동안 예보통보 발령 날짜의 리스트 정보를 확인)*/
        urlBuilder.append("&" + URLEncoder.encode("InformCode","UTF-8") + "=" + URLEncoder.encode("PM10", "UTF-8")); /*통보코드검색(PM10, PM25, O3)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
            
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
		return sb.toString();
    }
    
    public ArrayList<DataDto> getDataList(String result) {
    	
    	
    	
    	ArrayList<DataDto> datas= new ArrayList<DataDto>();    	
    	
    	//String -> JSONObject 로 변환 
    	JSONObject obj= new JSONObject(result);
 
    	JSONObject response= obj.getJSONObject("response");   // 키로  꺼내기 
    	JSONObject body= response.getJSONObject("body");      // 키로 꺼내기 
    	JSONArray items= body.getJSONArray("items");          // 키로  jsonarray 꺼내기
    	System.out.println(items);
    	
    	for(int i=0; i <items.length(); i++) {
    		JSONObject itemJson= items.getJSONObject(i);
    		System.out.println("informGrade:"+itemJson.getString("informGrade"));
    		System.out.println("informCause.:"+itemJson.getString("informCause"));
    		System.out.println("dataTime.:"+itemJson.getString("dataTime"));
    		datas.add(new DataDto(itemJson.getString("informGrade"), itemJson.getString("informCause"), itemJson.getString("dataTime")));
    	}
    	
		return datas;
    	
    }
    
    public static void main(String[] args) {
    	ApiExplorer2 api = new ApiExplorer2();
    	try {
			ArrayList<DataDto> list = api.getDataList(api.getDatas());
			System.out.println( list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}