package com.rakib.springreactive.service;

import com.rakib.springreactive.dao.CustomerDao;
import com.rakib.springreactive.dto.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDao customerDao;


    public List<Customer> getCustomer() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        log.info("Total Execution Time " + (start - end));
        return customers;
    }

    public Flux<Customer> getCustomerStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        log.info("Total Execution Time " + (start - end));
        return customers;
    }

}
