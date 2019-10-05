package com.packt.webstore.domain.repository.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.packt.webstore.controller.StudentController;
import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.repository.ProjectProposalRepository;

public class ProjectProposalRepositoryImpl implements ProjectProposalRepository{
	private static final Logger logger = Logger.getLogger(StudentController.class);

	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public boolean saveprojectProposal(int studentId, int supervisorId,ProjectProposal projectProposal) {		
		Map<String, Object> paramMaps = new HashMap<String, Object>();
		paramMaps.put("studentId", studentId);
		paramMaps.put("supervisorId", supervisorId);
		paramMaps.put("is_confirmed", 0);
		paramMaps.put("first_sent_time",555555);
		paramMaps.put("last_sent_time", 5555555);
		paramMaps.put("supervisor_comment", "no comment yet");
		paramMaps.put("revisions", 1);
		paramMaps.put("project_title", projectProposal.getProjectTitle());
		paramMaps.put("project_for", projectProposal.getProjectFor());
		paramMaps.put("project_doing_at", projectProposal.getProjectDoingAt());
		paramMaps.put("objective", projectProposal.getObjective());
		paramMaps.put("technological_stacks", projectProposal.getTechnologicalStacks());
		paramMaps.put("modules", projectProposal.getModules());
		paramMaps.put("actors", projectProposal.getActors());
		paramMaps.put("functional_requirements", projectProposal.getFunctionalRequirements());
		
		String sql = "INSERT INTO project_proposals("
		+ "tbl_id,student_id,supervisor_id, is_confirmed,first_sent_time,\r\n" + 
		"last_sent_time,revisions, supervisor_comment, project_title,project_for,"
		+ "project_doing_at,objective,technological_stacks,modules,actors,functional_requirements)"
		+ "VALUES(DEFAULT,:studentId,:supervisorId,:is_confirmed,:first_sent_time,:last_sent_time,:revisions,:supervisor_comment,\r\n" + 
		":project_title,:project_for,:project_doing_at ,:objective,\r\n" + 
		":technological_stacks,:modules,:actors,:functional_requirements)";
		
		int affectedRow = jdbcTemplate.update(sql, paramMaps);
		logger.info(affectedRow);
		
		return affectedRow==0?false:true;
	}

}
