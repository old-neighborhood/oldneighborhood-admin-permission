package com.oldneighborhood.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admin")
@Data
@NoArgsConstructor //不加这个会报 No default constructors for entity??
@AllArgsConstructor
public class Admin implements Serializable{
	private static final long serialVersionUID = 3345934804530920377L;
	private String ad_name;
	@Id
	private String ad_ID;
	private String ad_password;
	private String ad_image;
	//管理员权限ReadOnly - ALL 
	//{"admin":"r/w", "site":"r/w", "announcement":"r/w", "forum":"r/w", "statistic":"r/w"}
	private String ad_permission;
	
	public Admin(String ad_name, String ad_password, String ad_permission) {
		super();
		this.ad_name = ad_name;
		this.ad_password = ad_password;
		this.ad_permission = ad_permission;
	}

	public Admin(String ad_name, String ad_ID, String ad_password, String ad_permission) {
		super();
		this.ad_name = ad_name;
		this.ad_ID = ad_ID;
		this.ad_password = ad_password;
		this.ad_permission = ad_permission;
	}
}
