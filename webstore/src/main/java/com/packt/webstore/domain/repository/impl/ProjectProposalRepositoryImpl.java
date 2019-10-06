package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.packt.webstore.controller.StudentController;
import com.packt.webstore.domain.ProjectProposal;
import com.packt.webstore.domain.repository.ProjectProposalRepository;
import com.packt.webstore.dto.ProjectProposalDto;

public class ProjectProposalRepositoryImpl implements ProjectProposalRepository {
	private static final Logger logger = Logger.getLogger(ProjectProposalRepositoryImpl.class);

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public boolean saveprojectProposal(int studentId, int supervisorId, ProjectProposal projectProposal) {
		Map<String, Object> paramMaps = new HashMap<String, Object>();
		paramMaps.put("studentId", studentId);
		paramMaps.put("supervisorId", supervisorId);
		paramMaps.put("is_confirmed", 0);
		paramMaps.put("first_sent_time", 555555);
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
				+ "tbl_id,student_id,supervisor_id, is_confirmed,first_sent_time,\r\n"
				+ "last_sent_time,revisions, supervisor_comment, project_title,project_for,"
				+ "project_doing_at,objective,technological_stacks,modules,actors,functional_requirements)"
				+ "VALUES(DEFAULT,:studentId,:supervisorId,:is_confirmed,:first_sent_time,:last_sent_time,:revisions,:supervisor_comment,\r\n"
				+ ":project_title,:project_for,:project_doing_at ,:objective,\r\n"
				+ ":technological_stacks,:modules,:actors,:functional_requirements)";

		int affectedRow = jdbcTemplate.update(sql, paramMaps);
		logger.info(affectedRow);

		return affectedRow == 0 ? false : true;
	}

	@Override
	public boolean isStudentProjectProposalExist(int studentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("studentId", studentId);
		logger.info("Student Id : " + studentId );
		int rows = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM project_proposals WHERE student_id=:studentId",
				param, Integer.class);
		logger.info(rows);
		return rows != 0;
	}

	@Override
	public ProjectProposalDto getStudentProjectProposal(int studentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("studentId", studentId);
		ProjectProposalDto projectProposalDto = (ProjectProposalDto) jdbcTemplate.queryForObject(
				"SELECT * FROM project_proposals  WHERE student_id=:studentId", param, new ProjectProposalDtoMapper());
		logger.info(projectProposalDto);
		return projectProposalDto;
	}

	private static final class ProjectProposalDtoMapper implements RowMapper<ProjectProposalDto> {

		@Override
		public ProjectProposalDto mapRow(ResultSet rs, int arg1) throws SQLException {
			ProjectProposalDto projectProposalDto = new ProjectProposalDto();
			projectProposalDto.setSupervisorId(rs.getLong("supervisor_id"));
			projectProposalDto.setProjectDoingAt(rs.getString("project_doing_at"));
			return projectProposalDto;
		}
	}
}
