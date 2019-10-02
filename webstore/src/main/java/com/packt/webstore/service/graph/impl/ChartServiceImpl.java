package com.packt.webstore.service.graph.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.packt.webstore.domain.repository.graph.ChartRepository;
import com.packt.webstore.service.graph.ChartService;

public class ChartServiceImpl implements ChartService{
	@Autowired
	private ChartRepository chartRepository;
 
	public void setCanvasjsChartDao(ChartRepository chartRepository) {
		this.chartRepository = chartRepository;
	}
 
	@Override
	public List<List<Map<Object, Object>>> getChartData() {
		return chartRepository.getChartData();
	}
}
