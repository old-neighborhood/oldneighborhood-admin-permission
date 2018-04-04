package com.oldneighborhood.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.oldneighborhood.demo.entity.API;

public interface APIDao extends JpaRepository<API, String>{
	
	@Modifying
	@Query(value = "update api_data "
					+ "set api_name = ?, api_url = ?, api_reqMap = ?, api_resMap = ? "
					+ "where api_ID = ? ", nativeQuery = true) 
	public void modifyAPI(String api_name, String api_url, String api_reqMap, String api_resMap, String api_ID);
}
