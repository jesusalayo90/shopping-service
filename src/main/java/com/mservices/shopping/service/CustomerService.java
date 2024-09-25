package com.mservices.shopping.service;

import com.mservices.shopping.entity.Customer;
import com.mservices.shopping.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        return customer;
    }
}
