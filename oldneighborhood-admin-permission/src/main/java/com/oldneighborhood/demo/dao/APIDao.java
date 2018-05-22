package com.oldneighborhood.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.oldneighborhood.demo.entity.API;

public interface APIDao extends JpaRepository<API, String>{
	
//	@Query(value = "select api_url from api_data where api_name = ?", nativeQuery = true) 
//	public String getURL(String api_name);
	
	@Query(value = "select * from api_data where api_name = ?", nativeQuery = true) 
	public API findByName(String api_name);
	
	@Modifying
	@Query(value = "update api_data "
					+ "set api_name = ?, api_url = ?, api_key = ? "
					+ "where api_ID = ? ", nativeQuery = true) 
	public void modifyAPI(String api_name, String api_url, String api_key, String api_ID);
}
