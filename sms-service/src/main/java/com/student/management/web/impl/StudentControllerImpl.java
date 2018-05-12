package com.student.management.web.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.objects.Student;
import com.student.management.service.StudentMaintenance;
import com.student.management.service.StudentService;
import com.student.management.util.StudentManagementHelper;
import com.student.management.web.StudentController;

@RestController
@RequestMapping("student")
public class StudentControllerImpl implements StudentController {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentMaintenance studentMaintenance;
	
	//Sample URL : http://localhost:8080/studentService/student/create
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/create", consumes = {"application/json"}, produces = {"application/json"})
	@CrossOrigin
	public String createStudent(@RequestBody Student student) {

		System.out.println("Create Student Process");
		//studentService = new StudentServiceImpl();
		//student = StudentManagementHelper.getCreateStudent();
		StudentManagementHelper.createStudentValidation(student);
		String status = studentService.createStudent(student);
		status = "{\"status\": \""+status+"\"}";
		return status;
	}
	
	//Sample URL : http://localhost:8080/studentService/student/update
	
	@RequestMapping(method = {RequestMethod.POST}, value = "/update", produces = {"application/json"}, consumes = {"application/json"})
	@CrossOrigin
	public String updateStudent(@RequestBody Student student) {
		
		System.out.println("Update Student Process");			
		//studentMaintenance = new StudentMaintenanceImpl();
		//student = StudentManagementHelper.getStudentByNumber(student.getStudentNumber());
		//student = studentMaintenance.listStudent(student);
		//student = StudentManagementHelper.getUpdateStudent(student);
		StudentManagementHelper.updateStudentValidation(student);
		student = studentMaintenance.updateStudent(student);
		String status;
		if (student != null){
			status = "{\"status\": \" Student "+student.getIdNumber()+" successully updated\"}";
		} else{
			status = "{\"status\": \" Student "+student.getIdNumber()+" not present!\"}";
		}
			
		return status;
	}
	
	//Sample URL: http://localhost:8080/studentService/student/delete?studentNumber=201

	@RequestMapping(method = {RequestMethod.GET}, value = "delete", produces = {"application/json"})
	@CrossOrigin
	public String deleteStudent(@RequestParam String studentNumber) {
		
		Student student = new Student();
		student.setIdNumber(studentNumber);
		//studentService = new StudentServiceImpl();
		String status;
		if(studentService.deleteStudent(student)){
			status = "{\"status\": \" Student "+student.getIdNumber()+" successully deleted\"}";
		} else {
			status = "{\"status\": \" Student "+student.getIdNumber()+" not prsent\"}";
		}
		
		return status;
	}
	
	//Sample URL: http://localhost:8080/studentService/student/display?studentNumber=201
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/display", produces = {"application/json"})
	@CrossOrigin
	public Student displayStudent(@RequestParam String studentNumber) {
		
		//studentMaintenance = new StudentMaintenanceImpl();
		Student student = new Student();
		student.setIdNumber(studentNumber);
		student = studentMaintenance.listStudent(student);
		
		return student;
	}
	
	//Sample URL: http://localhost:8080/studentService/student/displayAll
	
	@RequestMapping(method = {RequestMethod.GET}, value = "/displayAll", produces = {"application/json"})
	@CrossOrigin
	public List<Student> listStudents() {
		
		System.out.println("List Student Process");
		//studentMaintenance = new StudentMaintenanceImpl();
		
		List<Student> list = new ArrayList();
		
		list = studentMaintenance.listAllStudents();
		
		return list;
	}

}
