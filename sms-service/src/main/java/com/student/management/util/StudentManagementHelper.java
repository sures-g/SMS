package com.student.management.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.student.management.objects.Address;
import com.student.management.objects.Student;

public class StudentManagementHelper {

	private static InputStreamReader isr;

	private static BufferedReader br;
	
	static {
		isr = new InputStreamReader(System.in);

		br = new BufferedReader(isr);
	}
	
	public static Student getCreateStudent() {				
		Student student = new Student();
		String text = null;
		
		try {
			System.out.println("Enter Student Number: ");
			text = br.readLine();			
			student.setIdNumber(text);
			
			text = null;
			System.out.println("Enter Student Name: ");
			text = br.readLine();
			student.setFirstName(text);
			
			text = null;
			System.out.println("Enter Student Class: ");
			text = br.readLine();
			student.setStudentClass(Integer.parseInt(text));
			
			student.setLastUpdatedDate(Calendar.getInstance().getTime().toString());
			student.setCreationDate(Calendar.getInstance().getTime().toString());
			
			text = null;
			System.out.println("Enter Door Number: ");
			text = br.readLine();
			Address addr = new Address();
			addr.setDoorNumber(text);
			
			text = null;
			System.out.println("Enter Street: ");
			text = br.readLine();
			addr.setStreet(text);
			
			text = null;
			System.out.println("Enter City: ");
			text = br.readLine();
			addr.setCity(text);
			
			text = null;
			System.out.println("Enter State: ");
			text = br.readLine();
			addr.setState(text);
			
			text = null;
			System.out.println("Enter PIN: ");
			text = br.readLine();
			addr.setPin(Integer.parseInt(text));
			
			student.setAddress(addr);
		} catch (IOException e) {		
			e.printStackTrace();
		}			
		return student;
	}
	
	public static Student getStudentNumber() {
		Student student = new Student();
		
		String text = null;
		try {
			System.out.println("Enter Student Number: ");
			text = br.readLine();			
			student.setIdNumber(text);		
		} catch (IOException e) {		
			e.printStackTrace();
		}			
		return student;		
	}
	
	public static Student getUpdateStudent(Student student) {
		
		String text = null;
		try {
			System.out.println("Enter Student Class: ");
			text = br.readLine();			
			student.setStudentClass(Integer.parseInt(text));
			
			student.setLastUpdatedDate(Calendar.getInstance().getTime().toString());
		} catch (IOException e) {		
			e.printStackTrace();
		}			
		return student;		
	}

	
	public static void createStudentValidation(Student student) {		
		
		Date date = new Date();		 
		SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMddhhmmssS");  
		String strDate = formatter.format(date);
						
		student.setIdNumber(strDate.toString());
		
		student.setLastUpdatedDate(Calendar.getInstance().getTime().toString());
		student.setCreationDate(Calendar.getInstance().getTime().toString());
	}
	
	public static void updateStudentValidation(Student student) {		
		
		student.setLastUpdatedDate(Calendar.getInstance().getTime().toString());		
	}

}
