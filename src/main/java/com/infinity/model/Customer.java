package com.infinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_category")
	private String customerCategory;
	@Column(name = "customer_orderCount")
	private int customerOrderCount;
	@Column(name = "customer_TotalDiscount")
	private double customerDiscount;

	public Customer() {
		super();
	}

	public Customer(int customerId, String customerName, String customerCategory, int customerOrderCount,
			double customerDiscount) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerCategory = customerCategory;
		this.customerOrderCount = customerOrderCount;
		this.customerDiscount = customerDiscount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerOrderCount() {
		return customerOrderCount;
	}

	public void setCustomerOrderCount(int customerOrderCount) {
		if (customerOrderCount >= 10 && customerOrderCount <= 19) {
			setCustomerCategory("GOLD");
			this.customerOrderCount = customerOrderCount;
		} else if (customerOrderCount >= 20) {
			setCustomerCategory("PLATINUM");
			this.customerOrderCount = customerOrderCount;
		} else {
			setCustomerCategory("REGULAR");
			this.customerOrderCount = customerOrderCount;
		}
	}

	public double getCustomerDiscount() {
		return customerDiscount;
	}

	public void setCustomerDiscount(double customerDiscount) {
		this.customerDiscount = customerDiscount;

	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCategory() {
		return customerCategory;
	}

	public void setCustomerCategory(String customerCategory) {
		if (customerCategory == "GOLD") {
			setCustomerDiscount(getCustomerDiscount() + 10 % 100);
			this.customerCategory = customerCategory;
		} else if (customerCategory == "PLATINUM") {
			setCustomerDiscount(getCustomerDiscount()+ 20 % 100);
			this.customerCategory = customerCategory;
		}
		this.customerCategory = customerCategory;
	}

}
