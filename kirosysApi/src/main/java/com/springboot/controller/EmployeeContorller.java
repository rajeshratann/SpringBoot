package com.springboot.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.EmployeeDetails;
import com.springboot.service.EmployeeService;

@RestController
public class EmployeeContorller {
	
	
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/empdetails")
	public List<EmployeeDetails> getAllDetails(){
		return employeeService.getAllEmployeeDetails();
	}
	@RequestMapping("/empdetails/{empid}")
	public EmployeeDetails getEmployeeDetails(@PathVariable String empid) {
		return employeeService.getEmployeeDetails(empid);
		
	}
	@RequestMapping(method=RequestMethod.POST, value="/empdetails")
	public void addEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
		employeeService.addEmployeeDetails(employeeDetails);
		
	}
}
