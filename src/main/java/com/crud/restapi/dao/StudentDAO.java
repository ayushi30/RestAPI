package com.crud.restapi.dao;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	private static List<Student> studentList = new ArrayList<Student>();
	
	public void setStudent(Student s){
		studentList.add(s);
		System.out.println("data size: " + studentList.size());
	}
	
	public void updateStudent(int index,Student s2){
		studentList.remove(index);
		studentList.add(s2);
		System.out.println(s2);
	}
	
	public void deleteStudent(int index){
		studentList.remove(index);
	}
	
	public List<Student> getStudentList(){
		return studentList;			
	}
}
