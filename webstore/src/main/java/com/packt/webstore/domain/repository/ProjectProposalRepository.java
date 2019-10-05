package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.ProjectProposal;

public interface ProjectProposalRepository {

	boolean saveprojectProposal(int studentId, int supervisorId,ProjectProposal projectProposal);

}
