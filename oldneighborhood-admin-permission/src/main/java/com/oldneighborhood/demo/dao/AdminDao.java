package com.oldneighborhood.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.oldneighborhood.demo.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, String>{

	
	@Modifying
	@Query(value = "update admin "
					+ "set ad_name = ?, ad_password = ?, ad_permission = ? "
					+ "where ad_ID = ? ", nativeQuery = true) 
	public void modifyAdmin(String ad_name, String ad_password, String ad_permission, String ad_ID);

}
