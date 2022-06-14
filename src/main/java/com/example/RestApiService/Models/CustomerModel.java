package com.example.RestApiService.Models;

import com.example.RestApiService.Entities.Customer;

public class CustomerModel {
//  Модель без пароля и почты и id

    private String username;
    private String address;
    private String details;
    private String phoneNumber;

    public static CustomerModel toModel(Customer customer){
        CustomerModel customerModel = new CustomerModel();

        customerModel.setUsername(customer.getUsername());
        customerModel.setAddress(customer.getAddress());
        customerModel.setDetails(customer.getDetails());
        customerModel.setPhoneNumber(customer.getPhoneNumber());
        return customerModel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerModel() {
    }
}
