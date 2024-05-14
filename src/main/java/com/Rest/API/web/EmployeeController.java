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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //http://localhost:8090/employee
    @GetMapping
    public List<Employee> getAllEmployees(){
        List<Employee> EmployeeList =  employeeService.getAllEmployees();
        return EmployeeList;
    }

    //http://localhost:8090/employee/id/1
    @GetMapping("{id}")
    public Employee getAllEmployee(@PathVariable Long id){
        return  employeeService.getEmployee(id);
    }

    //http://localhost:8090/employee/address
    @GetMapping("address")
    public List<Employee> findEmployeesWithAddress(@RequestParam int age){
        return employeeService.findEmployeesWithAddress(age);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }


    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("delete success");
    }
}
