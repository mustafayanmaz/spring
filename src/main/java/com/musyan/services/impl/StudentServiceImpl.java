package com.musyan.services.impl;

import com.musyan.entites.Student;
import com.musyan.repository.StudentRepository;
import com.musyan.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }
}
