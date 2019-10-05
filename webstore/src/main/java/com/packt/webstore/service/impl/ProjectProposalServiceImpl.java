package com.packt.webstore.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.controller.StudentController;
import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.repository.ProjectProposalRepository;
import com.packt.webstore.service.ProjectProposalService;

public class ProjectProposalServiceImpl implements ProjectProposalService {
	private static final Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	ProjectProposalRepository projectProposalRepository;

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

}
