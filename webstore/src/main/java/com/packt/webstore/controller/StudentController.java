package com.packt.webstore.controller;

import java.security.Principal;
//import java.util.logging.Logger;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.ProposalStatus;
import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.dto.ProjectProposalDto;
import com.packt.webstore.service.ProjectProposalService;
import com.packt.webstore.service.StudentService;
import com.packt.webstore.service.SupervisorService;
import com.packt.webstore.service.UserService;

@Controller
@SessionAttributes("projectProposalDto")
@RequestMapping("/student")
public class StudentController {
	private static final Logger logger = Logger.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@Autowired
	SupervisorService supervisorService;

	@Autowired
	UserService userService;
	
	@Autowired
	ProjectProposalService projectProposalService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String studentsPage(Model model, Principal principal) {
		String userEmail = principal.getName();
		System.out.println(principal.toString());
		Student student = studentService.getStudentByEmail(userEmail);
		model.addAttribute("student", student);
		return getFullViewName("profile");
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public String studentTasks(Model model, Principal principal) {
		String userEmail = principal.getName();
		System.out.println(principal.toString());
		Student student = studentService.getStudentByEmail(userEmail);
		model.addAttribute("student", student);
		return getFullViewName("tasks");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editStudent(Model model, Principal principal) {
		String userEmail = principal.getName();
		Student student = studentService.getStudentByEmail(userEmail);
		model.addAttribute("student", student);
		return getFullViewName("editProfile");
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String saveStudent(Model model, Principal principal, @ModelAttribute("employee") Student student) {
		long studentId = student.getStudentId();
		String cellPhone = student.getCellPhone();
		String password = student.getPassword();
		boolean flag = studentService.updateStudent(studentId, cellPhone, password);
		return "redirect:/student/profile";
	}

	@RequestMapping(value = "/supervisor", method = RequestMethod.GET)
	public String getStudentSupervisor(Model model, Principal principal,
			SecurityContextHolderAwareRequestWrapper request) {
		Student student = studentService.getStudentByEmail(principal.getName());
		logger.info(student);
		Supervisor supervisor = supervisorService.getStudentSupervisor(student.getStudentId());
		logger.info(supervisor);
		model.addAttribute("supervisor", supervisor);
		return getFullViewName("supervisor");
	}

	@RequestMapping(value = "/projectProposal", method = RequestMethod.GET)
	public String getProjectProposal(Model model, Principal principal) {
		Student student = studentService.getStudentByEmail(principal.getName());
		logger.info(student);
		ProjectProposalDto projectProposalDto = projectProposalService.getProjectProposalStatus(student.getStudentId());
		//logger.info(projectProposalDto);
		ProposalStatus proposalStatus=projectProposalDto.getProposalStatus();
		logger.info("proposalStatus : " + proposalStatus.toString());
		model.addAttribute("projectProposalDto", projectProposalDto);
		boolean isSubmitted = projectProposalDto.isSubmitted() ; 
		if(isSubmitted) {
			model.addAttribute("isSubmitted", "yes");
		}else {
			model.addAttribute("isSubmitted", "no");
		}
		logger.info("Supervisor comment : " + projectProposalDto.getSupervisorComment());
		return getFullViewName("proposal");
	}
	
	@RequestMapping(value = "/thanks", method = RequestMethod.GET)
	public String thanks(Model model, Principal principal) {
		return getFullViewName("thanks");
	}
	
	public String getFullViewName(String viewName) {
		return "student/" + viewName;
	}
}