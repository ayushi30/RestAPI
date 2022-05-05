package com.crud.restapi.dao;

public class Subject {
  
	private String subjectName;
	private int subjectMarks;
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	@Override
	public String toString() {
		return "Subject [subjectName=" + subjectName + ", subjectMarks=" + subjectMarks + "]";
	}
	public int getSubjectMarks() {
		return subjectMarks;
	}
	public void setSubjectMarks(int subjectMarks) {
		this.subjectMarks = subjectMarks;
	}
	
	
}
