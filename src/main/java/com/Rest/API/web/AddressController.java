package com.Rest.API.web;


import com.Rest.API.model.Address;
import com.Rest.API.service.AddressService;
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
import java.util.UUID;

@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddresss(){
        List<Address> AddressList =  addressService.getAllAddress();
        return ResponseEntity.ok(AddressList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Address> getAllAddress(@PathVariable Long id){
        return ResponseEntity.ok(addressService.getAddress(id));
    }

    @PostMapping
    public Address createAddress(@RequestBody Address Address,
                                 @RequestParam(value = "employeeId") Long employeeId){
       return addressService.createAddress(Address, employeeId);
    }


    @PutMapping("{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address Address){
        return addressService.updateAddress(id, Address);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return ResponseEntity.ok("delete success");
    }
}
