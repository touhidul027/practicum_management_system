package com.packt.webstore.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.dto.ProjectProposalDto;
import com.packt.webstore.service.ProjectProposalService;
import com.packt.webstore.service.StudentService;
import com.packt.webstore.service.SupervisorService;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {
	private static final Logger logger = Logger.getLogger(ProjectProposalController.class);

	@Autowired
	ProjectProposalService projectProposalService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private SupervisorService supervisorService;
	
	@RequestMapping(value = "/proposals", method = RequestMethod.GET)
	public String studentsProposals(Model model, Principal principal) {
		String supervisorUserName = principal.getName();
		logger.info("supervisor user name : " + supervisorUserName);
		Supervisor supervisor = supervisorService.getSupervisorByUserName(supervisorUserName);
		logger.info("Supervisor " + supervisor);
		long supervisorId = supervisor.getSupervisorId();
		// get the all proposals object regarding that supervisor
		List<ProjectProposalDto> projectProposalsDto = projectProposalService
				.getAllSubmittedProposalsForASupervisor(supervisorId);
		Map<Long, String> studentsMap = new HashMap<>();

		for (ProjectProposalDto projectProposalDto : projectProposalsDto) {
			logger.info(projectProposalDto.getStudentId() + " " + projectProposalDto.getProjectTitle());
			long studentId = projectProposalDto.getStudentId();
			Student student = studentService.getStudentById(studentId);
			studentsMap.put(studentId, student.getUserName());
		}
		logger.info("Students Map : " + studentsMap );
		model.addAttribute("projectProposalsDto", projectProposalsDto);
		model.addAttribute("studentsMap", studentsMap );
		
		return getFullViewName("proposals");
	}

	public String getFullViewName(String viewName) {
		return "supervisor/" + viewName;
	}
}
