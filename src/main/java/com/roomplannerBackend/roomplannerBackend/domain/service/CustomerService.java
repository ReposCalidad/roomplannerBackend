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

    public Optional<Customer> checkCustomerCredentials(String email, String password)
    {
        Optional<Customer> optionalCustomer = customerRepository.findByEmailAndpassword(email, password);
        return optionalCustomer.map(Customer::withoutPassword);
    }

    public boolean admin(String customerId)
    {
        return customerRepository.admin(customerId);
    }

    public Customer save(Customer customer)
    {
        if(customerRepository.existsById(customer.getId())||customerRepository.existsByMail(customer.getMail()))
        {
            throw new RuntimeException("ID o correo ya existen. No se puede guardar el cliente.");
        }
        return customerRepository.save(customer);
    }
}
