package com.jossegonnza.crudfullstackangular.repository;

import com.jossegonnza.crudfullstackangular.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
