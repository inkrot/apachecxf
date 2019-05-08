package com.mera.inkrot.apachecxf.service.impl;

import com.mera.inkrot.apachecxf.model.Customer;
import com.mera.inkrot.apachecxf.repository.CustomerRepository;
import com.mera.inkrot.apachecxf.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Optional;

@WebService
@Component
public class CustomerServiceImpl implements CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        logger.info("get customer by id: {}", id);
        Optional<Customer> customer = customerRepository.findById(id);
        if (! customer.isPresent())
            throw new IllegalArgumentException("Customer not found");
        return customer.get();
    }

    @Override
    public Customer save(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Customer name do not entered");
        }
        Customer findCustomer = customerRepository.getCustomerByName(name);
        if (findCustomer != null) {
            logger.debug("Customer {} already exist", name);
            return findCustomer;
        }
        logger.info("add customer: {}", name);
        return customerRepository.saveAndFlush(new Customer(name));
    }
}
