package com.example.transaction.transaction.repository;

import com.example.transaction.customermodel.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer , Long> {
}
