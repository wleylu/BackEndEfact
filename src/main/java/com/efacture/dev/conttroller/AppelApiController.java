package com.efacture.dev.conttroller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.efacture.dev.model.AppelApi;
import com.efacture.dev.model.PaieTest;
import com.efacture.dev.service.AppelApiService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Api")
public class AppelApiController {

	@Autowired
	private AppelApiService apiService;
	
	private RestTemplate restTemplate;
	
	
	@Autowired
	public AppelApiController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}


	@PostMapping("/pay")
	public String saveFacture(@RequestBody PaieTest api) {
		return apiService.saveFact(api);
	}
	
	
//	@Value("${spring.datasource.url}")
//	private String data;
//	
	
	@RequestMapping(value = "/facture/{identifiant}")
	public String getFactureList(@PathVariable String identifiant) {
	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	HttpEntity <String> entity = new HttpEntity<String>(headers);

	return restTemplate.exchange("http://10.181.5.23:8080/ABIMicroservices/serviceNMPF/getfacturecie/"+identifiant, HttpMethod.GET, entity, String.class).getBody();
	}
}
