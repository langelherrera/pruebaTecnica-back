package com.example.demo.services;

import com.example.demo.dto.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer findCustomer(){
        Customer customer=new Customer();
        return customer;
    }
}
