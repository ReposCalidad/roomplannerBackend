package com.roomplannerBackend.roomplannerBackend.domain.repository;

import com.roomplannerBackend.roomplannerBackend.domain.Customer;


import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    List<Customer> getAll();

    Optional<Customer> getCustomerCredentials(String customerId);


    Optional<Customer> findByEmailAndpassword(String email, String password);

    Optional<Customer> updateEstadoById(String id, boolean estado);

    Boolean admin(String id);

    Customer save(Customer customer);

}
