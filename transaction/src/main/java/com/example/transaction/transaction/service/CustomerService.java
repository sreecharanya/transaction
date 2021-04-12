package com.example.transaction.transaction.service;


import com.example.transaction.customermodel.Customer;
import com.example.transaction.transaction.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("customerService")
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        List<Customer> customer= new ArrayList<>();
        customerRepository.findAll().forEach(customer::add);
        return customer;
    }
    public Customer getCustomerDetailsById(long id){
        return customerRepository.findById(id).get();
    }
}
