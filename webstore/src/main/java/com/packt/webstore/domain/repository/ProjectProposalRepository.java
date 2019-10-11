package com.packt.webstore.domain.repository;

import java.util.List;

import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.dto.ProjectProposalDto;

public interface ProjectProposalRepository {

	boolean saveprojectProposal(int studentId, int supervisorId,ProjectProposal projectProposal);

	boolean isStudentProjectProposalExist(long studentId);

	ProjectProposalDto getStudentProjectProposal(long studentId);

	boolean saveprojectProposal(ProjectProposalDto projectProposalDto);

	boolean updateProjectProposal(ProjectProposalDto projectProposalDto);

	boolean setProjectProposalSubmittedStatus(ProjectProposalDto projectProposalDto);

	List<ProjectProposalDto> getAllSubmittedProposalsForASupervisor(long supervisorId);

	boolean setProposalComment(long studentId, String comment);
	
	int getProjectProposalRevisions(long studentId);

}
