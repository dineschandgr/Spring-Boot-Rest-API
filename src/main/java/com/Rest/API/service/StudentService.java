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

      /*  Student s1 = new Student("John", "R111", "12345", new Date(1985,04,04));
        Student s2 = new Student("Rebecca", "R112", "12345", new Date(1975,04,04));
        Student s3 = new Student("Alex", "R113", "12345", new Date(1965,04,04));
        return List.of(s1,s2,s3);*/

        return studentRespository.findAll();

    }

    public Student getStudent(Long id){
         Optional<Student> maybeStudent = studentRespository.findById(id);
         return maybeStudent.orElse(null);
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
