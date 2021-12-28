package com.api.swagger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class userController {
	
	
	private static String resultS = "SUCCESS";	
	private static String resultF = "FAILED";
	

	@ApiOperation(value="사용자 정보", notes = "사용자 정보 리스트 조회")
	@GetMapping(value="/getUserList")
	public JSONObject getUserList() {
		
		List userList = new ArrayList();
		
		Map userInfo = new HashMap();
		userInfo.put("name", "이정원");
		userInfo.put("age", "33");
		userInfo.put("gender", "남자");
		userInfo.put("position", "대리");
		userList.add(userInfo);
		
		Map userInfo2 = new HashMap();
		userInfo2.put("name", "임규혁");
		userInfo2.put("age", "28");
		userInfo2.put("gender", "남자");
		userInfo2.put("position", "사원");
		userList.add(userInfo2);
		
		
		JSONArray jarr = new JSONArray();		
		jarr.addAll(userList);		
		
		JSONObject obj = new JSONObject();
		obj.put("total", userList.size());
		obj.put("users", jarr);
	
		return obj;
	}
	
	
	@ApiOperation(value="사용자 직책 정보", notes = "사용자 직책 정보 조회")
	@GetMapping(value="/getPosition")
	public JSONObject getPosition(@RequestParam String name) {		
		
		String inputName = name;
		JSONObject obj = new JSONObject();
		String rMsg = null;
		String result = null;
		String position = null;	
		
	    List userList = new ArrayList();
		
		Map userInfo = new HashMap();
		userInfo.put("name", "이정원");
		userInfo.put("age", "33");
		userInfo.put("gender", "남자");
		userInfo.put("position", "대리");
		userList.add(userInfo);
		
		Map userInfo2 = new HashMap();
		userInfo2.put("name", "임규혁");
		userInfo2.put("age", "28");
		userInfo2.put("gender", "남자");
		userInfo2.put("position", "사원");
		userList.add(userInfo2);
		
		if(inputName.isEmpty() || inputName == "" || inputName == null) {
			rMsg = "사용자 명을 입력해주시기 바랍니다.";
			result = resultF;
			System.out.println("사용자 명을 입력해주시기 바랍니다.");
			obj.put("msg", rMsg);
		}else {			
			for(int i=0;i<userList.size();i++) {
				Map userMap = (HashMap)userList.get(i);
				String nm = String.valueOf(userMap.get("name"));
				if(inputName.equals(nm)) {					
					position = String.valueOf(userMap.get("position"));
					obj.put("position", position);
					result = resultS;		
				}			
			}
			
			if(position == null || position.equals("")) {
				rMsg = "존재하지 않은 사용자입니다.";
				result = resultF;
				obj.put("msg", rMsg);
			}			
		
		}		
		
		obj.put("result", result);		
		return obj;
	}
}
