package com.oldneighborhood.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oldneighborhood.demo.entity.Admin;
import com.oldneighborhood.demo.service.AdminService;

import net.sf.json.JSONArray;

@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/all")
	public String allAdmins() {
		JSONArray json = JSONArray.fromObject(adminService.display());
		System.out.println(json);
		return json.toString();
	}
	
	@RequestMapping("/profile")
	public String info(@RequestBody Map<String, Object> reqMap) {
		return adminService.findbyID(reqMap.get("ad_ID").toString());
	}
	
	// 创建新的管理员
	@RequestMapping("/new")
	public String newAdmin(@RequestBody Map<String, Object> reqMap) {
		Admin admin = new Admin(
				reqMap.get("ad_name").toString(), 
				reqMap.get("ad_password").toString(), 
				reqMap.get("ad_image").toString(), 
				reqMap.get("ad_permission").toString());
		return adminService.newAdmin(admin);
	}

	@RequestMapping("/modify")
	public String modifyAdmin(@RequestBody Map<String, Object> reqMap) {
		Admin admin = new Admin(
				reqMap.get("ad_name").toString(),
				reqMap.get("ad_ID").toString(),
				reqMap.get("ad_password").toString(), 
				reqMap.get("ad_image").toString(), 
				reqMap.get("ad_permission").toString());
		return adminService.modifyAdmin(admin);
	}
	
	@RequestMapping("/delete")
	public String deleteAdmin(@RequestBody Map<String, Object> reqMap) {
		return adminService.deleteAdmin(reqMap.get("ad_ID").toString());
	}

}
