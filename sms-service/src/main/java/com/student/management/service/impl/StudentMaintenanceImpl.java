package com.student.management.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.student.management.objects.Student;
import com.student.management.service.StudentMaintenance;
import com.student.management.util.FileManagementUtil;

@Component
public class StudentMaintenanceImpl implements StudentMaintenance {

	@Override
	public Student updateStudent(Student student) {
		System.out.println("listStudent() Start");

		System.out.println("listStudent() End");
		return FileManagementUtil.updateFile(student.getIdNumber(), student);		
	}

	@Override
	public Student listStudent(Student student) {
		System.out.println("listStudent() Start");

		System.out.println("listStudent() End");
		return FileManagementUtil.readFile(student.getIdNumber(), student);	
	}

	@Override
	public List<Student> listAllStudents() {
		System.out.println("listAllStudents() Start");

		System.out.println("listAllStudents() End");

		return FileManagementUtil.readFiles();
	}

}
