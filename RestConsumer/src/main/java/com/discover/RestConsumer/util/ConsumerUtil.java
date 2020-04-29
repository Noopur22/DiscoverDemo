package com.discover.RestConsumer.util;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.discover.RestConsumer.model.Employee;

@Component
public class ConsumerUtil {

	@Autowired
	private RestTemplate restTemplate;
	private HttpHeaders httpHeader;
	
	@Value("${rest.url}")
	private String url;
	
	@PostConstruct
	public void init() {
		httpHeader= new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
	}

	public List<Employee> saveEmployees(List<Employee> employees){
		
		HttpEntity<List<Employee>> httpEntity= new HttpEntity<List<Employee>>(employees,httpHeader);
		ResponseEntity employeeList=restTemplate.postForObject(url, httpEntity, ResponseEntity.class);
		
		return (List<Employee>) employeeList.getBody();
	}
	
	public List<Employee> getEmployeeList(){
		
		return null;
	}
}
