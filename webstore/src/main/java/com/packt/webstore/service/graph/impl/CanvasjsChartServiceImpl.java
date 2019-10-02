package com.packt.webstore.service.graph.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.domain.repository.graph.CanvasjsChartDao;
import com.packt.webstore.service.graph.CanvasjsChartService;

public class CanvasjsChartServiceImpl implements CanvasjsChartService{

	@Autowired
	private CanvasjsChartDao canvasjsChartDao;
 
	public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
		this.canvasjsChartDao = canvasjsChartDao;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return canvasjsChartDao.getCanvasjsChartData();
	}

}
