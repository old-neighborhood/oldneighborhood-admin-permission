package com.oldneighborhood.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oldneighborhood.demo.entity.API;
import com.oldneighborhood.demo.service.APIService;

import net.sf.json.JSONArray;
/**
 * @ClassName: APIController  
 * @Description: 只有新建和修改两个选择 
 * @author user005  
 * @date 2018年4月4日  
 */
@RequestMapping("/api")
public class APIController {
	
	@Autowired
	private APIService apiService;
	
	@RequestMapping("/all")
	public String allAPIs() {
		JSONArray json = JSONArray.fromObject(apiService.display());
		System.out.println(json);
		return json.toString();
	}
	
	// 创建新的API接口
	@RequestMapping("/new")
	public String newAPI(@RequestBody Map<String, Object> reqMap) {
		API api = new API(
				reqMap.get("api_name").toString(), 
				reqMap.get("api_url").toString(), 
				reqMap.get("request").toString(), 
				reqMap.get("response").toString());
		return apiService.newAPI(api);
	}

	@RequestMapping("/modify")
	public String modifyAPI(@RequestBody Map<String, Object> reqMap) {
		API api = new API(
				reqMap.get("api_ID").toString(),
				reqMap.get("api_name").toString(), 
				reqMap.get("api_url").toString(), 
				reqMap.get("request").toString(), 
				reqMap.get("response").toString());
		return apiService.modifyAPI(api);
	}

}
