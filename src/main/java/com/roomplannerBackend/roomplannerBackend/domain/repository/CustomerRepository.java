package com.roomplannerBackend.roomplannerBackend.domain.repository;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> getAll();

    Optional<Customer> getCustomerCredentials(String customerId);

    Customer save(Customer customer);

    Optional<Customer> findByEmailAndpassword(String email, String password);
}
