package com.crud.restapi.service;

import java.util.List;

import com.crud.restapi.dao.Student;
import com.crud.restapi.dao.StudentDAO;
import com.crud.restapi.utils.Utility;

public class StudentService {
	
	StudentDAO studentDao = new StudentDAO();

	public Student setStudentDetails(Student s) throws Exception {
		isStudentEmailExists(s);
		int id = Utility.generateID();
		s.setId(id);
		studentDao.setStudent(s);
	    return s;
	}
	
	public List<Student> getStudentList(){
         return studentDao.getStudentList();
	}
	
	public Student getStudentById(int id) throws Exception{
		int size1 = studentDao.getStudentList().size();
		for(int i=0; i<size1; i++) {
			if(studentDao.getStudentList().get(i).getId()== id){
			  return studentDao.getStudentList().get(i);
			}				
		}
		throw new Exception("No record found corresponding to this ID");
		}
	
	public Student updateStudentObj(Student existingStudent, Student newStudent) throws Exception {
		if(newStudent.getName()!= null && !newStudent.getName().isEmpty()) {
			existingStudent.setName(newStudent.getName());
		}
		if(newStudent.getEmailId() != null && !newStudent.getEmailId().isEmpty()) {
			existingStudent.setEmailId(newStudent.getEmailId());			
		}
		if(newStudent.getAge() != 0) {
			existingStudent.setAge(newStudent.getAge());			
		}
		if(newStudent.getBranch() != null && !newStudent.getBranch().isEmpty()) {
			existingStudent.setBranch(newStudent.getBranch());			
		}
		return existingStudent;		
	}
	
	public int getIndexById(int id) throws Exception{
		int size1 = studentDao.getStudentList().size();
		for(int i=0; i<size1; i++) {
			if(studentDao.getStudentList().get(i).getId()== id){
			  return i;
			}				
		}
		throw new Exception("Student Not found");
		}
	
	public Student processStudentUpdate(int id, Student newStudent) throws Exception {
		Student existingStudent = getStudentById(id);
		isStudentEmailExists(newStudent);
		newStudent = updateStudentObj(existingStudent, newStudent);
		studentDao.updateStudent(getIndexById(id), newStudent);
		return newStudent;	
	}
	
	/*
	 * method: process delete
	 * get Index of Id
	 * remove index
	 * */
	public void processStudentDelete(int id) throws Exception {
		studentDao.deleteStudent(getIndexById(id));
	}
	
	public void isStudentEmailExists(Student s) throws Exception{
		String mail = s.getEmailId();
		int size = studentDao.getStudentList().size();
		for (int i=0; i<size; i++){
			if(studentDao.getStudentList().get(i).getEmailId().equals(mail)) {
				throw new Exception("Email ID already exists");
			}			
		}
	}	
}
