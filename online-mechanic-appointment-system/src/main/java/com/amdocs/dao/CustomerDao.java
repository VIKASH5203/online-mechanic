package com.amdocs.dao;

import java.sql.SQLException;
import java.util.List;

import com.amdocs.entity.Customer;
import com.amdocs.exceptions.CustomerNotFoundException;

public interface CustomerDao {
	
	boolean addCustomer(Customer customer) throws SQLException;
	
	boolean modifyCustomerDetails(int id, Customer customer) throws SQLException;
	
	boolean deleteCustomerRecord(int id) throws SQLException;
	
	Customer findCustomer(int id) throws SQLException, CustomerNotFoundException;
	
	List<Customer> findAllCustomer() throws SQLException;
	
}
