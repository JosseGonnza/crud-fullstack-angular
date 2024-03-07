package com.jossegonnza.crudfullstackangular.controller;

import com.jossegonnza.crudfullstackangular.entity.Customer;
import com.jossegonnza.crudfullstackangular.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/api/customers
@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //http://localhost:8080/api/customers --> no es necesario url porque solo hay un post
    @PostMapping
    public Customer save(@RequestBody Customer customer){ //RequestBody tranforma el Json del cliente a tipo Java
        return customerService.save(customer);
    }

    //http://localhost:8080/api/customers
    @GetMapping
    public List<Customer> findAll(){
        return customerService.finAll();
    }

    //http://localhost:8080/api/customers/{id}
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Integer id){
        return customerService.findById(id);
    }

    //http://localhost:8080/api/customers/{id}
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        customerService.deleteById(id);
    }

    //http://localhost:8080/api/customers
    @PutMapping
    public Customer update(@RequestBody Customer customer) {
        Customer customerDb = customerService.findById(customer.getId());
        customerDb.setFirstName(customer.getFirstName());
        customerDb.setLastName(customer.getLastName());
        customerDb.setEmail(customer.getEmail());
        return customerService.update(customerDb);
    }
}
