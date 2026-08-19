package com.musyan.repository;

import com.musyan.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


    //query methodlarımız buraya yazılacak

    //HQL : sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır
    //SQL : tablo ismi ve tablo içindeki kolon isimleri ile sorgular yazılır
    //nativeQuery true olursa sql yazılır
    //@Query(value = "select * from student.student", nativeQuery = true)
    @Query(value = "from Student", nativeQuery = false)
    List<Student> findAllStudents();

    @Query(value = "from Student s WHERE s.id = :studentId")
    Optional<Student> findStudentById(Integer studentId);

}
