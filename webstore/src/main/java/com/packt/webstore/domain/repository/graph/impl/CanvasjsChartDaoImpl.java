package com.packt.webstore.domain.repository.graph.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.repository.graph.CanvasjsChartDao;

public class CanvasjsChartDaoImpl implements CanvasjsChartDao {
	@Override
	public List<List<Map<Object, Object>>> getCanvasjsChartData() {
		return CanvasjsChartData.getCanvasjsDataList();
	}

	private static class CanvasjsChartData {

		public static List<List<Map<Object, Object>>> getCanvasjsDataList() {
			Map<Object, Object> map = null;
			List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
			List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();

			map = new HashMap<Object, Object>();
			map.put("label", "18 yrs and Under");
			map.put("y", 7);
			dataPoints1.add(map);
			map = new HashMap<Object, Object>();
			map.put("label", "19 to 32 yrs");
			map.put("y", 51);
			dataPoints1.add(map);
			map = new HashMap<Object, Object>();
			map.put("label", "32 to 45 yrs");
			map.put("y", 12);
			dataPoints1.add(map);
			map = new HashMap<Object, Object>();
			map.put("label", "45 to 60 yrs");
			map.put("y", 17);
			dataPoints1.add(map);
			map = new HashMap<Object, Object>();
			map.put("label", "60 yrs and over");
			map.put("y", 13);
			dataPoints1.add(map);

			list.add(dataPoints1);

			return list;
		}
	}
}
