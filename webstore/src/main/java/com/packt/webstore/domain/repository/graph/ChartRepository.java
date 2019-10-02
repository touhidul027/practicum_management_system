package com.packt.webstore.domain.repository.graph;

import java.util.List;
import java.util.Map;

public interface ChartRepository {
	List<List<Map<Object, Object>>> getChartData();

}
