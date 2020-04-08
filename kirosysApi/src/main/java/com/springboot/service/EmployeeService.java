package com.springboot.service;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.model.EmployeeDetails;

@Service
public class EmployeeService {
	
	private List<EmployeeDetails> emplist =new ArrayList<EmployeeDetails>(Arrays.asList(
	   new EmployeeDetails("10021","Rajesh", "Engineer", "Pune"),
	   new EmployeeDetails("10022","Ramesh", "Trainee", "Patna"),
	   new EmployeeDetails("10023","Mukesh", "Lecturer", "Mumbai"),
	   new EmployeeDetails("10024","Sachin", "Teacher", "Hydrabad"),
	   new EmployeeDetails("10025","Deepak", "Manager", "Chennai")
	));
	
	public List<EmployeeDetails> getAllEmployeeDetails(){
		return emplist;
	}
	
	public EmployeeDetails getEmployeeDetails(String id) {
		return emplist.stream().filter(t ->t.getEmpid().equals(id)).findFirst().get();
		
	}

	public void addEmployeeDetails(EmployeeDetails employeeDetails) {
		emplist.add(employeeDetails);
	}

}
