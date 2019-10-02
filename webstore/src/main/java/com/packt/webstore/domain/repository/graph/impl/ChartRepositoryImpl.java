package com.packt.webstore.domain.repository.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.repository.graph.ChartRepository;

public class ChartRepositoryImpl implements ChartRepository{

	@Override
	public List<List<Map<Object, Object>>> getChartData() {
		// TODO Auto-generated method stub
		return CanvasjsChartData.getChartData();
	}
	private static class CanvasjsChartData {

		public static List<List<Map<Object, Object>>> getChartData() {
			Map<Object, Object> map = null;
			List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
			List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();

			map = new HashMap<Object, Object>();
			map.put("label", "Need Improvement");
			map.put("y", 5);
			dataPoints1.add(map);
			map = new HashMap<Object, Object>();
			map.put("label", "Satisfactory");
			map.put("y", 15);
			dataPoints1.add(map);
			map = new HashMap<Object, Object>();
			map.put("label", "Acheive Good");
			map.put("y", 50);
			dataPoints1.add(map);
			map = new HashMap<Object, Object>();
			map.put("label", "Excellent 90-100 Score");
			map.put("y", 30);
			dataPoints1.add(map);
			list.add(dataPoints1);			
			return list;
		}
	}
}
