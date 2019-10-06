package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.dto.ProjectProposalDto;

public interface ProjectProposalRepository {

	boolean saveprojectProposal(int studentId, int supervisorId,ProjectProposal projectProposal);

	boolean isStudentProjectProposalExist(int studentId);

	ProjectProposalDto getStudentProjectProposal(int studentId);

}
