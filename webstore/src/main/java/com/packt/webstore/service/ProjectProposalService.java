package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.ProposalStatus;
import com.packt.webstore.dto.ProjectProposalDto;

public interface ProjectProposalService {

	boolean saveprojectProposal(int studentId, int supervisorId, ProjectProposal projectProposal);

	ProjectProposalDto getProjectProposalStatus(long studentId);

	boolean saveprojectProposal(ProjectProposalDto projectProposalDto);

	boolean updateProjectProposal(ProjectProposalDto projectProposalDto);

	boolean setProjectProposalSubmittedStatus(ProjectProposalDto projectProposalDto);

	List<ProjectProposalDto> getAllSubmittedProposalsForASupervisor(long supervisorId);

	boolean setProposalComment(long studentId, String comment);

}
