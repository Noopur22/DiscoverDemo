package com.discover.RestProvider.restcontroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.discover.RestProvider.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	List<Employee> employeeList= new ArrayList<Employee>();
	
	@PostConstruct
	public void init() {
	Employee employee1= new Employee(1, "Noopur");
	Employee employee2= new Employee(2, "Shalini");
	employeeList.add(employee1);
	employeeList.add(employee2);
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		
		
		return employeeList;
	}
	
	@PostMapping("/employees")
	public List<Employee> saveEmployees(@RequestBody List<Employee> employees){
		employeeList.addAll(employees);
		return employeeList;
	}
	
}

