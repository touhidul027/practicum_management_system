package com.packt.webstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packt.webstore.service.graph.CanvasjsChartService;

@Controller
@RequestMapping("/graph")
public class GraphController {
	@Autowired
	private CanvasjsChartService canvasjsChartService;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String studentPerformance(ModelMap modelMap) {
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		modelMap.addAttribute("dataPointsList", canvasjsDataList);
		
		return "graph/show";
	}
}
