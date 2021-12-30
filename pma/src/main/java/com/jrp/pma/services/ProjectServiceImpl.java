package com.jrp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrp.pma.dao.ProjectRepository;
import com.jrp.pma.dto.ChartData;
import com.jrp.pma.dto.TimeChartData;
import com.jrp.pma.entities.Project;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository proRepo;
	
	
	@Override
	public void save(Project project) {
		 proRepo.save(project);
	}

	@Override
	public List<Project> getAll() {
		return proRepo.findAll();
	}
	
	@Override
	public List<ChartData> getProjectStatus(){
		return proRepo.getProjectStatus();
	}
	
	@Override
	public List<TimeChartData> getTimeData(){
		return proRepo.getTimeData();
	}
}
