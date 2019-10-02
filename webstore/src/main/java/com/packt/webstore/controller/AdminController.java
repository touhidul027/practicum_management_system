package com.packt.webstore.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.dto.NoticeDTO;
import com.packt.webstore.service.DeptAdminService;
import com.packt.webstore.service.NoticeService;
import com.packt.webstore.service.StudentService;
import com.packt.webstore.service.SupervisorService;
import com.packt.webstore.service.graph.CanvasjsChartService;
import com.packt.webstore.service.graph.ChartService;
import com.packt.webstore.service.impl.DeptAdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private StudentService studentService;

	@Autowired
	SupervisorService supervisorService;
	
	@Autowired 
	NoticeService noticeService ;
	
	@Autowired
	private ChartService chartService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String studentsPage(Model model) {
		model.addAttribute("students", studentService.getStudents());
		return "admin/students";
	}

	@RequestMapping(value = "/asignSupervisorManually", method = RequestMethod.GET)
	public String asignStudentToSupervisorManually() {
		return "admin/asignSupervisorManually";
	}

	@RequestMapping(value = "/supervisors", method = RequestMethod.GET)
	public String supervisorList(Model model) {
		List<Supervisor> supervisors = supervisorService.getSupervisors();
		model.addAttribute("supervisors", supervisors);
		return getFullViewName("supervisors");
	}

	@RequestMapping(value = "/getSupervisor/{id}", method = RequestMethod.GET)
	public String supervisor(Model model, @PathVariable(value = "id") String id) {
		Supervisor supervisor = supervisorService.getSupervisor(Integer.parseInt(id));
		model.addAttribute("supervisor", supervisor);
		return getFullViewName("supervisor");
	}

	@RequestMapping(value = "/studentPerformance", method = RequestMethod.GET)
	public String studentPerformance(ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = chartService.getChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		
		return "admin/studentPerformance";
	}

	@RequestMapping(value = "/changeSupervisor", method = RequestMethod.GET)
	public String change() {
		return "admin/changeSupervisor";
	}

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(HttpServletRequest req,Model model,Principal principal ) {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setFrom(principal.getName());
		model.addAttribute("noticeDTO", noticeDTO);
		return "admin/notice";
	}

	@RequestMapping(value = "/notice", method = RequestMethod.POST)
	public String saveNotice(Model model, Principal principal, @ModelAttribute("noticeDTO") NoticeDTO noticeDTO) {
		System.out.println(noticeDTO);
		noticeDTO.setNoticeId(1001);
		noticeDTO.setPublisherId(1510);
		//noticeDTO.setFrom("academicstudy0001cplus@gmail.com");
		noticeDTO.setFrom("15103199@iubat.edu");//working- cause,no 2 factor authentication
		//providing password here
		noticeDTO.setMailPassword("");//working- cause,no 2 factor authentication
		boolean flag=noticeService.saveNotice(noticeDTO);
		
		return "redirect:/admin/notice";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message() {
		return "admin/message";
	}

	@RequestMapping(value = "/requestedSchedule", method = RequestMethod.GET)
	public String requestedSchedule() {
		return "admin/requestedSchedule";
	}

	@RequestMapping(value = "/setting", method = RequestMethod.GET)
	public String setting() {
		return "admin/setting";
	}

	@RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET)
	public String getStudent(Model model, @PathVariable(value = "id") String id) {
		System.out.println("admin controller");
		model.addAttribute("student", studentService.getStudentById(Integer.parseInt(id)));
		return getFullViewName("student");
	}

	public String getFullViewName(String viewName) {
		return "admin/" + viewName;
	}
}
