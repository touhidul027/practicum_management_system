package com.packt.webstore.controller;

import org.omg.CORBA.Request;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class HomeController {

//	@RequestMapping
//	public String welcome(Model model, RedirectAttributes redirectAttributes) {
//		model.addAttribute("greeting", "Welcome to Web Store!");
//		model.addAttribute("tagline", "The one and only amazing web store");
//
//		redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!");
//		redirectAttributes.addFlashAttribute("tagline", "The one and only amazing web store");
//		    
//		return "redirect:/welcome/greeting";
//	}
//	
//	@RequestMapping("/welcome/greeting")
//	public String greeting() {
//	   return "welcome";
//	}
	
	@RequestMapping
	public String welcome(SecurityContextHolderAwareRequestWrapper request,Model model, RedirectAttributes redirectAttributes,Authentication authentication) {
		String homePageName = null;
		//finding out the user role and send hie to the respective page
		
		//any following pattern is accepted so far
		boolean isAdminisTrator = request.isUserInRole("ROLE_ADMIN");
		boolean isStudent = request.isUserInRole("STUDENT");
		boolean  isSuperVisor=request.isUserInRole("SUPERVISOR");
		
		if(isAdminisTrator==true) {
			homePageName =  "redirect:/admin/adminstrator" ;
		}else if(isSuperVisor==true){
			homePageName ="redirect:/supervisor/supervisor" ;
		}else if(isStudent==true) {
			homePageName = "redirect:/student/student";
		}
		System.out.println(homePageName);
		return homePageName;
	}

	@RequestMapping(value="{userLevel}/{pageName}",method=RequestMethod.GET)
	public String greeting(@PathVariable(value = "userLevel") String userLevel,@PathVariable(value = "pageName") String pageName) {
	   return userLevel+"/"+pageName ;
	}
	
}
