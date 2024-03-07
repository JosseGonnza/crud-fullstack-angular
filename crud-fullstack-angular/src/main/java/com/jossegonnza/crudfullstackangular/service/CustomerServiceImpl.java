package com.jossegonnza.crudfullstackangular.service;

import com.jossegonnza.crudfullstackangular.entity.Customer;
import com.jossegonnza.crudfullstackangular.exception.ResourceNotFoundException;
import com.jossegonnza.crudfullstackangular.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> finAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = customerRepository.findById(id).orElseThrow( //Lanza una excepción lambda
                () ->{
                    throw new ResourceNotFoundException("Customer con id " + id + " no se encuentra.");
                }
        );
        //return customerRepository.findById(id).get();
        return customer;
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
}
