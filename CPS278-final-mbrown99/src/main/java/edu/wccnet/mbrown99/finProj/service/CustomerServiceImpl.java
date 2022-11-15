package edu.wccnet.mbrown99.finProj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.wccnet.mbrown99.finProj.dao.CustomerDAO;
import edu.wccnet.mbrown99.finProj.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerDAO.getCustomer(id);
		/*if (customer == null) {
			throw new CustomerNotFoundException("Customer ID [" + id + "] was not found");
		}*/
		return customerDAO.getCustomer(id);
	}

}
