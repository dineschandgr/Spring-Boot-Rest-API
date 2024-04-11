package com.Rest.API.dao;

import com.Rest.API.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRespository extends JpaRepository<Student, Long> {

    Optional<Student> findByNameIgnoreCaseAndAge(String name, int age);

    Optional<Student> findByNameIgnoreCase(String name);

    Student findByAge(Integer age);
}
