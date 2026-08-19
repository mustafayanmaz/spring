package com.musyan.services.impl;

import com.musyan.dto.DtoStudent;
import com.musyan.dto.DtoStudentIU;
import com.musyan.entites.Student;
import com.musyan.repository.StudentRepository;
import com.musyan.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);


        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent,response);
        return response;


    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();
       List<Student> studentList = studentRepository.findAllStudents();
       for(Student student : studentList){
           DtoStudent dto = new DtoStudent();
           BeanUtils.copyProperties(student,dto);
           dtoList.add(dto);
       }
       return dtoList;
    }

    @Override
    public DtoStudent getStudentById(int id) {
        DtoStudent dto = new DtoStudent();

        Optional<Student> optinal = studentRepository.findStudentById(id);
        if(optinal.isPresent()) {
            Student dbStudent = optinal.get();
            BeanUtils.copyProperties(dbStudent,dto);
        }
        return dto;
    }

    @Override
    public void deleteStudentById(int id) {

        Optional<Student> optinal = studentRepository.findById(id);
        if(optinal.isPresent()) {
            studentRepository.delete(optinal.get());
        }

    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {

        DtoStudent dto = new DtoStudent();
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            Student dbStudent = optional.get();

            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent,dto);
            return dto;
        }

        return null;

    }
}
