package com.student.management.objects;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idNumber;

	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private Integer studentClass;
	
	private String institute;

	private String lastUpdatedDate;

	private String creationDate;

	private Address address;

	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getStudentClass() {
		return studentClass;
	}


	public void setStudentClass(Integer studentClass) {
		this.studentClass = studentClass;
	}


	public String getInstitute() {
		return institute;
	}


	public void setInstitute(String institute) {
		this.institute = institute;
	}


	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}


	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	public String getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String toString() {
		return "[" + this.idNumber + ", " + this.firstName + ","+ this.lastName + ", " + this.studentClass + ", " + this.creationDate
				+ ", " + this.lastUpdatedDate + ", " + this.address.getDoorNumber() + ", " + this.address.getStreet() + ", "
				+ this.address.getCity() + ", " + this.address.getState() + ", " + this.address.getPin() + "]";
	}

}