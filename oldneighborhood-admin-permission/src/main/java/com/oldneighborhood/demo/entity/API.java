package com.oldneighborhood.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: API  
 * @Description: TODO 
 * @author Brian  
 * @date 2018年5月22日  
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| api_ID   | char(32)    | NO   | PRI | NULL    |       |
| api_name | varchar(32) | NO   |     | NULL    |       |
| api_url  | varchar(64) | NO   |     | NULL    |       |
| api_key  | varchar(32) | NO   |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
 */


@Entity
@Table(name="api_data")
@Data
@NoArgsConstructor
public class API implements Serializable{
	private static final long serialVersionUID = 7110320250595595442L;
	@Id
	private String api_ID;
	private String api_name;
	private String api_url;
	private String api_key;
	
//	private String req_pairs;
//	private String res_pairs;
////	private String api_reqMap;
////	private String api_resMap;
	//新建api实体
	public API(String api_name, String url, String key) {
		super();
		this.api_name = api_name;
		this.api_url = url;
		this.api_key = key;
	}
	//修改API
	public API(String api_ID, String api_name, String api_url, String api_key) {
		super();
		this.api_ID = api_ID;
		this.api_name = api_name;
		this.api_url = api_url;
		this.api_key = api_key;
	}
	
}
