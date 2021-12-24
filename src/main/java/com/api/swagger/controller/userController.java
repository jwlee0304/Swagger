package com.api.swagger.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class userController {

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
		
		JSONObject obj = new JSONObject();		
		for(int i=0;i<userList.size();i++) {			
			obj.put("사용자" + (i+1), userList.get(i));		
		}
		return obj;
	}
}
