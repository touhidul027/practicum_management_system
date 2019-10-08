package com.packt.webstore.domain;

public class Student {
	private long studentId;
	

	private String userName;

	private String studentEmail;
	private String studentDepartment;
	private String cellPhone;
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	private String password ; 

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentDepartment() {
		return studentDepartment;
	}

	public void setStudentDepartment(String studentDepartment) {
		this.studentDepartment = studentDepartment;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", userName=" + userName + ", studentEmail=" + studentEmail
				+ ", studentDepartment=" + studentDepartment + "]";
	}
}
