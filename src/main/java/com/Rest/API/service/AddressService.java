package com.Rest.API.service;


import com.Rest.API.dao.AddressRepository;
import com.Rest.API.dao.EmployeeRepository;
import com.Rest.API.model.Address;
import com.Rest.API.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    EmployeeRepository employeeRepository;
    
    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

    public Address getAddress(Long id){
         Optional<Address> mayBeAddress = addressRepository.findById(id);
         return mayBeAddress.orElse(null);
    }

    public Address createAddress(Address address, Long employeeId){
        Employee employee = employeeRepository.findById(employeeId).orElse(new Employee());
        address.setEmployee(employee);
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address address){

        boolean addressExist = addressRepository.existsById(id);

        if(addressExist){
            return addressRepository.save(address);
        }

       return null;

    }

    public void deleteAddress(Long id){

        boolean addressExist = addressRepository.existsById(id);

        if(addressExist){
            addressRepository.deleteById(id);
        }

    }
}
