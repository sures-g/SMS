package com.student.management.service.impl;

import org.springframework.stereotype.Component;

import com.student.management.objects.Student;
import com.student.management.service.StudentService;
import com.student.management.util.FileManagementUtil;

@Component
public class StudentServiceImpl implements StudentService {

	@Override
	public String createStudent(Student student) {
		System.out.println("createStudent() Start");
		
		boolean created = FileManagementUtil.createFile(student.getIdNumber(), student);
		
		System.out.println("createStudent() End");
		if(created){
			return "student "+student.getIdNumber()+" created";		
		}else{
			return "student "+student.getIdNumber()+" already present";	
		}
	}

	@Override
	public boolean deleteStudent(Student student) {
		System.out.println("deleteStudent() Start");
		
		System.out.println("deleteStudent() End");
		return FileManagementUtil.deleteFile(student);
	}

}
