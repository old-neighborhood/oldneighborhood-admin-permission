package com.oldneighborhood.demo.service;

import java.util.List;

import com.oldneighborhood.demo.entity.Admin;

public interface AdminService {
	public List<Admin> display();
	
	public String newAdmin(Admin admin);
	
	public String modifyAdmin(Admin admin);
	
	public String deleteAdmin(String admin_ID);

	public Admin findbyID(String ad_ID);

}
