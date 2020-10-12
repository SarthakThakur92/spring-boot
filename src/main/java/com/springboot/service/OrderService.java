package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.OrderRequest;
import com.springboot.entity.Customer;
import com.springboot.repository.CustomerRepository;
import com.springboot.repository.ProductRepository;

@Service
public class OrderService {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;

	public Customer placeOrder(OrderRequest orderRequest) {
		return customerRepository.save(orderRequest.getCustomer());
	}
	public List<Customer> getAllOrders() {
		return customerRepository.findAll();
	}
	public void deleteOrder(int id) {
		customerRepository.delete(customerRepository.findById(id));
	}
	public Customer updateCustomer(int id, OrderRequest orderRequest) {
		Customer order = customerRepository.findById(id);
		order.setGender(orderRequest.getCustomer().getGender());
		order.setEmail(orderRequest.getCustomer().getEmail());
		order.setName(orderRequest.getCustomer().getName());
		order.setProducts(orderRequest.getCustomer().getProducts());
		customerRepository.save(order);
		return order;
	}

}
