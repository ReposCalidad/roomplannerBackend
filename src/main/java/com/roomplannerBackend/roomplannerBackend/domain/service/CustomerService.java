package com.roomplannerBackend.roomplannerBackend.domain.service;

import com.roomplannerBackend.roomplannerBackend.domain.Customer;
import com.roomplannerBackend.roomplannerBackend.domain.repository.BookingRepository;
import com.roomplannerBackend.roomplannerBackend.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Autowired
    private BookingRepository bookingRepository;

    public List<Customer> getAll()
    {
        return  customerRepository.getAll();
    }

    public Optional<Customer> getCustomerCredentials(String customerId)
    {
        return customerRepository.getCustomerCredentials(customerId).map(customer -> {
            customer.setBookings(bookingRepository.getByCustomer(customerId).orElse(null));
            return customer;
        });
    }

    public Customer save(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public Optional<Customer> checkCustomerCredentials(String email, String password)
    {
        return customerRepository.findByEmailAndpassword(email, password);
    }

    public boolean admin(String customerId)
    {
        return customerRepository.admin(customerId);
    }
}
