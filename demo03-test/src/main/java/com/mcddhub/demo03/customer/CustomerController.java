package com.mcddhub.demo03.customer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CustomerController
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 21:01
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/customers")
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        log.info("Received get all customers request");
        return service.getCustomers();
    }

    @GetMapping(path = "/{id}")
    public Customer getCustomerById(@PathVariable("id") Integer id) {
        log.info("Received the get customer with id {}", id);
        return service.getCustomerById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        log.info("Received create new customer {}", createCustomerRequest);
        service.createCustomer(createCustomerRequest);
    }


    @PutMapping(path = "/{id}")
    public void updateCustomer(@PathVariable("id") Integer id,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String address) {
        log.info("Received the update request of id: {} with name: {}, email: {}, address: {}",
                id, name, email, address);
        service.updateCustomer(id, name, email, address);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        log.info("Received the delete customer with id: {}", id);
        service.deleteCustomer(id);
    }
}
