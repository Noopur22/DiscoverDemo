package com.discover.RestConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.discover.RestConsumer.model.Employee;
import com.discover.RestConsumer.util.ConsumerUtil;

@SpringBootApplication
public class RestConsumerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestConsumerApplication.class, args);
	}


	@Bean 
	public RestTemplate getTemplate() {
		return new RestTemplate(); 
	}

	@Autowired 
	ConsumerUtil consumerUtil;

	@Override 
	public void run(String... args) throws Exception { 
		Employee employee1= new Employee(3, "Annu"); 
		Employee employee2= new Employee(4,"Rashi"); 
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		System.out.println(consumerUtil.saveEmployees(employeeList));

	}

}
