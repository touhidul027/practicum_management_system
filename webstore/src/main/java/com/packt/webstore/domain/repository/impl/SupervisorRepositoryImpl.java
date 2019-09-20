package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.domain.repository.SupervisorRepository;

public class SupervisorRepositoryImpl implements SupervisorRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Supervisor> getSupervisors() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Supervisor> supervisors = jdbcTemplate.query("SELECT * FROM supervisors", params,
				new SupervisorRowMapper());
		return supervisors;
	}

	@Override
	public Supervisor getSupervisor(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		Supervisor supervisor = (Supervisor) jdbcTemplate
				.queryForObject("SELECT * FROM supervisors WHERE supervisor_id=:id", param, new SupervisorRowMapper());
		return supervisor;
	}

	@Override
	public Supervisor getSupervisorByUserName(String supervisorUserName) {

		System.out.println(SupervisorRepositoryImpl.class + " " + supervisorUserName);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("supervisorUserName", supervisorUserName);
		Supervisor supervisor = (Supervisor) jdbcTemplate.queryForObject(
				"SELECT * FROM supervisors WHERE user_name=:supervisorUserName", param, new SupervisorRowMapper());
		return supervisor;
	}

	private static final class SupervisorRowMapper implements RowMapper<Supervisor> {
		@Override
		public Supervisor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Supervisor supervisor = new Supervisor();
			supervisor.setSupervisorId(rs.getInt("supervisor_id"));// supervisor_id is a db column name
			supervisor.setUserName(rs.getString("user_name"));
			supervisor.setEmail(rs.getNString("email"));
			supervisor.setDepartment(rs.getString("department"));
			return supervisor;
		}
	}
}
