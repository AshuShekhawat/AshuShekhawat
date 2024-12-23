package com.CRUD.UserManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
//@RequestMapping("/api/customers")
public class CustomerController {
	
	@Autowired
	CustomerServiceClass service;
	 @PostMapping("/customer")
	    public ResponseEntity<Customer> createUser(@RequestBody Customer customer) {
		 Customer savedUser = service.saveUser(customer);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    }

	 @GetMapping("/customer")
	    public ResponseEntity<List<Customer>> getAllUsers() {
	        List<Customer> cutomers =service.getAllUsers();
	        return new ResponseEntity<>(cutomers, HttpStatus.OK);
	    }
	 
//	 @GetMapping("/customer/{id}")
//	    public Customer getBYId(@PathVariable("id") Long cId) {
//	    	return service.getCustomerById(cId);
//	    }
	 
	 @GetMapping("/customer/{id}")
	    public ResponseEntity<Customer> getBYId(@PathVariable("id") Long cId) {
	    	Customer customerFindById=service.getCustomerById(cId);
//	    	 return new ResponseEntity<>(customerFindById, HttpStatus.OK);
	    	if (customerFindById != null) {
	            return new ResponseEntity<>(customerFindById, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 //Delete
	 @DeleteMapping("/customer/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable("id") Long cId) {
	        boolean isDeleted = service.deleteUser(cId);
	        if (isDeleted) {
	            return new ResponseEntity<>("Deleted Success",HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>("delete",HttpStatus.NOT_FOUND);
	        }
	    }
	 
	// Update a user by ID
	    @PutMapping("/customer/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long cId, @RequestBody Customer customerDetails) {
	    	Customer updateCustomer = service.updateUser(cId, customerDetails);
	        if (updateCustomer != null) {
	            return new ResponseEntity<>(updateCustomer, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
}
