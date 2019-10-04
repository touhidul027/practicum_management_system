package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public int getUserId(String databaseTableName, String userName, String columnName) {
		Map<String, Object> param = new HashMap<String, Object>();

		String sql = "SELECT " + columnName + " FROM " + databaseTableName + " WHERE user_name=" + userName;
		System.out.println(sql);
		int userId = 0;
		try {
			userId = jdbcTemplate.queryForObject(sql, param, Integer.class);
		} catch (Exception e) {
           System.out.println(e.toString());
		}
		return userId;
	}

}
