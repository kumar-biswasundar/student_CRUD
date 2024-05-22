package com.cglia.sms.dao;

import java.util.List;

import com.cglia.sms.model.Student;

public interface StudentDAO {
	
	public Integer save(Student student);
	
	public Student getByRollNo(Integer rollNo);
	
	public int update(Student student);
	
	public int deleteByRollNO(Integer rollNo);
	
	public List<Student> getAll();
}
