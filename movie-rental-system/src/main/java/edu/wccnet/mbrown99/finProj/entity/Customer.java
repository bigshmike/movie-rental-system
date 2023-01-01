package edu.wccnet.mbrown99.finProj.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<CustomerMovie> checkoutHistory = new ArrayList<CustomerMovie>();
	
	public Customer() {
		
	}

	public Customer(String firstName) {
		setFirstName(firstName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public List<CustomerMovie> getCheckoutHistory() {
		return checkoutHistory;
	}

	public void setCheckoutHistory(List<CustomerMovie> checkoutHistory) {
		this.checkoutHistory = checkoutHistory;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + "]";
	}
	
	
}
