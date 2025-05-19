package com.example.api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONTOArrayList0 {

	public static void main(String[] args) {		
		
		JSONObject  jsonitem1  = new JSONObject();
		jsonitem1.put("id", "acor1");
		jsonitem1.put("pw", "0000");

		JSONObject  jsonitem2  = new JSONObject();
		jsonitem2.put("id", "acorn2");
		jsonitem2.put("pw", "1234");

		JSONObject  jsonitem3  = new JSONObject();
		jsonitem3.put("id", "acorn3");
		jsonitem3.put("pw", "9999");

		JSONArray  jsonArray  = new JSONArray();
		jsonArray.put(jsonitem1);
		jsonArray.put(jsonitem2);
		jsonArray.put(jsonitem3);


		//
		System.out.println( jsonArray);

		//json

		ArrayList<UserDto> list  = new ArrayList<>();

		for( int  i=0 ; i< jsonArray.length(); i++){
			JSONObject item  =jsonArray.getJSONObject(i);
			/*



			 */

			String id  =item.getString("id");
			String pw = item.getString("pw");

			UserDto userDto  = new UserDto();
			userDto.setId(id);
			userDto.setPw(pw);;

			list.add(userDto);

		}


		System.out.println("변환 후 ");

		System.out.println( list);



	}

}
