package com.example.demo.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.student.Student;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>{
    Optional<Student> findStudentByEmail(String email);
}