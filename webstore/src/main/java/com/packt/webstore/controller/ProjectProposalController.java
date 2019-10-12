package com.packt.webstore.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String submitProjectProposal(Model model,
			@ModelAttribute("projectProposalDto") ProjectProposalDto projectProposalDto) {
		logger.info("projectProposalDto student ID : " + projectProposalDto.getStudentId());
		boolean isSubmitted = projectProposalService.setProjectProposalSubmittedStatus(projectProposalDto);
		if (isSubmitted) {
			model.addAttribute("message", "Your Project proposal have been successfully submitted.");
			logger.info("Your Project proposal have been successfully submitted");
		} else {
			model.addAttribute("message",
					"Your Project proposal have not successfully submitted.Try again or send report to the developer teams.");
			logger.error(
					"Your Project proposal have not successfully submitted.Try again or send report to the developer teams.");
		}
		return getFullViewName("waiting");
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProposal(Model model, Principal principal, RedirectAttributes redirectAttributes,
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
				redirectAttributes.addFlashAttribute("message",
						"Proposal not been inserted.Please send this report to developer team.");
			}
		} else {
			// update will be performed here
			flag = projectProposalService.updateProjectProposal(projectProposalDto);
			if (flag) {
				redirectAttributes.addFlashAttribute("message", "Proposal bean updated.");
			} else {
				redirectAttributes.addFlashAttribute("message",
						"Proposal not bean updated.Please send this report to developer team.");
			}
			logger.info("updating proposal :" + flag);
		}
		return "redirect:/student/thanks";
	}

	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String reviewProjectProposal(Model model,
			@ModelAttribute("projectProposalDto") ProjectProposalDto projectProposalDto) {
		long studentId = projectProposalDto.getStudentId();
		logger.info("Student ID : " + studentId);
		Student student = studentService.getStudentById(studentId);
		logger.info("Student :" + student);
		model.addAttribute("student", student);

		Supervisor supervisor = supervisorService.getStudentSupervisor(studentId);
		logger.info("Supervisor :" + supervisor);
		model.addAttribute("supervisor", supervisor);
		model.addAttribute("projectProposalDto", projectProposalDto);

		// for specific view
		String technologicalStacks = projectProposalDto.getTechnologicalStacks();
		List<String> technologicalStacksAsList = new ArrayList<String>(Arrays.asList(technologicalStacks.split(",")));
		model.addAttribute("technologicalStacksAsList", technologicalStacksAsList);
		logger.info("technologicalStacksAsList : " + technologicalStacksAsList);

		String modules = projectProposalDto.getModules();
		List<String> modulesAsList = new ArrayList<String>(Arrays.asList(modules.split(",")));
		model.addAttribute("modulesAsList", modulesAsList);
		logger.info("modulesAsList : " + modulesAsList);

		String actors = projectProposalDto.getActors();
		List<String> actorsAsList = new ArrayList<String>(Arrays.asList(actors.split(",")));
		model.addAttribute("actorsAsList", actorsAsList);
		logger.info("actorsAsList : " + actorsAsList);

		String functionalRequirements = projectProposalDto.getFunctionalRequirements();
		List<String> functionalRequirementsAsList = new ArrayList<String>(
				Arrays.asList(functionalRequirements.split(",")));
		model.addAttribute("functionalRequirementsAsList", functionalRequirementsAsList);
		logger.info("functionalRequirementsAsList : " + functionalRequirementsAsList);

		boolean isSubmitted = projectProposalDto.isSubmitted();
		if (isSubmitted) {
			model.addAttribute("isSubmitted", "yes");
		} else {
			model.addAttribute("isSubmitted", "no");
		}

		return getFullViewName("proposalReview");
	}

	@RequestMapping(value = "/supervisor/review/{studentId}", method = RequestMethod.GET)
	public String seeProjectProposalForReview(Model model, Principal principal,
			@PathVariable(value = "studentId") String studentIdStr) {
		logger.info("Student Id : " + studentIdStr);
		long studentId = Long.parseLong(studentIdStr);
		Student student = studentService.getStudentById(studentId);
		logger.info("Student :" + student);
		model.addAttribute("student", student);

		Supervisor supervisor = supervisorService.getStudentSupervisor(studentId);
		logger.info("Supervisor :" + supervisor);
		model.addAttribute("supervisor", supervisor);

		ProjectProposalDto projectProposalDto = projectProposalService.getProjectProposalStatus(studentId);
		logger.info("Proposal Title : " + projectProposalDto.getProjectTitle());

		// for specific view
		String technologicalStacks = projectProposalDto.getTechnologicalStacks();
		List<String> technologicalStacksAsList = new ArrayList<String>(Arrays.asList(technologicalStacks.split(",")));
		model.addAttribute("technologicalStacksAsList", technologicalStacksAsList);
		logger.info("technologicalStacksAsList : " + technologicalStacksAsList);

		String modules = projectProposalDto.getModules();
		List<String> modulesAsList = new ArrayList<String>(Arrays.asList(modules.split(",")));
		model.addAttribute("modulesAsList", modulesAsList);
		logger.info("modulesAsList : " + modulesAsList);

		String actors = projectProposalDto.getActors();
		List<String> actorsAsList = new ArrayList<String>(Arrays.asList(actors.split(",")));
		model.addAttribute("actorsAsList", actorsAsList);
		logger.info("actorsAsList : " + actorsAsList);

		String functionalRequirements = projectProposalDto.getFunctionalRequirements();
		List<String> functionalRequirementsAsList = new ArrayList<String>(
				Arrays.asList(functionalRequirements.split(",")));
		model.addAttribute("functionalRequirementsAsList", functionalRequirementsAsList);
		logger.info("functionalRequirementsAsList : " + functionalRequirementsAsList);

		model.addAttribute("projectProposalDto", projectProposalDto);

		return "supervisor/proposal";
	}
	
	@RequestMapping(value = "/supervisor/confirm/{studentId}", method = RequestMethod.GET)
	public String confirmProposal(Model model, HttpServletRequest req, Principal principal,
			@PathVariable(value = "studentId") String studentIdStr) {
		 logger.info("Student Id : " + studentIdStr);
		 long studentId = Long.parseLong(studentIdStr);
		 boolean isConfirmed = projectProposalService.confirmProjectProposal(studentId);
	     if(isConfirmed) {
	    	 model.addAttribute("message", "Project proposal has been confirmed.");
	     }else {
	    	 model.addAttribute("message", "Sorry,Project proposal has not been confirmed.");    	 
	     }
		 return "supervisor/thanks";
	}
	
	@RequestMapping(value = "/supervisor/return/{studentId}", method = RequestMethod.POST)
	public String setProposalComment(Model model, HttpServletRequest req, Principal principal,
			@PathVariable(value = "studentId") String studentIdStr) {
		logger.info("Student Id : " + studentIdStr);
		long studentId = Long.parseLong(studentIdStr);
		String comment = (String) req.getParameter("comment");
		logger.info("Supervisor comment : " + comment);
		boolean flag = projectProposalService.setProposalComment(studentId,comment);
		if (flag) {
            model.addAttribute("message", "Proposal Successfully returned.");
		} else {
			model.addAttribute("message", "Sorry Exception occured.It will be fixed soon.");
		}
		return "supervisor/thanks";
	}

	public String getFullViewName(String viewName) {
		return "student/" + viewName;
	}
}
