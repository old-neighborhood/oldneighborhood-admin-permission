package com.oldneighborhood.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
* @ClassName: DruidConfig  
* @Description: 配置Druid数据源
* @author user005  
* @date 2018年3月21日  
*
 */
@Configuration
@ServletComponentScan
public class DruidConfig {
	
	@Bean
	@ConfigurationProperties(prefix="druid")
	public DataSource druidSource() {
		return new DruidDataSource();
	}

}
