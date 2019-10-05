package com.packt.webstore.domain;

public class ProjectProposal {
	private String projectTitle;
	private String projectFor;
	private String projectDoingAt;
	private String objective;
	private String technologicalStacks;
	private String modules;
	private String actors;
	private String functionalRequirements;

	public String getTechnologicalStacks() {
		return technologicalStacks;
	}

	public void setTechnologicalStacks(String technologicalStacks) {
		this.technologicalStacks = technologicalStacks;
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

	@Override
	public String toString() {
		return "ProjectProposal [projectTitle=" + projectTitle + ", projectFor=" + projectFor + ", projectDoingAt="
				+ projectDoingAt + ", objective=" + objective + ", technologicalStacks=" + technologicalStacks
				+ ", modules=" + modules + ", actors=" + actors + ", functionalRequirements=" + functionalRequirements
				+ "]";
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
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
}
