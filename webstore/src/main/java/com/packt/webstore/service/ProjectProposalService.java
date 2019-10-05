package com.packt.webstore.service;

import com.packt.webstore.domain.ProjectProposal;

public interface ProjectProposalService {

	boolean saveprojectProposal(int studentId, int supervisorId, ProjectProposal projectProposal);

}
