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
import com.packt.webstore.domain.repository.AdminRepository;
import com.packt.webstore.dto.ChangeSupervisorDTO;

public class AdminRepositoryImpl implements AdminRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Supervisor getSupervisor(int supervisorId) {
		return null;
	}

	@Override
	public boolean changeSupervisor(int studentId, int supervisorId) {
		// change the supervisor id from the students table
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentId", studentId);
		params.put("supervisorId", supervisorId);
		int rowsAffected = jdbcTemplate.update("UPDATE students SET supervisor_id =:supervisorId WHERE student_id = :studentId", params);
		return rowsAffected==0 ? false:true;
	}

	private static final class ChangeSupervisorDTOMapper implements RowMapper<ChangeSupervisorDTO> {

		@Override
		public ChangeSupervisorDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			rs.getInt("student_id");

			return null;
		}

	}
}
