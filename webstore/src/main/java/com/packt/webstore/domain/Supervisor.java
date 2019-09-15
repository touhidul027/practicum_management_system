package com.packt.webstore.domain;

public class Supervisor {
	private int supervisorId;
	private String userName;

	public Supervisor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supervisor(int supervisorId, String userName) {
		super();
		this.supervisorId = supervisorId;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Supervisor [supervisorId=" + supervisorId + ", userName=" + userName + "]";
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

}
