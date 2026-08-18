package com.musyan.services;

import com.musyan.entites.Student;

import java.util.List;

public interface IStudentService {
    public Student saveStudent(Student student);


    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public void deleteStudentById(int id);
    public Student updateStudent(Integer id, Student updatedStudent);
}
