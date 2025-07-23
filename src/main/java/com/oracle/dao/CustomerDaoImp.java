package com.oracle.dao;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.oracle.model.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImp implements CustomerDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void createCustomer(Customer cust) {
		entityManager.persist(cust); //insert a new record
		
	}

	@Override
	public Customer readCustomerbyEmail(String email) {
		return entityManager.find(Customer.class, email); //select that record
	}

	@Override
	public List<Customer> readAllCustomers() {
		String jpql = "SELECT c FROM Customer c "; // c:Table alias
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	@Transactional
	public void deleteCustomerBYFirstName(String firstName) {
	    String jpql = "DELETE FROM Customer c WHERE c.firstName = :firstName";
	    entityManager.createQuery(jpql)
	                 .setParameter("firstName", firstName)
	                 .executeUpdate();
	}


	@Override
	@Transactional
	public void updateCustomer(String email) {
	    Customer cust = readCustomerbyEmail(email);
	    if (cust != null) {
	        cust.setFirstName("UpdatedFirstName");
	        cust.setLastName("UpdatedLastName");
	        // entityManager.merge(cust); // Not needed if managed
	    }
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}


	
}
