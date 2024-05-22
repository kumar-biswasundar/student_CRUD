package com.cglia.sms.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cglia.sms.dao.StudentDAO;
import com.cglia.sms.model.Student;
import com.cglia.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO StudentDAO;

    @Override
    public Integer saveStudent(Student student) {
        return StudentDAO.save(student);
    }

    @Override
    public Student getStudentByRollNo(Integer rollNo) {
        return StudentDAO.getByRollNo(rollNo);
    }

    @Override
    public int updateStudent(Student student) {
        return StudentDAO.update(student);
    }

    @Override
    public int deleteStudentByRollNo(Integer rollNo) {
        return StudentDAO.deleteByRollNO(rollNo);
    }

    public List<Student> getAllStudents() {
        return StudentDAO.getAll();
    }

}
