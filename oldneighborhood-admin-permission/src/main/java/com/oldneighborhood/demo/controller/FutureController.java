package com.oldneighborhood.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/future")
public class FutureController {
	//预测计算
	@RequestMapping("/data")
	public String futureData(@RequestBody Map<String, Object> reqMap) {
		return "";
	}


}
