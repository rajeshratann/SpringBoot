package com.kirosys.model;



public class Student {
  
    private String id;
    
    private String name;
    
    private String email;

    private String phoneNo;
    
   

    public Student(String id, String name, String email, String phoneNo) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}



	public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}