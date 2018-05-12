package com.student.management.web;

import java.util.List;

import com.student.management.objects.Student;

public interface StudentController {

	public String createStudent(Student student);

	public String updateStudent(Student student);

	public String deleteStudent(String studentNumber);

	public Student displayStudent(String studentNumber);

	public List<Student> listStudents();

}
