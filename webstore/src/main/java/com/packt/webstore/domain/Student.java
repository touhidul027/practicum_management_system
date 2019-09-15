package com.packt.webstore.domain;

public class Student {
	private int id;
	private String userName;
	private String supervisor;

	public Student(int id, String userName, String supervisor) {
		super();
		this.id = id;
		this.userName = userName;
		this.supervisor = supervisor;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", userName=" + userName + ", supervisor=" + supervisor + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
