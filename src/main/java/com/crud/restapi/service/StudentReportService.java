package com.crud.restapi.service;


import java.util.List;

import com.crud.restapi.dao.Student;
import com.crud.restapi.dao.StudentMarks;
import com.crud.restapi.dao.StudentMarksDAO;
import com.crud.restapi.dao.StudentReport;
import com.crud.restapi.dao.Subject;

public class StudentReportService {
	
	StudentMarksDAO studentMarksDao = new StudentMarksDAO();
	StudentService studentService = new StudentService();


	public StudentMarks processStudentMarks(StudentMarks studentMarks) throws Exception {
		studentService.getStudentById(studentMarks.getId());
		int index = studentService.getIndexById(studentMarks.getId());
		if (index != -1) {
		   studentMarksDao.setStudentMarks(studentMarks);
		   return studentMarks;
	    }
		else {
			studentMarksDao.updateStudentMarks(index,studentMarks);
			return studentMarks;
		}
	}
	
	public StudentMarks getStudentMarksById(int id) throws Exception{
		int size = studentMarksDao.getStudentMarks().size();
		for(int i=0; i<size; i++) {
			if(studentMarksDao.getStudentMarks().get(i).getId()== id){
			  return studentMarksDao.getStudentMarks().get(i);
			}				
		}
		throw new Exception("No subject marks record found corresponding to this ID");
		}
	
	public float getStudentMarksPercentage(int id, StudentMarks studentMarks) {
		 List<Subject> subjects = studentMarks.getSubjects();
		 int sum1=0;
		 int totalMarks = 500;
		 System.out.println(subjects);
		 for (int i=0; i<subjects.size(); i++) {
			 int sum = subjects.get(i).getSubjectMarks();
			 System.out.println(sum);
			 sum1 = sum1 + sum;
			 }
		 float studentMarksPercent = sum1 * 100/totalMarks ;
		 return studentMarksPercent;
	}
	
	public StudentReport setStudentReportDetails(Student student,StudentMarks studentMarks) {
		StudentReport studentReport = new StudentReport();
		float studentPercent = getStudentMarksPercentage(student.getId(),studentMarks);
		if (studentPercent > 33) {
			studentReport.setResult("Passed");
		}
		else {
			studentReport.setResult("Failed");
		}
		studentReport.setId(student.getId());
		studentReport.setName(student.getName());
		studentReport.setEmail(student.getEmailId());
		studentReport.setPercentage(studentPercent);
		studentReport.setSubjects(studentMarks.getSubjects());
		return studentReport;
	}
	
	public StudentReport processStudentReport(int id,StudentMarks studentMarks) throws Exception {
		Student student = studentService.getStudentById(id);
		StudentMarks studentMarks1 = getStudentMarksById(id);
		return setStudentReportDetails(student,studentMarks1);	
	}
	
	
}
