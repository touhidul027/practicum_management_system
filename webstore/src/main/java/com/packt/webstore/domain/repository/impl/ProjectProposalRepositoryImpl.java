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
		paramMaps.put("is_submitted", projectProposal.getFunctionalRequirements());

		String sql = "INSERT INTO project_proposals("
				+ "tbl_id,student_id,supervisor_id, is_confirmed,first_sent_time,\r\n"
				+ "last_sent_time,revisions, supervisor_comment, project_title,project_for,"
				+ "project_doing_at,objective,technological_stacks,modules,actors,functional_requirements,is_submitted)"
				+ "VALUES(DEFAULT,:studentId,:supervisorId,:is_confirmed,:first_sent_time,:last_sent_time,:revisions,:supervisor_comment,\r\n"
				+ ":project_title,:project_for,:project_doing_at ,:objective,\r\n"
				+ ":technological_stacks,:modules,:actors,:functional_requirements,:is_submitted)";

		int affectedRow = jdbcTemplate.update(sql, paramMaps);
		logger.info(affectedRow);

		return affectedRow == 0 ? false : true;
	}

	@Override
	public boolean isStudentProjectProposalExist(long studentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("studentId", studentId);
		logger.info("Student Id : " + studentId);
		int rows = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM project_proposals WHERE student_id=:studentId",
				param, Integer.class);
		logger.info(rows);
		return rows != 0;
	}

	@Override
	public ProjectProposalDto getStudentProjectProposal(long studentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("studentId", studentId);
		ProjectProposalDto projectProposalDto = (ProjectProposalDto) jdbcTemplate.queryForObject(
				"SELECT * FROM project_proposals  WHERE student_id=:studentId", param, new ProjectProposalDtoMapper());
		logger.info(this.getClass() + " " + projectProposalDto);
		return projectProposalDto;
	}

	private static final class ProjectProposalDtoMapper implements RowMapper<ProjectProposalDto> {

		@Override
		public ProjectProposalDto mapRow(ResultSet rs, int arg1) throws SQLException {
			ProjectProposalDto projectProposalDto = new ProjectProposalDto();
			projectProposalDto.setSupervisorId(rs.getLong("supervisor_id"));
			logger.info(rs.getInt("is_confirmed"));
			projectProposalDto.setConfirmed(rs.getInt("is_confirmed") != 0);
			logger.info(projectProposalDto.isConfirmed());
			projectProposalDto.setFirstLongTime(rs.getLong("first_sent_time"));
			projectProposalDto.setLastLongTime(rs.getLong("last_sent_time"));
			projectProposalDto.setSupervisorComment(rs.getString("supervisor_comment"));
			projectProposalDto.setRevisons(rs.getInt("revisions"));
			projectProposalDto.setProjectTitle(rs.getString("project_title"));
			projectProposalDto.setProjectDoingAt(rs.getString("project_doing_at"));
			projectProposalDto.setProjectFor(rs.getString("project_for"));
			projectProposalDto.setObjective(rs.getString("objective"));
			projectProposalDto.setTechnologicalStacks(rs.getString("technological_stacks"));
			projectProposalDto.setModules(rs.getString("modules"));
			projectProposalDto.setActors(rs.getString("actors"));
			projectProposalDto.setFunctionalRequirements(rs.getString("functional_requirements"));
			int isSubmittedValue = rs.getInt("is_submitted");
			logger.info("getting isSubmittedValue "+isSubmittedValue);
			projectProposalDto.setSubmitted(isSubmittedValue==0?false:true);
			logger.info("isSubmittedValue flag : " + projectProposalDto.isSubmitted());
			return projectProposalDto;
		}
	}

	@Override
	public boolean saveprojectProposal(ProjectProposalDto projectProposalDto) {
		Map<String, Object> paramMaps = new HashMap<String, Object>();
		paramMaps.put("studentId", projectProposalDto.getStudentId());
		paramMaps.put("supervisorId", projectProposalDto.getSupervisorId());
		paramMaps.put("is_confirmed", 0);
		paramMaps.put("first_sent_time", projectProposalDto.getFirstLongTime());
		paramMaps.put("last_sent_time", projectProposalDto.getLastLongTime());
		paramMaps.put("supervisor_comment", "");
		paramMaps.put("revisions", 0);
		paramMaps.put("project_title", projectProposalDto.getProjectTitle());
		paramMaps.put("project_for", projectProposalDto.getProjectFor());
		paramMaps.put("project_doing_at", projectProposalDto.getProjectDoingAt());
		paramMaps.put("objective", projectProposalDto.getObjective());
		paramMaps.put("technological_stacks", projectProposalDto.getTechnologicalStacks());
		paramMaps.put("modules", projectProposalDto.getModules());
		paramMaps.put("actors", projectProposalDto.getActors());
		paramMaps.put("functional_requirements", projectProposalDto.getFunctionalRequirements());
		paramMaps.put("is_submitted", 0);

		String sql = "INSERT INTO project_proposals("
				+ "tbl_id,student_id,supervisor_id, is_confirmed,first_sent_time,\r\n"
				+ "last_sent_time,revisions, supervisor_comment, project_title,project_for,"
				+ "project_doing_at,objective,technological_stacks,modules,actors,functional_requirements,is_submitted)"
				+ "VALUES(DEFAULT,:studentId,:supervisorId,:is_confirmed,:first_sent_time,:last_sent_time,:revisions,:supervisor_comment,\r\n"
				+ ":project_title,:project_for,:project_doing_at ,:objective,\r\n"
				+ ":technological_stacks,:modules,:actors,:functional_requirements,:is_submitted)";

		int affectedRow = jdbcTemplate.update(sql, paramMaps);
		logger.info("Project proposal insertion : " + affectedRow);

		return affectedRow == 0 ? false : true;
	}

	@Override
	public boolean updateProjectProposal(ProjectProposalDto projectProposalDto) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentId", projectProposalDto.getStudentId());
		params.put("first_sent_time", projectProposalDto.getFirstLongTime());
		params.put("last_sent_time", projectProposalDto.getLastLongTime());
		params.put("revisions", projectProposalDto.getRevisons());
		params.put("supervisor_comment", projectProposalDto.getSupervisorComment());
		params.put("project_title", projectProposalDto.getProjectTitle());
		params.put("project_for", projectProposalDto.getProjectFor());
		params.put("project_doing_at", projectProposalDto.getProjectDoingAt());
		params.put("objective", projectProposalDto.getObjective());
		params.put("technological_stacks", projectProposalDto.getTechnologicalStacks());
		params.put("modules", projectProposalDto.getModules());
		params.put("actors", projectProposalDto.getActors());
		params.put("functional_requirements", projectProposalDto.getFunctionalRequirements());
		boolean flag = projectProposalDto.isSubmitted();
		logger.info("flag : " + flag);
		int isSubmitted = (flag == false) ? 0 : 1;
		logger.info("isSubmitted : " + isSubmitted);
		params.put("is_submitted", isSubmitted);

		int rowsAffected = jdbcTemplate.update("UPDATE project_proposals SET  first_sent_time=:first_sent_time, "
				+ "revisions=:revisions,supervisor_comment=:supervisor_comment,project_title=:project_title,"
				+ "project_for=:project_for,project_doing_at=:project_doing_at,objective=:objective,technological_stacks=:technological_stacks,"
				+ "modules=:modules,actors=:actors,functional_requirements=:functional_requirements,is_submitted=:is_submitted "
				+ "WHERE student_id = :studentId", params);
		return rowsAffected == 0 ? false : true;
	}

	@Override
	public boolean setProjectProposalSubmittedStatus(ProjectProposalDto projectProposalDto) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentId", projectProposalDto.getStudentId());
		params.put("first_sent_time", projectProposalDto.getFirstLongTime());
		logger.info("first_sent_time" + projectProposalDto.getFirstLongTime());
		boolean flag = projectProposalDto.isSubmitted();
		logger.info(" isSubmitted flag : " + flag);
		int isSubmitted = (flag == false) ? 0 : 1;
		logger.info("isSubmitted : " + isSubmitted);
		params.put("is_submitted", isSubmitted);
		
		int rowsAffected = jdbcTemplate.update("UPDATE project_proposals SET first_sent_time=:first_sent_time,is_submitted=:is_submitted WHERE student_id = :studentId", params);
		logger.info("update rowsAffected "+ rowsAffected);
		return rowsAffected==0 ? false:true;
	}
}
