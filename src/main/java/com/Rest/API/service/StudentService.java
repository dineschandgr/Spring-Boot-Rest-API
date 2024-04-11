package com.Rest.API.service;


import com.Rest.API.dao.StudentRespository;
import com.Rest.API.model.Student;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRespository studentRespository;
    public List<Student> getAllStudents(){
        return studentRespository.findAll();
    }

    public Student getStudent(Long id){
         Optional<Student> maybeStudent = studentRespository.findById(id);
         return maybeStudent.orElse(null);
    }

    public Student getStudentByNameAndAge(String name, int age){
        Optional<Student> maybeStudent = studentRespository.findByNameIgnoreCaseAndAge(name, age);
        return maybeStudent.orElse(new Student());
    }

    public Student getStudentByName(String name){
        Optional<Student> maybeStudent = studentRespository.findByNameIgnoreCase(name);
        return maybeStudent.orElse(new Student());
    }

    public Student getStudentByAge(int age){
        return studentRespository.findByAge(age);
    }

    public Student createStudent(Student student){
        Student student1 = studentRespository.save(student);
        return student1;
    }

    public Student updateStudent(Long id, Student student){

        boolean studentExist = studentRespository.existsById(id);

        if(studentExist){
            return studentRespository.save(student);
        }

       return null;

    }

    public void deleteStudent(Long id){

        boolean studentExist = studentRespository.existsById(id);

        if(studentExist){
            studentRespository.deleteById(id);
        }

    }
}
