package edu.wccnet.mbrown99.finProj.service;

import java.util.List;

import edu.wccnet.mbrown99.finProj.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	
	public Customer getCustomer(int id);
}
