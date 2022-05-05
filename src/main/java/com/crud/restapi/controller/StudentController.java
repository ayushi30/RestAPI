package com.crud.restapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.restapi.dao.ErrorResponse;
import com.crud.restapi.dao.Response;
import com.crud.restapi.dao.Student;
import com.crud.restapi.service.StudentService;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
	
	private StudentService studentService = new StudentService();
	
	@PostMapping(
			path="/",
			consumes = "application/json",
			produces = "application/json")
	
	public ResponseEntity<Object> addStudent(
			@RequestBody Student s)
	{	
		if(s == null || s.getName() == null || s.getName().isEmpty() || s.getEmailId() == null || s.getEmailId().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("all the fields are required");
		}
		try{
			studentService.setStudentDetails(s);
	        return ResponseEntity.status(HttpStatus.CREATED).body(s);
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getMessage()));
		}        
    }
	
	@GetMapping(
			path = "/",
			produces = "application/json")
	
	public List<Student> getAllStudents(){
		return studentService.getStudentList();
	}
	
	@GetMapping(
			path ="/{id}",
			produces = "application/json")
	
	public ResponseEntity<Object> findStudentById(@PathVariable(value = "id")int id){
		try {
			studentService.getStudentById(id);
			return ResponseEntity.status(HttpStatus.FOUND).body(studentService.getStudentById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
		}
	}
	
	@PutMapping(
			path ="/{id}",
			consumes = "application/json",
			produces = "application/json")
			
	public ResponseEntity<Object> updateDetailsOfStudentById(@PathVariable(value = "id")int id,@RequestBody Student s ){
		try {
			Student stud =studentService.processStudentUpdate(id,s);
			return ResponseEntity.status(HttpStatus.FOUND).body(new Response(true,stud));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
		}
	}
	
	@DeleteMapping(
			path ="/{id}",
			produces = "application/json")
	
	public ResponseEntity<Object> deleteDetailsOfStudentById(@PathVariable(value = "id")int id){
		try {
			studentService.processStudentDelete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Response(true,""));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
		}
		
	}
	
	
}
