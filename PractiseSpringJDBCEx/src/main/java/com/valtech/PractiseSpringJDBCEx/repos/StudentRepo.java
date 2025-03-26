package com.valtech.PractiseSpringJDBCEx.repos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.valtech.PractiseSpringJDBCEx.models.Student;

//Repo is responsible to store data in database.
@Repository
public class StudentRepo {
	@Autowired
	private JdbcTemplate jdbc;
	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	public JdbcTemplate getJdbc() {
		return jdbc;
	}
	
	public void save(Student s) {
		String sql="insert into student(rollno,name,marks) values (?,?,?)";
		int rows =jdbc.update(sql, s.getRollno(),s.getName(),s.getMarks());
		System.out.println(rows+ " Row affected");
	}

	public List<Student> findAll() {
		
		String sql="select * from student";
		RowMapper<Student> mapper=new RowMapper<Student>() {//interface need to implement mapRow method.
			//mapRow give one row at a time from resultSet
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws java.sql.SQLException {
				Student s=new Student();
				s.setRollno(rs.getInt("rollno"));
				s.setName(rs.getString("name"));
				s.setMarks(rs.getInt("marks"));
				return s;
			}
		};
		
		List<Student> students=jdbc.query(sql, mapper);
		return students;
	}

}
