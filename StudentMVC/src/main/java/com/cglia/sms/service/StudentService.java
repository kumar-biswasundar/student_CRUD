package com.cglia.sms.service;

import java.util.List;


import com.cglia.sms.model.Student;

public interface StudentService {
	
	public Integer saveStudent(Student student);

	public Student getStudentByRollNo(Integer rollNo);

	public int updateStudent(Student student);

	public int deleteStudentByRollNo(Integer rollNo);

	public List<Student> getAllStudents();
}
