package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.Supervisor;

public interface SupervisorRepository {
	public List<Supervisor> getSupervisors();

	public Supervisor getSupervisor(int id);
}
