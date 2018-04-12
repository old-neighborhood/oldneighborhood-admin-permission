package com.oldneighborhood.demo.service;

import java.util.List;

import com.mysql.jdbc.exceptions.jdbc4.MySQLDataException;
import com.oldneighborhood.demo.entity.API;

public interface APIService {
	
	public String newAPI(API api);
	
	public String modifyAPI(API api);
	
	public List<API> display();

	public API findbyName(String api_name);

	public String getURL(String api_name) throws MySQLDataException;

}
