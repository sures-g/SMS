package com.student.management.service;

import java.util.List;

import com.student.management.objects.Student;

public interface StudentMaintenance {

	public Student updateStudent(Student student);

	public Student listStudent(Student student);

	public List<Student> listAllStudents();
}
