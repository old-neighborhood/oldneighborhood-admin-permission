package com.oldneighborhood.demo.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;
import com.oldneighborhood.demo.dao.APIDao;
import com.oldneighborhood.demo.entity.API;
import com.oldneighborhood.demo.service.APIService;

@Service
public class APIServiceImpl implements APIService{

	@Autowired
	private APIDao apiDao;
	
	@Override
	@Transactional
	public String newAPI(API api) {
		api.setApi_ID(UUID.randomUUID().toString().replaceAll("-", ""));
		try {
			apiDao.save(api);
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}

	@Override
	@Transactional
	public String modifyAPI(API api) {
		try {
			apiDao.modifyAPI(api.getApi_name(), api.getApi_url(),
					api.getApi_reqMap().toString(), api.getApi_resMap().toString(), api.getApi_ID());
			return "{\"result\":\"success\"}";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\"error\"}";
	}

	@Override
	public List<API> display() {
		List<API> apis = apiDao.findAll();
		return apis;
	}
	
	@Override
	public String getURL(String api_name) throws MySQLDataException{
		return apiDao.getURL(api_name);
	}

	@Override
	public API findbyName(String api_name) {
		return apiDao.findByName(api_name);
	}

}
