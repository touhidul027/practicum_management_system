package com.packt.webstore.dto;

import java.util.Map;
import java.util.TreeMap;

public class ChangeSupervisorDTO {
	private int studentId;
	private String studentName;
	private int supervisorId;
	private String supervisorUserName;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ChangeSupervisorDTO() {
		super();
		supervisors = new TreeMap<Integer, String>();
		// TODO Auto-generated constructor stub
	}

	public ChangeSupervisorDTO(int studentId, String studentName, int supervisorId, String supervisorUserName,
			TreeMap<Integer, String> supervisors) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.supervisorId = supervisorId;
		this.supervisorUserName = supervisorUserName;
		this.supervisors = supervisors;
	}

	@Override
	public String toString() {
		return "ChangeSupervisorDTO [studentId=" + studentId + ", studentName=" + studentName + ", supervisorId="
				+ supervisorId + ", supervisorUserName=" + supervisorUserName + ", supervisors=" + supervisors + "]";
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getSupervisorUserName() {
		return supervisorUserName;
	}

	public void setSupervisorUserName(String supervisorUserName) {
		this.supervisorUserName = supervisorUserName;
	}

	public Map<Integer, String> getSupervisors() {
		return supervisors;
	}

	public void setSupervisors(TreeMap<Integer, String> supervisors) {
		this.supervisors = supervisors;
	}

	private TreeMap<Integer, String> supervisors;
}
