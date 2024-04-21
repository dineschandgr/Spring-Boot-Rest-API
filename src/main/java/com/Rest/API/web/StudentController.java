package com.Rest.API.web;


import com.Rest.API.model.Student;
import com.Rest.API.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    private final Logger LOGGER =
            LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList =  studentService.getAllStudents();
        return ResponseEntity.ok(studentList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getAllStudent(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping(params = {"name", "age"})
    public Student getStudentByNameAndAge(@RequestParam(value = "name") String name, @RequestParam(value = "age") int age){

        LOGGER.info("inside getStudentByNameAndAge name: {} age: {} ",name, age);
        System.out.println("inside getStudentByNameAndAge name: "+name + " age: "+age);
        Student student = studentService.getStudentByNameAndAge(name, age);
        LOGGER.debug("student output {} ",student);
        return student;
    }

    @GetMapping(params = {"name"})
    public ResponseEntity<Student> getStudentByName(@RequestParam(value = "name") String name){
        System.out.println("inside getStudentByName name: "+name);
        Student student = studentService.getStudentByName(name);
        System.out.println("inside getStudentByName student: "+student);
        return ResponseEntity.ok(student);
    }

    @GetMapping(params = {"age"})
    public ResponseEntity<Student> getStudentByAge(@RequestParam(value = "age") int age){
        System.out.println("inside getStudentByAge name: "+age);
        return ResponseEntity.ok(studentService.getStudentByAge(age));
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
       return studentService.createStudent(student);
    }


    @PutMapping("{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("delete success");
    }
}
