package com.oracle.dao;

import java.util.List;

import com.oracle.model.Customer;

public interface CustomerDao {

	public void createCustomer(Customer cust);
	public Customer readCustomerbyEmail(String email);
	public List<Customer> readAllCustomers();
	public void deleteCustomer(Customer cust);
	public void updateCustomer(String email);
	void deleteCustomerBYFirstName(String firstName);
}
