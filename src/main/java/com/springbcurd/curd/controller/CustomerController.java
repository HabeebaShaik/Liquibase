package com.springbcurd.curd.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbcurd.curd.customer.Customer;
import com.springbcurd.curd.service.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService service;

	@GetMapping("/viewcustomers")
	public List<Customer> list() {
		return service.listAll();
	}

	@GetMapping("/viewcustomers/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		return service.getCustomerById(id);
	}

	@PostMapping("/addCustomers")
	public String add(@Valid @RequestBody Customer customer) {
		service.save(customer);
		return "Added successfully";
	}

	@PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
        return service.updateCustomer(id, customer);
    }

	@DeleteMapping("/deletecustomers/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "Deleted successfully";
	}
}
