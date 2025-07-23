package com.oracle.controller;

import java.util.List;import org.apache.catalina.valves.rewrite.InternalRewriteMap.Escape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.exceptions.NoSuchCustomerException;
import com.oracle.exceptions.UniqueIdException;
import com.oracle.model.Customer;
import com.oracle.service.CustomerService;

@RestController
@RequestMapping(path = "customer-api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;

//	// http://localhost:9090/customer-api
//	@PostMapping //allows to read the value
//	public void addCustomer(@RequestBody Customer cust) {
//		service.addCustomer(cust);
//		
//	}
//	
//	// http://localhost:9090/customer-api
//	@PostMapping //allows to read the value
//	public void readAllCustomer(@RequestBody Customer cust) {
//		service.readAllCustomer(cust);
//			
//	}
//	
//	// http://localhost:9090/customer-api
//	@DeleteMapping("/delete{firstName}") //allows to read the value
//	public void deleteCustomer(@RequestParam String firstName) {
//		service.deleteCustomerByFirstName(firstName);
//		
//	}
//		
//	// http://localhost:9090/customer-api
//	@PutMapping //allows to read the value
//	public void updateCustomer(@RequestParam String email) {
//		service.updateCustomer(email);
//		
//	}
	
	// http://localhost:9090/customer-api
//	@PostMapping //allows to read the value
//	public void addCustomer(@RequestBody Customer cust) {			
//		service.addCustomer(cust);
//	}
//		
		
		
	// http://localhost:3030/customer-api
	@GetMapping
	public List<Customer> getAllCustomers() {
		List<Customer> customers = service.findAllCustomers();
		return customers;
	}
	
	// http://localhost:3030/customer-api
	@PostMapping
	public ResponseEntity<String> addCustomer(@RequestBody Customer cust) {
		service.addCustomer(cust);
		ResponseEntity<String> responseEntity = new ResponseEntity<String> ("Customer added successfully", HttpStatus.CREATED);
		return responseEntity;
	}
	
	
	// http://localhost:3030/customer-api/email/jake@gmail.com -path variable
	@GetMapping(path = "/email/{emailId}")
	public Customer getCustomerByEmail(@PathVariable("emailId") String email) {
		return service.findCustomerByEmail(email);
	}
	
	// http://localhost:3030/customer-api/email/jakeee@gmail.com -path variable(wrong path)
	@ExceptionHandler
	public ResponseEntity<String> handleNoSuchCustomerException(NoSuchCustomerException ex) {
		ResponseEntity<String> response = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		return response;
	}
	
	// http://localhost:3030/customer-api/email/jake@gmail.com -path variable(wrong path)
		@ExceptionHandler
		public ResponseEntity<String> handleUniqueIdException(UniqueIdException ex) {
			ResponseEntity<String> response = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
}
