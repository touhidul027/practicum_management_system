package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.dto.ChangeSupervisorDTO;

public interface AdminService {
	public List<Supervisor> getSupervisorsExcept(int supervisorId);

	public ChangeSupervisorDTO getChangeSupervisorDTO(int studentId);

	public ChangeSupervisorDTO changeSupervisor(int parseInt, int parseInt2);
	

}
