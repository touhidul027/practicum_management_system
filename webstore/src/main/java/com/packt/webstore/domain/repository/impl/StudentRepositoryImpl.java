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
import com.packt.webstore.domain.Supervisor;
import com.packt.webstore.domain.repository.StudentRepository;
import com.packt.webstore.domain.repository.SupervisorRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private SupervisorRepository supervisorRepository;

	@Override
	public Student getStudent(int studentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("studentId", studentId);
		Student student = (Student) jdbcTemplate.queryForObject("SELECT * FROM students WHERE student_id=:studentId",
				param, new StudentMapper());
		return student;
	}

	@Override
	public Student getStudentByEmail(String studentEmail) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("studentEmail", studentEmail);
		Student student = (Student) jdbcTemplate.queryForObject("SELECT * FROM students WHERE student_email=:studentEmail LIMIT 1",
				param, new StudentMapper());
		return student;
	}

	public List<Student> getStudents() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Student> students = jdbcTemplate.query("SELECT * FROM students", params, new StudentMapper());
		return students;
	}

	@Override
	public Supervisor getStudentSupervisor(int studentId) {
		// fetch supervisor id from the students table
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("studentId", studentId);
		int supervisorId = jdbcTemplate.queryForObject(
				"select supervisor_id from students WHERE student_id=:studentId LIMIT 1", param, Integer.class);
		return supervisorRepository.getSupervisor(supervisorId);
	}

	@Override
	public boolean registerStudent(int studentId, String studentName, String studentEmail, String department) {
		Map<String, Object> paramMaps = new HashMap<String, Object>();
		paramMaps.put("studentId", studentId);
		paramMaps.put("studentName", studentName);
		paramMaps.put("studentEmail", studentEmail);
		paramMaps.put("department", department);
		paramMaps.put("supervisorId", 0);
		String sql = "INSERT INTO students(student_id,user_name,student_email,student_department,supervisor_id)"
				+ " VALUES(:studentId, :studentName, :studentEmail, :department,:supervisorId)";
		int affectedRow = jdbcTemplate.update(sql, paramMaps);

		return affectedRow == 0 ? false : true;
	}

	private static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int arg1) throws SQLException {
			Student student = new Student();
			student.setStudentId(rs.getInt("student_id"));
			student.setUserName(rs.getString("user_name"));
			student.setStudentEmail(rs.getString("student_email"));
			student.setStudentDepartment(rs.getString("student_department"));
			student.setCellPhone(rs.getString("cell_phone_number"));
			student.setPassword(rs.getString("password"));
			return student;
		}
	}

	@Override
	public boolean updateStudent(int studentId,String cellPhone, String password) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentId", studentId);
		params.put("cell_phone_number", cellPhone);
		params.put("password", password);
		int rowsAffected = jdbcTemplate.update("UPDATE students SET cell_phone_number =:cell_phone_number, password=:password WHERE student_id = :studentId", params);
		return rowsAffected==0 ? false:true;
	}

}
