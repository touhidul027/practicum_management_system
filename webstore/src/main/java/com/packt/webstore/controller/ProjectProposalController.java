package com.packt.webstore.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.ProposalStatus;
import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.dto.ProjectProposalDto;
import com.packt.webstore.service.ProjectProposalService;
import com.packt.webstore.service.StudentService;
import com.packt.webstore.service.SupervisorService;

@Controller
@SessionAttributes("projectProposalDto")
@RequestMapping("/project/proposal")
public class ProjectProposalController {
	private static final Logger logger = Logger.getLogger(ProjectProposalController.class);

	@Autowired
	ProjectProposalService projectProposalService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private SupervisorService supervisorService;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String getProjectProposal(Model model) {
		logger.info("");
		return getFullViewName("proposal");
	}

	/*
	 * @RequestMapping(value = "/save", method = RequestMethod.POST) public String
	 * saveProposal(Model model, Principal principal,
	 * 
	 * @ModelAttribute("projectProposal") ProjectProposal projectProposal) {
	 * logger.info(projectProposal); Student student =
	 * studentService.getStudentByEmail(principal.getName()); logger.info(student);
	 * Supervisor supervisor =
	 * studentService.getStudentSupervisor(student.getStudentId());
	 * logger.debug(supervisor);
	 * logger.info("performing saving project proposal information."); boolean flag
	 * = projectProposalService.saveprojectProposal(student.getStudentId(),
	 * supervisor.getSupervisorId(), projectProposal); logger.info(flag);
	 * model.addAttribute("projectProposal", projectProposal); return
	 * getFullViewName("proposal"); }
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProposal(Model model, Principal principal,RedirectAttributes redirectAttributes,
			@ModelAttribute("projectProposalDto") ProjectProposalDto projectProposalDto) {
		logger.info("projectProposalDto :" + projectProposalDto);
		Supervisor supervisor = supervisorService.getSupervisor(projectProposalDto.getSupervisorId());
		logger.debug(supervisor);
		logger.info("performing saving project proposal information.");
		ProposalStatus proposalStatus = projectProposalDto.getProposalStatus();
		logger.info("proposalStatus :" + proposalStatus);
		boolean flag;
		if (proposalStatus == ProposalStatus.NOPROPOSALFOUND) {
			// fresh insert call should be done
			flag = projectProposalService.saveprojectProposal(projectProposalDto);
			logger.info("Inserting proposal :" + flag);
			if (flag) {
				redirectAttributes.addFlashAttribute("message", "Proposal bean inserted.");
			} else {
				redirectAttributes.addFlashAttribute("message", "Proposal not been inserted.Please send this report to developer team.");
			}
		} else {
			// update will be performed here
			flag = projectProposalService.updateProjectProposal(projectProposalDto);
			if (flag) {
				redirectAttributes.addFlashAttribute("message", "Proposal bean updated.");
			} else {
				redirectAttributes.addFlashAttribute("message", "Proposal not bean updated.Please send this report to developer team.");
			}
			logger.info("updating proposal :" + flag);
		}
		return "redirect:/student/thanks";
	}

	public String getFullViewName(String viewName) {
		return "student/" + viewName;
	}
}
