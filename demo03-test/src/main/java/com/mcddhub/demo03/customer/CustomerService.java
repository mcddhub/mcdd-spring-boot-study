package com.mcddhub.demo03.customer;

import com.mcddhub.demo03.exception.CustomerEmailUnavailableException;
import com.mcddhub.demo03.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * CustomerService
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 21:00
 */
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository repository;

    /**
     * getCustomers
     *
     * @return List<Customer>
     */
    public List<Customer> getCustomers() {
        return repository.findAll();
    }

    /**
     * getCustomerById
     *
     * @param id id
     * @return Customer
     */
    public Customer getCustomerById(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("Customer with id " + id + " doesn't found"));
    }

    /**
     * createCustomer
     *
     * @param createCustomerRequest createCustomerRequest
     */
    public void createCustomer(CreateCustomerRequest createCustomerRequest) {
        validateCustomerByEmail(createCustomerRequest.email());
        Customer customer = Customer.builder()
                .name(createCustomerRequest.name())
                .email(createCustomerRequest.email())
                .address(createCustomerRequest.address()).build();
        repository.save(customer);
    }


    /**
     * updateCustomer
     *
     * @param id      id
     * @param name    name
     * @param email   email
     * @param address address
     */
    public void updateCustomer(Integer id, String name, String email, String address) {
        Customer customer = repository.findById(id).orElseThrow(() ->
                new CustomerNotFoundException("Customer with id " + id + " doesn't found"));
        if (Objects.nonNull(name) && !Objects.equals(customer.getName(), name)) {
            customer.setName(name);
        }
        if (Objects.nonNull(email) && !Objects.equals(customer.getEmail(), email)) {
            validateCustomerByEmail(email);
            customer.setEmail(email);
        }
        if (Objects.nonNull(address) && !Objects.equals(customer.getAddress(), address)) {
            customer.setAddress(address);
        }
        repository.save(customer);
    }

    /**
     * deleteCustomer
     *
     * @param id id
     */
    public void deleteCustomer(Integer id) {
        boolean isExist = repository.existsById(id);
        if (!isExist) {
            throw new CustomerNotFoundException("Customer with id " + id + " doesn't exist.");
        }
        repository.deleteById(id);
    }

    /**
     * validateCustomerByEmail
     * @param email email
     */
    private void validateCustomerByEmail(String email) {
        Optional<Customer> customerByEmail = repository.findByEmail(email);
        if (customerByEmail.isPresent()) {
            throw new CustomerEmailUnavailableException("The email " + email + " unavailable.");
        }
    }

}

