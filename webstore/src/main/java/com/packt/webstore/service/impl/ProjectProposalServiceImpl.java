package com.packt.webstore.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.controller.StudentController;
import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.ProposalStatus;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.domain.repository.ProjectProposalRepository;
import com.packt.webstore.domain.repository.StudentRepository;
import com.packt.webstore.dto.ProjectProposalDto;
import com.packt.webstore.service.ProjectProposalService;

public class ProjectProposalServiceImpl implements ProjectProposalService {
	private static final Logger logger = Logger.getLogger(ProjectProposalServiceImpl.class);

	@Autowired
	ProjectProposalRepository projectProposalRepository;

	@Autowired
	StudentRepository studentRepository ;
	
	@Override
	public boolean saveprojectProposal(int studentId, int supervisorId, ProjectProposal projectProposal) {
		boolean flag = projectProposalRepository.saveprojectProposal(studentId,supervisorId,projectProposal);
		if (flag) {
			logger.info(flag);
		} else {
			logger.error("ProjectProposal not saved" + flag);
		}
		return flag;
	}

	@Override
	public ProjectProposalDto getProjectProposalStatus(int studentId) {
		ProjectProposalDto projectProposalDto = new ProjectProposalDto();
		projectProposalDto.setStudentId(studentId);
		Supervisor supervisor = studentRepository.getStudentSupervisor(studentId);
		int supervisorId = supervisor.getSupervisorId() ;
		logger.info(supervisorId);
		projectProposalDto.setSupervisorId(supervisor.getSupervisorId());
		ProposalStatus proposalStatus ;
		boolean isStudentProjectProposalExist = projectProposalRepository.isStudentProjectProposalExist(studentId);
		if(isStudentProjectProposalExist) {
			proposalStatus = ProposalStatus.EXIST;
			projectProposalDto = projectProposalRepository.getStudentProjectProposal(studentId);
		}else {
			proposalStatus = ProposalStatus.NOPROPOSALFOUND;
			projectProposalDto.setProposalStatus(proposalStatus);
			logger.info(projectProposalDto);
		}
		return projectProposalDto;
	}

}
