package com.Rest.API.web;


import com.Rest.API.model.Employee;
import com.Rest.API.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> EmployeeList =  employeeService.getAllEmployees();
        return ResponseEntity.ok(EmployeeList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getAllEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee Employee){
       return employeeService.createEmployee(Employee);
    }


    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee Employee){
        return employeeService.updateEmployee(id, Employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("delete success");
    }
}
