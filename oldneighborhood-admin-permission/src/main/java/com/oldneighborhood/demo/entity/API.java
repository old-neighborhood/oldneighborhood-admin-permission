package com.oldneighborhood.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import net.sf.json.JSONObject;

@Entity
@Table(name="api_data")
@Data
public class API implements Serializable{
	private static final long serialVersionUID = 7110320250595595442L;
	@Id
	private String api_ID;
	private String api_name;
	private String api_url;
	//Map<String, Object>格式->JSON
	private String req_pairs;
	private String res_pairs;
//	private String api_reqMap;
//	private String api_resMap;
	//新建api实体
	public API(String api_name, String url, JSONObject reqMap, JSONObject resMap) {
		super();
		this.api_name = api_name;
		this.api_url = url;
		this.req_pairs = reqMap.toString();
		this.res_pairs = resMap.toString();
	}
	public API(String api_ID, String api_name, String api_url, JSONObject reqMap, JSONObject resMap) {
		super();
		this.api_ID = api_ID;
		this.api_name = api_name;
		this.api_url = api_url;
//		System.out.println(reqMap.toString());
		this.req_pairs = reqMap.toString();
		this.res_pairs = resMap.toString();
	}
	
}
