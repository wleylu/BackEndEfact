package com.efacture.dev.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ResourceUtils;

public class ConfigInfo {
	
	private String urlT24;

	public ConfigInfo() throws Exception {
		
	
		Properties info = new Properties();
		File classPathResource = ResourceUtils.getFile("classpath:config.properties");
		
		InputStream inputStream = new FileInputStream(classPathResource);
		info.load(inputStream);
				this.urlT24 = info.getProperty("url");
		
	}
	
	public String getUrlT24() {
		return urlT24;
	}
	
	
	

}
