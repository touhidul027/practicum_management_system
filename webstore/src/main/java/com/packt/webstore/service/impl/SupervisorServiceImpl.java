package com.packt.webstore.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

 import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.domain.repository.SupervisorRepository;
 import com.packt.webstore.service.SupervisorService;

public class SupervisorServiceImpl implements SupervisorService{
	private static final Logger logger = Logger.getLogger(SupervisorServiceImpl.class);

	@Autowired
	private SupervisorRepository supervisorRepository;
	
	@Override
	public List<Supervisor> getSupervisors() {
		return supervisorRepository.getSupervisors();
	}

	@Override
	public Supervisor getSupervisor(long id) {
		// TODO Auto-generated method stub
		return supervisorRepository.getSupervisor(id);
	}

	@Override
	public List<Supervisor> getSupervisorsExcept(int supervisorId) {
		List<Supervisor> supervisors = getSupervisors() ; 
		for(Supervisor supervisor : supervisors) {
			if(supervisor.getSupervisorId() == supervisorId) {
				supervisors.remove(supervisor);
				break ; 
			}
		}
		return supervisors;
	}

	@Override
	public Supervisor getSupervisorByUserName(String supervisorUserName) {	
		return supervisorRepository.getSupervisorByUserName(supervisorUserName);
	}

	@Override
	public Supervisor getStudentSupervisor(long studentId) {
		Supervisor supervisor=supervisorRepository.getStudentSupervisor( studentId);
		logger.info(supervisor);
		return supervisor;
	}

}
