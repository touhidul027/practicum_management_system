package com.packt.webstore.dto;

import com.packt.webstore.domain.ProposalStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class ProjectProposalDto {
	private long studentId ; 
	private long supervisorId ;	
	private String projectTitle;
	private String projectFor;
	private String projectDoingAt;
	private String objective;
	private String technologicalStacks;
	private String modules;
	private String actors;	
	private String functionalRequirements;
	private boolean isConfirmed ;
	private long firstLongTime;
	private long lastLongTime;
	private int revisons;
	private String supervisorComment ;
	private ProposalStatus proposalStatus;
	private boolean isSubmitted;
	public boolean isSubmitted() {
		return isSubmitted;
	}
	public void setSubmitted(boolean isSubmitted) {
		this.isSubmitted = isSubmitted;
	}
	
	@Override
	public String toString() {
		return "ProjectProposalDto [studentId=" + studentId + ", supervisorId=" + supervisorId + ", projectTitle="
				+ projectTitle + ", projectFor=" + projectFor + ", projectDoingAt=" + projectDoingAt + ", objective="
				+ objective + ", technologicalStacks=" + technologicalStacks + ", modules=" + modules + ", actors="
				+ actors + ", functionalRequirements=" + functionalRequirements + ", isConfirmed=" + isConfirmed
				+ ", firstLongTime=" + firstLongTime + ", lastLongTime=" + lastLongTime + ", revisons=" + revisons
				+ ", supervisorComment=" + supervisorComment + ", proposalStatus=" + proposalStatus + ", isSubmitted="
				+ isSubmitted + "]";
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(long supervisorId) {
		this.supervisorId = supervisorId;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectFor() {
		return projectFor;
	}
	public void setProjectFor(String projectFor) {
		this.projectFor = projectFor;
	}
	public String getProjectDoingAt() {
		return projectDoingAt;
	}
	public void setProjectDoingAt(String projectDoingAt) {
		this.projectDoingAt = projectDoingAt;
	}
	public String getObjective() {
		return objective;
	}
	public void setObjective(String objective) {
		this.objective = objective;
	}
	public ProjectProposalDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTechnologicalStacks() {
		return technologicalStacks;
	}
	public void setTechnologicalStacks(String technologicalStacks) {
		this.technologicalStacks = technologicalStacks;
	}
	public String getModules() {
		return modules;
	}
	public void setModules(String modules) {
		this.modules = modules;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getFunctionalRequirements() {
		return functionalRequirements;
	}
	public void setFunctionalRequirements(String functionalRequirements) {
		this.functionalRequirements = functionalRequirements;
	}
	
	public boolean isConfirmed() {
		return isConfirmed;
	}
	public void setConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
	public long getFirstLongTime() {
		return firstLongTime;
	}
	public void setFirstLongTime(long firstLongTime) {
		this.firstLongTime = firstLongTime;
	}
	public long getLastLongTime() {
		return lastLongTime;
	}
	public void setLastLongTime(long lastLongTime) {
		this.lastLongTime = lastLongTime;
	}
	public int getRevisons() {
		return revisons;
	}
	public void setRevisons(int revisons) {
		this.revisons = revisons;
	}
	public String getSupervisorComment() {
		return supervisorComment;
	}
	public void setSupervisorComment(String supervisorComment) {
		this.supervisorComment = supervisorComment;
	}
	public ProposalStatus getProposalStatus() {
		return proposalStatus;
	}
	public void setProposalStatus(ProposalStatus proposalStatus) {
		this.proposalStatus = proposalStatus;
	}
}
