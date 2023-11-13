package com.roomplannerBackend.roomplannerBackend.web.controller;

import com.roomplannerBackend.roomplannerBackend.domain.Customer;
import com.roomplannerBackend.roomplannerBackend.domain.service.CustomerService;
import com.roomplannerBackend.roomplannerBackend.persistence.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Autowired
    private ClienteRepository clienteRepository;

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

    @GetMapping("/admin/{id}")
    public boolean admin(@PathVariable("id")String customerId)
    {
        return customerService.admin(customerId);
    }
    @PostMapping("/save")
    public Customer save(Customer customer)
    {
        return customerService.save(customer);
    }

    @PutMapping("/updateState/{id}/{estado}")
    public boolean updateEstado(@PathVariable("id") String idCliente, @PathVariable("estado") Boolean newState) {
        Optional<Customer> updatesCustomer = clienteRepository.updateEstadoById(idCliente, newState);
        if(updatesCustomer.isPresent())
        {
            return new ResponseEntity<>(updatesCustomer.get(), HttpStatus.OK).hasBody();
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND).hasBody();
        }
    }
}
