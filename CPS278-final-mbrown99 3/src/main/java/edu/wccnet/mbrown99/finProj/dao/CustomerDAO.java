package edu.wccnet.mbrown99.finProj.dao;

import java.util.List;

import edu.wccnet.mbrown99.finProj.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
}
