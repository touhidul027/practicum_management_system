package com.packt.webstore.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.service.StudentService;
import com.packt.webstore.service.SupervisorService;

@Controller
@RequestMapping("/")
public class MeetingController {
	private static final Logger logger = Logger.getLogger(MeetingController.class);
	@Autowired
	private StudentService studentService;

	@Autowired
	private SupervisorService supervisorService;
	
	@RequestMapping(value = "supervisor/meeting/times", method = RequestMethod.GET)
	public String practicumStudents(Model model, Principal principal) {
		String supervisorUserName = principal.getName();
		logger.info("supervisor user name : " + supervisorUserName);
		Supervisor supervisor = supervisorService.getSupervisorByUserName(supervisorUserName);
		logger.info("Supervisor " + supervisor);
		long supervisorId = supervisor.getSupervisorId();
		// get all the students those are doing internship in his supervision
		//List<Student> students = studentService.getStudentsOfASupervisor(supervisorId);
		//model.addAttribute("students", students);
		return "supervisor/meetingTimes";
	}
}
