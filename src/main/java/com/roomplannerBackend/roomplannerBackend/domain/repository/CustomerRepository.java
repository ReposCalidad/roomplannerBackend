package com.roomplannerBackend.roomplannerBackend.domain.repository;

import com.roomplannerBackend.roomplannerBackend.domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Optional<Customer> getActivo(String customerId,boolean state);

    Optional<Customer> getCustomerCredentials(String customerId);

    Customer save(Customer customer);

    int updateEstado(String customerId, boolean estado);
}
