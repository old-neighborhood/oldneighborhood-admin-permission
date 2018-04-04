package com.oldneighborhood.demo.service;

import java.util.List;

import com.oldneighborhood.demo.entity.API;

public interface APIService {
	
	public String newAPI(API api);
	
	public String modifyAPI(API api);
	
	public List<API> display();

}
