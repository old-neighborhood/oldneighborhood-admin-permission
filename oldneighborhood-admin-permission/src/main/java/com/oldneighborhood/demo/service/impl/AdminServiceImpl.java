package com.oldneighborhood.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oldneighborhood.demo.dao.AdminDao;
import com.oldneighborhood.demo.entity.Admin;
import com.oldneighborhood.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;
	
	@Value("${admin.MaxAdminAmount}")
	private int MaxAdminAmount;
	
	//新建管理员有数量限制
	@Override
	@Transactional
	public String newAdmin(Admin admin) {
		if ((int)adminDao.count() <= MaxAdminAmount) {
			admin.setAd_ID(UUID.randomUUID().toString().replaceAll("-", ""));
			adminDao.save(admin);
			return "{\"result\":\"success\"}";
		}
		return "{\"result\":\"full\"}";
	}

	@Override
	@Transactional
	public String modifyAdmin(Admin admin) {
		try {
			adminDao.modifyAdmin(admin.getAd_name(), admin.getAd_password(), 
					admin.getAd_image(), admin.getAd_permission(), admin.getAd_ID());
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}

	@Override
	@Transactional
	public String deleteAdmin(String admin_ID) {
		try {
			adminDao.delete(admin_ID);
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}

	@Override
	public List<Admin> display() {
		List<Admin> admins = adminDao.findAll();
		return admins;
	}

}
