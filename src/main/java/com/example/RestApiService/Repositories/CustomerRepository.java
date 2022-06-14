package com.example.RestApiService.Repositories;

import com.example.RestApiService.Entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByUsername(String username);
}
