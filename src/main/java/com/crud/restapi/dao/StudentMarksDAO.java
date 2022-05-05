package com.crud.restapi.dao;

import java.util.ArrayList;
import java.util.List;

public class StudentMarksDAO {

	private List<StudentMarks> studentMarks = new ArrayList<>();
	
	public void setStudentMarks(StudentMarks m) {
		studentMarks.add(m);
		System.out.println("Students Marks list:" +studentMarks.size());
	}	
	
	public void updateStudentMarks(int index,StudentMarks m) {
		studentMarks.remove(index);
		studentMarks.add(m);
		System.out.println(m);
	}
	
	public List<StudentMarks> getStudentMarks(){
		return studentMarks;			
	}
}
