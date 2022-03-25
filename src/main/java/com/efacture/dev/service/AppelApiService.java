package com.efacture.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import java.util.Arrays;

import com.efacture.dev.model.AppelApi;
import com.efacture.dev.model.ConfigInfo;
import com.efacture.dev.model.PaieTest;

import org.springframework.http.MediaType;
@Service
public class AppelApiService {
	
	
	private RestTemplate restTemplate;
	
	ConfigInfo config;
	
	
	
	@Autowired
	public AppelApiService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

//	@Value("${spring.datasource.url}")
//	private String data;
	
//	public String saveFact( AppelApi api) {
//		HttpEntity<AppelApi> entity = new HttpEntity<>(api);
//		System.out.println(api.getCompteDebit());
//		return entity.toString();
////		return restTemplate.exchange("http://10.181.5.23:8080/ABIMicroservices/services/refTrtT24",
////				HttpMethod.POST, entity, String.class).getBody();
//	}
	
	public String saveFact( PaieTest api) {
		ConfigInfo config = null ;
		try {
			config = new ConfigInfo();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		HttpEntity<PaieTest> entity = new HttpEntity<>(api);
		System.out.println(api.getCompteDebit());
//		return entity.toString();
		return restTemplate.exchange(config.getUrlT24() + "services/refTrtT24",
				HttpMethod.POST, entity, String.class).getBody();
		
//		return restTemplate.exchange("http://10.181.5.23:8080/ABIMicroservices/services/refTrtT24",
//				HttpMethod.POST, entity, String.class).getBody();
	}


}
