package com.springboot.model;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails {
	private String empid;
	
	private String ename;
	
	private String desination;
	
	private String address;
	
	
	public EmployeeDetails() {
	}
	
	public EmployeeDetails(String empid, String ename, String desination, String address) {
		this.empid = empid;
		this.ename = ename;
		this.desination = desination;
		this.address = address;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDesination() {
		return desination;
	}
	public void setDesination(String desination) {
		this.desination = desination;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empid=" + empid + ", ename=" + ename + ", desination=" + desination + ", address="
				+ address + "]";
	}
	
}
