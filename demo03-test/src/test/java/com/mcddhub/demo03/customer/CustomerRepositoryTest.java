package com.mcddhub.demo03.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository underTest;

    @BeforeEach
    void setUp() {
        Customer customer = Customer.builder()
                .name("mcdd")
                .email("mcdd@gmail.com")
                .address("ZH-CN")
                .build();
        underTest.save(customer);
    }

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void shouldReturnCustomerWhenFindByEmail() {
        //given
        //when
        Optional<Customer> customer = underTest.findByEmail("mcdd@gmail.com");
        // then
        assertThat(customer).isPresent();
    }

    @Test
    void shouldNotFoundCustomerWhenFindByEmailIsNotPresent() {
        //given
        //when
        Optional<Customer> customer = underTest.findByEmail("not-exist@gmail.com");
        // then
        assertThat(customer).isNotPresent();
    }

}