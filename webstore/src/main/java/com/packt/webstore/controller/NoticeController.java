package com.packt.webstore.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.dto.NoticeDTO;
import com.packt.webstore.service.NoticeService;
import com.packt.webstore.service.UserService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	UserService userService;
	
	@Autowired
	NoticeService noticeService ;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String allNotices(Model model,Principal principal,SecurityContextHolderAwareRequestWrapper request) {
		String email = principal.getName();
		int publisherId = userService.getUserId(email);//hard-coded
		Map<Long, NoticeDTO> noticeDTOsMap = noticeService.getNotices(publisherId);
		System.out.println(noticeDTOsMap);
		model.addAttribute("noticeDTOsMap", noticeDTOsMap) ;
		return getFullViewName(userService.getViewFolderName(request),"sentNotice");
	}
	
	public String getFullViewName(String folderName,String viewName) {
		return folderName+"/" + viewName;
	}
}
