package com.example.RestApiService.Services;

import com.example.RestApiService.Entities.Customer;
import com.example.RestApiService.Exceptions.CustomerAlreadyExistException;
import com.example.RestApiService.Exceptions.CustomerNotFoundException;
import com.example.RestApiService.Models.CustomerModel;
import com.example.RestApiService.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
//    Заменить тип инъекции
    @Autowired
    private CustomerRepository customerRepository;

    public Customer registrationNewCustomer (Customer customer) throws CustomerAlreadyExistException {
        if (customerRepository.findByUsername(customer.getUsername()) != null){
            throw new CustomerAlreadyExistException("Пользователь с таким именем уже существует.");
        }
        return customerRepository.save(customer);
    }

    public CustomerModel getOneUser(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).get();
        if(!customerRepository.findById(id).isPresent()){
            throw new CustomerNotFoundException("Пользователь не найден");
        }
        return CustomerModel.toModel(customer);
    }

    public CustomerModel getUserByUsername(String username) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByUsername(username);
        if(customerRepository.findByUsername(username).getUsername() == null){
            throw new CustomerNotFoundException("Пользователь не найден");
        }
        return CustomerModel.toModel(customer);
    }

    public Customer updateUser(Long id, Customer changedCustomer) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id).get();
        if(customer == null){
            throw new CustomerNotFoundException("Пользователь не найден");
        }
        customer.setAddress(changedCustomer.getAddress());
        customer.setDetails(changedCustomer.getDetails());
        customer.setPhoneNumber(changedCustomer.getPhoneNumber());
        return customerRepository.save(customer);
    }

    public Long delete(Long id){
        customerRepository.deleteById(id);
        return id;
    }

}
