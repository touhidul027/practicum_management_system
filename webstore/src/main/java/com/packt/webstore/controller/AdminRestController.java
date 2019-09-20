package com.packt.webstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.dto.ChangeSupervisorDTO;
import com.packt.webstore.service.AdminService;
import com.packt.webstore.service.StudentService;

@RestController
@RequestMapping("/rest/admin")
public class AdminRestController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/changeSupervisor/getInfo", method = RequestMethod.POST)
	public @ResponseBody ChangeSupervisorDTO getChangeSupervisorDTO(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String studentId = request.getParameter("studentId");
		ChangeSupervisorDTO changeSupervisorDTO = adminService.getChangeSupervisorDTO(Integer.parseInt(studentId));
		System.out.println(AdminRestController.class);
		System.out.println(changeSupervisorDTO);
		return changeSupervisorDTO;
	}
	
	@RequestMapping(value = "/changeSupervisor/change", method = RequestMethod.POST)
	public @ResponseBody ChangeSupervisorDTO change(HttpServletRequest request, HttpServletResponse response) {
		String studentId = request.getParameter("studentId");
		String supervisorId = request.getParameter("supervisorId");
		ChangeSupervisorDTO changeSupervisorDTO=adminService.changeSupervisor(Integer.parseInt(studentId),Integer.parseInt(supervisorId));
		return changeSupervisorDTO;
	}

}
