package com.kirosys.service;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kirosys.model.Student;

@Service
public class StudentService {
	
	private List<Student> emplist =new ArrayList<Student>(Arrays.asList(
	   new Student("10021","Rajesh", "rajeshkumar@gmail.com", "9903943730"),
	   new Student("10022","Ramesh", "rameshkumar@gmail.com", "9945943730"),
	   new Student("10023","Mukesh", "mukeshkumar@gmail.com", "9904643730"),
	   new Student("10024","Sachin", "sachinkumar@gmail.com", "8298866066"),
	   new Student("10025","Deepak", "deepakkumar@gmail.com", "9906948595")
	));
	
	public List<Student> getAllEmployeeDetails(){
		return emplist;
	}
	
	public Student getEmployeeDetails(String id) {
		return emplist.stream().filter(t ->t.getId().equals(id)).findFirst().get();
		
	}

	public void addEmployeeDetails(Student student) {
		emplist.add(student);
	}

	public void delete(Student student) {
        		
	}

}
