package com.crud.restapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.restapi.dao.ErrorResponse;
import com.crud.restapi.dao.StudentMarks;
import com.crud.restapi.service.StudentReportService;

@RestController
@RequestMapping(path = "/student/report")
public class StudentReportController {
	
	StudentReportService studentReportService = new StudentReportService();
	
	@PostMapping(
			path = "/",
			produces = "application/json",
			consumes = "application/json")
	
	public ResponseEntity<Object> addStudentMarks(
			@RequestBody StudentMarks studentMarks){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(studentReportService.processStudentMarks(studentMarks));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
		}		
	}
	
	@GetMapping(
			path ="/{id}",
			produces = "application/json")
	
	public ResponseEntity<Object> getStudentReport(@PathVariable(value = "id")int id, StudentMarks studentMarks){
		try {
			return ResponseEntity.status(HttpStatus.FOUND).body(studentReportService.processStudentReport(id, studentMarks));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
		}
		
	}

}
