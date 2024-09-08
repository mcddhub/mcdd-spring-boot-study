package com.mcddhub.demo03.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * CustomerRepository
 *
 * @version 1.0.0
 * @author: coder-mcdd
 * @date: 2024/9/8 20:59
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Optional<Customer> findByEmail(String email);
}
