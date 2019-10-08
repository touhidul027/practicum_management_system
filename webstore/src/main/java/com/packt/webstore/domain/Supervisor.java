package com.packt.webstore.domain;

public class Supervisor {

	private int supervisorId;
	private String userName;
	private String email;
	private String department;
    private String designation;
    private String universityName;
    private String cellPhone;
    
    
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Supervisor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Supervisor [supervisorId=" + supervisorId + ", userName=" + userName + ", email=" + email
				+ ", department=" + department + ", designation=" + designation + ", universityName=" + universityName
				+ ", cellPhone=" + cellPhone + "]";
	}


}
