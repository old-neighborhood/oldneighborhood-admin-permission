package com.oldneighborhood.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name="admin")
@Data
@AllArgsConstructor
public class Admin implements Serializable{
	private static final long serialVersionUID = 3345934804530920377L;
	private String ad_name;
	private String ad_ID;
	private String ad_password;
	private String ad_image;
	//管理员权限ReadOnly - ALL 
	//{"admin":"r/w", "site":"r/w", "announcement":"r/w", "forum":"r/w", "statistic":"r/w"}
	private String ad_permission;
	
	public Admin(String ad_name, String ad_password, String ad_image, String ad_permission) {
		super();
		this.ad_name = ad_name;
		this.ad_password = ad_password;
		this.ad_image = ad_image;
		this.ad_permission = ad_permission;
	}
}
