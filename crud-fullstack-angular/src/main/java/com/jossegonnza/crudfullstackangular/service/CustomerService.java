package com.jossegonnza.crudfullstackangular.service;

import com.jossegonnza.crudfullstackangular.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> finAll();
    Customer findById(Integer id);
    void deleteById(Integer id);
    Customer update(Customer customer);
}
