package com.packt.webstore.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.service.ProjectProposalService;
import com.packt.webstore.service.StudentService;

@Controller
@RequestMapping("/project/proposal")
public class ProjectProposalController {
	private static final Logger logger = Logger.getLogger(ProjectProposalController.class);

	@Autowired
	ProjectProposalService projectProposalService;

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String getProjectProposal(Model model) {
		logger.info("");
		return getFullViewName("proposal");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProposal(Model model, Principal principal,
			@ModelAttribute("projectProposal") ProjectProposal projectProposal) {
		logger.info(projectProposal);
		Student student = studentService.getStudentByEmail(principal.getName());
		logger.info(student);
		Supervisor supervisor = studentService.getStudentSupervisor(student.getStudentId());
		logger.debug(supervisor);
		logger.info("performing saving project proposal information.");
		boolean flag = projectProposalService.saveprojectProposal(student.getStudentId(), supervisor.getSupervisorId(),
				projectProposal);
		logger.info(flag);
		model.addAttribute("projectProposal", projectProposal);
		return getFullViewName("proposal");
	}

	public String getFullViewName(String viewName) {
		return "student/" + viewName;
	}
}
