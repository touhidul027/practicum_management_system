package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.dto.ProjectProposalDto;

public interface ProjectProposalRepository {

	boolean saveprojectProposal(int studentId, int supervisorId,ProjectProposal projectProposal);

	boolean isStudentProjectProposalExist(long studentId);

	ProjectProposalDto getStudentProjectProposal(long studentId);

	boolean saveprojectProposal(ProjectProposalDto projectProposalDto);

	boolean updateProjectProposal(ProjectProposalDto projectProposalDto);

	boolean setProjectProposalSubmittedStatus(ProjectProposalDto projectProposalDto);

}
