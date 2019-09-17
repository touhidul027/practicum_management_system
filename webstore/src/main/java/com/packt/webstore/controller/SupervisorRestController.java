package com.packt.webstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.service.SupervisorService;

@RestController
@RequestMapping("/rest/supervisor")
public class SupervisorRestController {

	@Autowired
	SupervisorService supervisorService;

	@RequestMapping(value="/allExcept", method = RequestMethod.POST)
	public @ResponseBody List<Supervisor> add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String supervisorId = request.getParameter("supervisorId");
		return supervisorService.getSupervisorsExcept(Integer.parseInt(supervisorId));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Supervisor getSupervisorByUserName(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String supervisorUserName = request.getParameter("supervisorUserName");
		System.out.println(supervisorUserName);
		return supervisorService.getSupervisorByUserName(supervisorUserName) ; 
	}
	
}
