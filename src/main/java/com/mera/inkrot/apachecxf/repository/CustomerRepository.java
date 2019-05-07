package com.mera.inkrot.apachecxf.repository;

import com.mera.inkrot.apachecxf.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomerByName(String name);
}
