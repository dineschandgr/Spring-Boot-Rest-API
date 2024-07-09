package com.Rest.API.service;


import com.Rest.API.dao.EmployeeRepository;
import com.Rest.API.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository EmployeeRespository;

    public List<Employee> getAllEmployees(){
        return EmployeeRespository.findAll();
    }

    public Employee getEmployee(Long id){
         Optional<Employee> maybeEmployee = EmployeeRespository.findById(id);
         return maybeEmployee.orElse(null);
    }

    public List<Employee> findEmployeesWithAddress(int age){
        return EmployeeRespository.findEmployeeWithAddress(age);
    }

    public Employee createEmployee(Employee employee){

        Address address1 = Address.builder().streetName("aaaa").postalCode("sss").build();
        address1 = addressService.createAddress(address1);

        //use for 1 to 1 mapping

        employee.setAddress(address1);

        //use for 1 to many mapping
     /*   Address address2 = Address.builder().streetName("aaaa").postalCode("sss").build();
        address2 = addressService.createAddress(address2);
        List<Address> addressList = List.of(address1,address2);
        Employee.setAddressList(addressList);*/
        return EmployeeRespository.save(employee);
        
        return EmployeeRespository.save(Employee);
    }

    public Employee updateEmployee(Long id, Employee employee){

        boolean EmployeeExist = EmployeeRespository.existsById(id);

        if(EmployeeExist){
            return EmployeeRespository.save(employee);
        }

       return null;

    }

    public void deleteEmployee(Long id){

        boolean EmployeeExist = EmployeeRespository.existsById(id);

        if(EmployeeExist){
            EmployeeRespository.deleteById(id);
        }

    }
}
