package com.musyan.services.impl;

import com.musyan.entites.Student;
import com.musyan.repository.StudentRepository;
import com.musyan.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
       List<Student> studentList = studentRepository.findAll();
       return studentList;
    }

    @Override
    public Student getStudentById(int id) {
        Optional<Student> optinal = studentRepository.findById(id);
        if(optinal.isPresent()) {
            return optinal.get();
        }
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        Student dbStudent =getStudentById(id);
        if(dbStudent != null) {
            studentRepository.delete(dbStudent);
        }
    }

    @Override
    public Student updateStudent(Integer id, Student updatedStudent) {
        Student dbStudent =getStudentById(id);
        if(dbStudent != null) {
            dbStudent.setFirstName(updatedStudent.getFirstName());
            dbStudent.setLastName(updatedStudent.getLastName());
            dbStudent.setBirthOfDate(updatedStudent.getBirthOfDate());

            return studentRepository.save(dbStudent);
        }
        return null;
    }
}
