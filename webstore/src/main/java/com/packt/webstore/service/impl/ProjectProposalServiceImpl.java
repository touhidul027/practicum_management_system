package com.packt.webstore.service.impl;

import java.util.List;

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
	StudentRepository studentRepository;

	@Override
	public boolean saveprojectProposal(int studentId, int supervisorId, ProjectProposal projectProposal) {
		boolean flag = projectProposalRepository.saveprojectProposal(studentId, supervisorId, projectProposal);
		if (flag) {
			logger.info(flag);
		} else {
			logger.error("ProjectProposal not saved" + flag);
		}
		return flag;
	}

	@Override
	public ProjectProposalDto getProjectProposalStatus(long studentId) {
		ProjectProposalDto projectProposalDto = new ProjectProposalDto();
		Supervisor supervisor = studentRepository.getStudentSupervisor(studentId);
		int supervisorId = supervisor.getSupervisorId();
		logger.info(supervisorId);
		projectProposalDto.setSupervisorId(supervisor.getSupervisorId());
		ProposalStatus proposalStatus;
		boolean isStudentProjectProposalExist = projectProposalRepository.isStudentProjectProposalExist(studentId);
		if (isStudentProjectProposalExist) {
			projectProposalDto = projectProposalRepository.getStudentProjectProposal(studentId);
			if (projectProposalDto.isConfirmed()) {
				proposalStatus = ProposalStatus.CONFIRMED;
			} else {
				proposalStatus = ProposalStatus.EXIST;
			}
			logger.info(proposalStatus);
			projectProposalDto.setProposalStatus(proposalStatus);
		} else {
			proposalStatus = ProposalStatus.NOPROPOSALFOUND;
			projectProposalDto.setProposalStatus(proposalStatus);
			logger.info(proposalStatus);
		}
		logger.info("Supervisor ID " + supervisor.getSupervisorId() + " by studentRepository.");
		logger.info("Supervisor ID " + projectProposalDto.getSupervisorId() + " by projectProposalDto.");
		projectProposalDto.setStudentId(studentId);
		logger.info(projectProposalDto);
		return projectProposalDto;
	}

	@Override
	public boolean saveprojectProposal(ProjectProposalDto projectProposalDto) {
		projectProposalDto.setFirstLongTime(0); // first insertion
		projectProposalDto.setLastLongTime(0);
		boolean flag = projectProposalRepository.saveprojectProposal(projectProposalDto);
		if (flag) {
			logger.info("ProjectProposal Inserted : " + flag);
		} else {
			logger.error("ProjectProposal not inserted : " + flag);
		}
		return flag;
	}

	@Override
	public boolean updateProjectProposal(ProjectProposalDto projectProposalDto) {
		// TODO Auto-generated method stub
		boolean flag = projectProposalRepository.updateProjectProposal(projectProposalDto);
		if (flag) {
			logger.info("ProjectProposal updated :" + flag);
		} else {
			logger.error("ProjectProposal not updated :" + flag);
		}
		return flag;
	}

	@Override
	public boolean setProjectProposalSubmittedStatus(ProjectProposalDto projectProposalDto) {
		projectProposalDto.setFirstLongTime(System.currentTimeMillis());
		projectProposalDto.setSubmitted(true);
		logger.info("Setting first sent time and ,isSubmitted to true");
		boolean isSubmitted = projectProposalRepository.setProjectProposalSubmittedStatus(projectProposalDto);
		if (isSubmitted) {
			logger.info("updated isSubmitted status worked");
		} else {
			logger.error("updated isSubmitted status failed.");

		}
		return isSubmitted;
	}

	@Override
	public List<ProjectProposalDto> getAllSubmittedProposalsForASupervisor(long supervisorId) {
		List<ProjectProposalDto> projectProposalsDto = projectProposalRepository
				.getAllSubmittedProposalsForASupervisor(supervisorId);
		for (ProjectProposalDto projectProposalDto : projectProposalsDto) {
			logger.info("ID :" + projectProposalDto.getStudentId() + "  Title name :"
					+ projectProposalDto.getProjectTitle());
		}

		return projectProposalsDto;
	}

}
