package com.packt.webstore.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

	@RequestMapping(value = "/proposals", method = RequestMethod.GET)
	public String studentsPage(Model model, Principal principal) {
		model.addAttribute("message", "Developer is working on this feature.");
		return getFullViewName("proposals");
	}

	public String getFullViewName(String viewName) {
		return "supervisor/" + viewName;
	}
}
