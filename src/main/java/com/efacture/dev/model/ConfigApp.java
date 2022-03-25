package com.efacture.dev.model;

import java.io.IOException;
import java.util.Properties;

public class ConfigApp {

	private final String UrlApi;

	public ConfigApp() throws Exception {
		
		Properties appConfig = new Properties();
		appConfig.load(ConfigApp.class.getClassLoader()
				.getResourceAsStream("com/efacture/dev/config/config.properties"));
		
		this.UrlApi = appConfig.getProperty("url");
		
	}

	public String getUrlApi() {
		return UrlApi;
	}
	
	
	
}
