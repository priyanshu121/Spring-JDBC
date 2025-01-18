package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query="insert into student(name, city) values (?,?)";
		int r=this.jdbcTemplate.update(query, student.getName(), student.getCity());
		return r;
	}
	
	
	@Override
	public int update(Student student) {
		String query="update student set name=? , city=? where id=?";
		int r=this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
		return r;
	}
	
	
	@Override
	public int delete(Student student) {
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query, student.getId());
		return r;
	}
	
	@Override
	public Student getStudent(int studentId) {
		// Selecting single student data
		
		String query="Select * from student where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student=this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		return student;
	}

	
	@Override
	public List<Student> getAllStudents() {
		// Selecting multiple student
		String query="Select * from student";
		List<Student> students=this.jdbcTemplate.query(query,new RowMapperImpl());
		
		return students;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}












	
	

}
