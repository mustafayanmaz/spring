package com.musyan.services;

import com.musyan.dto.DtoStudent;
import com.musyan.dto.DtoStudentIU;
import com.musyan.entites.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU student);


    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(int id);


    public void deleteStudentById(int id);
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
