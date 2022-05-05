package com.crud.restapi.dao;

public class Student {
	private int id;
	private String name;
	private int age;
	private String emailId;
	private String branch;
	
	public Student(){
		super();
	}
	public Student(int id) {
		super();
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", emailId=" + emailId + ", branch=" + branch
				+ "]";
	}
	
	 
}