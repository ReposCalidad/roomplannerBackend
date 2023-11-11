package com.roomplannerBackend.roomplannerBackend.web.controller;

import com.roomplannerBackend.roomplannerBackend.domain.Customer;
import com.roomplannerBackend.roomplannerBackend.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAll()
    {
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getCustomerCredentials(@PathVariable("id") String customerId)
    {
        return customerService.getCustomerCredentials(customerId);
    }

    @GetMapping("/checkcredentials/{correo}/{contraseña}")
    public boolean checkCustomerCredentials(@PathVariable("correo") String email,@PathVariable("contraseña") String password)
    {
        return customerService.checkCustomerCredentials(email, password);
    }
    @PostMapping("/save")
    public Customer save(Customer customer)
    {
        return customerService.save(customer);
    }

}
