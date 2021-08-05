package com.school.app.repos;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.app.pojos.Grade;
import com.school.app.pojos.Student;

@Repository
public class CustomRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertStudent(String name, Grade grade) {
		return jdbcTemplate.update(
		        "INSERT INTO students (name, grade) VALUES (?, ?)",
		        name, grade.toString());
	}

	public Student getStudentByName(String name) {
		String query = "select * from students where name = ?";
		return jdbcTemplate.queryForObject(query, new StudentRowMapper(), name);
	}

	public int deleteStudentByName(String name) {
		return jdbcTemplate.update(
		        "DELETE from students WHERE name = ?", name);
	}
}

class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
    	var student = new Student(
    			rs.getString("name"), 
    			Enum.valueOf(Grade.class, rs.getString("grade")));

        return student;
    }
}
