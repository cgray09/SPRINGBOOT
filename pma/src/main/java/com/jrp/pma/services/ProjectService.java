package com.jrp.pma.services;

import java.util.List;

import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.TimeChartData;
import com.jrp.pma.entities.Project;

public interface ProjectService {
		
	public void save(Project theProject);
	
	public List<Project> getAll();
	
	public List<ChartData> getProjectStatus();
	
	public List<TimeChartData> getTimeData();
		
	
}
