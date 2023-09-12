package com.amdocs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.amdocs.dao.CustomerDao;
import com.amdocs.entity.Customer;
import com.amdocs.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao{
	
	
	private static final String INSERT_CUSTOMER="insert into customers(id,user_name,pass,first_name, last_name,phone_number,email_id,address) values(?,?,?,?,?,?,?,?)";
	private static final String DELETE_CUSTOMER="DELETE FROM customers WHERE id = ?";
	private static final String MODIFY_CUSTOMER="UPDATE customers SET user_name=?, pass=?, first_name=?, last_name=?, phone_number=?, email_id=?, address=? WHERE id=?";
	private static final String SELECT_CUSTOMER="SELECT * FROM customers WHERE id = ?";
	private static final String SELECT_ALL_CUSTOMER="SELECT * FROM customers";
	private  Connection connection=DBUtil.getConnection();
	
	@Override
	public boolean addCustomer(Customer customer) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
		// Set The value
		ps.setInt(1, customer.getId());
		ps.setString(2, customer.getUserName());
		ps.setString(3, customer.getPass());
		ps.setString(4, customer.getFirstName());
		ps.setString(5, customer.getLastName());
		ps.setString(6, customer.getPhoneNumber());
		ps.setString(7, customer.getEmailId());
		ps.setString(8, customer.getAddress());
		//Execute Statement
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyCustomerDetails(int customerId, Customer newCustomer) throws SQLException{

	    PreparedStatement ps = connection.prepareStatement(MODIFY_CUSTOMER);
	    
	    // Set the new values for the customer's details
	    ps.setString(1, newCustomer.getUserName());
	    ps.setString(2, newCustomer.getPass());
	    ps.setString(3, newCustomer.getFirstName());
	    ps.setString(4, newCustomer.getLastName());
	    ps.setString(5, newCustomer.getPhoneNumber());
	    ps.setString(6, newCustomer.getEmailId());
	    ps.setString(7, newCustomer.getAddress());
	    
	    // Set the customer ID parameter in the PreparedStatement
	    ps.setInt(8, customerId);
	    
	    // Execute the update statement
	    int rowsUpdated = ps.executeUpdate();
	    
	    // Close the PreparedStatement
	    ps.close();
	    
	    // Check if any rows were updated and return true if at least one row was updated
	    return rowsUpdated > 0;
	}

	@Override
	public boolean deleteCustomerRecord(int id) throws SQLException {
		 // Create the PreparedStatement for deleting a customer by ID
	    PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
	    
	    // Set the customer ID parameter in the PreparedStatement
	    ps.setInt(1, id);
	    
	    // Execute the delete statement
	    int rowsDeleted = ps.executeUpdate();
	    
	    // Close the PreparedStatement
	    ps.close();
	    
	    // Check if any rows were deleted and return true if at least one row was deleted
	    return rowsDeleted > 0;
	}

	@Override
	public Customer findCustomer(int id) throws SQLException {
		Customer customer = null;
	    
	    // Create the PreparedStatement for finding a customer by ID
	    PreparedStatement ps = connection.prepareStatement(SELECT_CUSTOMER);
	    
	    // Set the customer ID parameter in the PreparedStatement
	    ps.setInt(1, id);
	    
	    // Execute the query and retrieve the result set
	    ResultSet rs = ps.executeQuery();
	    
	    // Process the result set and populate the customer object
	    if (rs.next()) {
	        customer = new Customer();
	        customer.setId(rs.getInt("id"));
	        customer.setUserName(rs.getString("user_name"));
	        customer.setPass(rs.getString("pass"));
	        customer.setFirstName(rs.getString("first_name"));
	        customer.setLastName(rs.getString("last_name"));
	        customer.setPhoneNumber(rs.getString("phone_number"));
	        customer.setEmailId(rs.getString("email_id"));
	        customer.setAddress(rs.getString("address"));
	    }
	    
	    // Close the PreparedStatement and ResultSet
	    rs.close();
	    ps.close();
	    
	    return customer;
	}

	@Override
	public List<Customer> findAllCustomer() throws SQLException {
		List<Customer> customers = new ArrayList<>();
	    
	    // Create the PreparedStatement for finding all customers
	    PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CUSTOMER);
	    
	    // Execute the query and retrieve the result set
	    ResultSet rs = ps.executeQuery();
	    
	    // Process the result set and populate the list of customers
	    while (rs.next()) {
	        Customer customer = new Customer();
	        customer.setId(rs.getInt("id"));
	        customer.setUserName(rs.getString("user_name"));
	        customer.setPass(rs.getString("pass"));
	        customer.setFirstName(rs.getString("first_name"));
	        customer.setLastName(rs.getString("last_name"));
	        customer.setPhoneNumber(rs.getString("phone_number"));
	        customer.setEmailId(rs.getString("email_id"));
	        customer.setAddress(rs.getString("address"));
	        customers.add(customer);
	    }
	    
	    // Close the PreparedStatement and ResultSet
	    rs.close();
	    ps.close();
	    
	    return customers;
	}

	
}
