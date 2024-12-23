package com.CRUD.UserManagement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CustomerServiceClass  {
	
	@Autowired
	CustomerRepo repo;
	 public Customer saveUser(Customer customer) {
	        return repo.save(customer);
	    }
	 // Get all users
	    public List<Customer> getAllUsers() {
	        return repo.findAll();
	    }
		public Customer getCustomerById(Long cId) {
			// TODO Auto-generated method stub
			return repo.findById(cId).get();
		}
	 
	 // Get a user by ID
		public boolean deleteUser(Long cId) {
	        Optional<Customer> userOptional = repo.findById(cId);

	        if (userOptional.isPresent()) {
	            repo.deleteById(cId);
	            return true;
	        }
	        return false;
	    }
	    
		// Update a user by ID
	    public Customer updateUser(Long cId, Customer customerDetails) {
	        Optional<Customer> userOptional = repo.findById(cId);

	        if (userOptional.isPresent()) {
	        	Customer customer = userOptional.get();
	        	customer.setcName(customerDetails.getcName());
	        	customer.setcEmail(customerDetails.getcEmail());
	            return repo.save(customer);
	        }
	        return null;
	    }
	    
}
