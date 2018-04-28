package com.oldneighborhood.demo.entity;

import java.io.Serializable;

public class KeyPair implements Serializable{
	private static final long serialVersionUID = 6980887877365047153L;
	
	private String keyname;
	private String keyvalue;
	
	public KeyPair(String keyname, String keyvalue) {
		super();
		this.keyname = keyname;
		this.keyvalue = keyvalue;
	}

	public String getKeyname() {
		return keyname;
	}

	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}

	public String getKeyvalue() {
		return keyvalue;
	}

	public void setKeyvalue(String keyvalue) {
		this.keyvalue = keyvalue;
	}

	@Override
	public String toString() {
		return "KeyPair [keyname=" + keyname + ", keyvalue=" + keyvalue + "]";
	}
	
}
