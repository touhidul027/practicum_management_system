package com.packt.webstore.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.Student;
import com.packt.webstore.domain.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public Student getStudent(int id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		Student student = (Student) jdbcTemplate.queryForObject("SELECT * FROM students WHERE id=:id", param,
				new StudentMapper());
		return student;
	}

	public List<Student> getStudents() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Student> students = jdbcTemplate.query("SELECT * FROM students", params, new StudentMapper());
		System.out.println(students.toString());
		return students;
	}

	private static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int arg1) throws SQLException {
			Student student = new Student();
			student.setId(rs.getInt("id"));
			student.setUserName(rs.getString("user_name"));
			student.setSupervisor(rs.getString("supervisor"));
			return student;
		}
	}

}
