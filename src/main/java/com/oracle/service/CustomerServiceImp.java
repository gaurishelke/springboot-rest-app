package com.oracle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.dao.CustomerDao;
import com.oracle.exceptions.NoSuchCustomerException;
import com.oracle.exceptions.UniqueIdException;
import com.oracle.model.Customer;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerDao dao;
	
	@Override
	public void addCustomer(Customer cust) {
		Customer existingCustomer = dao.readCustomerbyEmail(cust.getEmail());		
		if(existingCustomer != null) {
			throw new UniqueIdException("Customer with email " + cust.getEmail() +" already present");
		}
		dao.createCustomer(cust);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		Customer customer = dao.readCustomerbyEmail(email);
		if(customer == null) {
			throw new NoSuchCustomerException("Customer with email " + email +"not found");
		}
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return dao.readAllCustomers();
	}

	@Override
	public void deleteCustomer(String firstName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomerByFirstName(String firstName) {
		// TODO Auto-generated method stub
		
	}

}

