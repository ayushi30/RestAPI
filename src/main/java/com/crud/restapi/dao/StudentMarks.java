package com.crud.restapi.dao;

import java.util.ArrayList;
import java.util.List;

public class StudentMarks {
	private int id;
	private List<Subject> subjects = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	
	
}
