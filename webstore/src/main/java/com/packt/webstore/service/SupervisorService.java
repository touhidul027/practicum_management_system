package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Supervisor;

public interface SupervisorService {
	public List<Supervisor> getSupervisors();

	public Supervisor getSupervisor(long l);
	
	public List<Supervisor> getSupervisorsExcept(int supervisorId);

	public Supervisor getSupervisorByUserName(String supervisorUserName);

	public Supervisor getStudentSupervisor(long studentId);

}
