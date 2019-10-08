package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Supervisor;

public interface SupervisorRepository {
	public List<Supervisor> getSupervisors();

	public Supervisor getSupervisor(long supervisorId);

	public Supervisor getSupervisorByUserName(String supervisorUserName);

	public Supervisor getSupervisorByStudentId(int studentId);

	public Supervisor getStudentSupervisor(long studentId);
}
