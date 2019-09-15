package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Supervisor;

public interface SupervisorService {
	public List<Supervisor> getSupervisors();

	public Supervisor getSupervisor(int parseInt);

}
