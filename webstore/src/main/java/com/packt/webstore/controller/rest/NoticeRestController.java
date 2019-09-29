package com.packt.webstore.controller.rest;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.packt.webstore.dto.NoticeDTO;
import com.packt.webstore.service.AdminService;
import com.packt.webstore.service.NoticeService;
import com.packt.webstore.service.UserService;

@RestController
@RequestMapping("/rest/notice")
public class NoticeRestController {

	@Autowired
	UserService userService;
	
	@Autowired
	NoticeService noticeService ;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Map<Long, NoticeDTO> getSentNotices(Principal principal) {
		String email = principal.getName();
		int publisherId = userService.getUserId(email);
		Map<Long, NoticeDTO> noticeDTOs = noticeService.getNotices(publisherId);
		return null;
	}

}
