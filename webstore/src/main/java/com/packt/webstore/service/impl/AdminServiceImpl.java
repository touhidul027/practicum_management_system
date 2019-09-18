package com.packt.webstore.service.impl;

import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.domain.repository.AdminRepository;
import com.packt.webstore.domain.repository.StudentRepository;
import com.packt.webstore.domain.repository.SupervisorRepository;
import com.packt.webstore.dto.ChangeSupervisorDTO;
import com.packt.webstore.service.AdminService;
import com.packt.webstore.service.SupervisorService;

public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SupervisorRepository SupervisorRepository;

	@Autowired
	private SupervisorService supervisorService;

	@Override
	public List<Supervisor> getSupervisorsExcept(int supervisorId) {
		// get all the supervisors

		return null;
	}

	@Override
	public ChangeSupervisorDTO changeSupervisor(int studentId) {
		Student student = studentRepository.getStudent(studentId);
		Supervisor supervisor = studentRepository.getStudentSupervisor(studentId);
		int supervisorId = supervisor.getSupervisorId();
		List<Supervisor> supervisorList = supervisorService.getSupervisorsExcept(supervisorId);

		// convert this list with treeMap
		TreeMap<Integer, String> supervisors = new TreeMap<Integer, String>();

		for (Supervisor s : supervisorList) {
			if (s.getSupervisorId() != supervisorId) {
				supervisors.put(s.getSupervisorId(), s.getUserName());
			}
		}

		ChangeSupervisorDTO changeSupervisorDTO = new ChangeSupervisorDTO(studentId, student.getUserName(),
				supervisorId, supervisor.getUserName(), supervisors);

		return changeSupervisorDTO;
	}

}
