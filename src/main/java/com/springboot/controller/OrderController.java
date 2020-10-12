package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.OrderRequest;
import com.springboot.entity.Customer;
import com.springboot.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService service;

	@PostMapping("/placeOrder")
	public ResponseEntity<Customer> placeOrder(@RequestBody OrderRequest orderRequest) {
		Customer customer = service.placeOrder(orderRequest);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	@GetMapping("/findAllOrders")
	public List<Customer> getAllOrders() {
		return service.getAllOrders();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") int id) {
		service.deleteOrder(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody OrderRequest orderRequest) {
		Customer order = service.updateCustomer(id, orderRequest);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

}
