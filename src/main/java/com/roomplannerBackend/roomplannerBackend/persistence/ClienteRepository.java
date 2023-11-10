package com.roomplannerBackend.roomplannerBackend.persistence;

import com.roomplannerBackend.roomplannerBackend.domain.Customer;
import com.roomplannerBackend.roomplannerBackend.domain.repository.CustomerRepository;
import com.roomplannerBackend.roomplannerBackend.persistence.crud.ClienteCrudRepository;
import com.roomplannerBackend.roomplannerBackend.persistence.entity.Cliente;
import com.roomplannerBackend.roomplannerBackend.persistence.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepository implements CustomerRepository {
    @Autowired
    private ClienteCrudRepository clienteCrudRepository;
    @Autowired
    private CustomerMapper mapper;


    @Override
    public Optional<Customer> getActivo(String customerId,boolean state){
        return clienteCrudRepository.findByIdAndEstado(customerId, state).map(cliente -> mapper.toCustomer(cliente));
    }

    @Override
    public Optional<Customer> getCustomerCredentials(String customerId) {
        return clienteCrudRepository.findById(customerId).map(cliente -> {
            Customer customer = mapper.toCustomer(cliente);

            customer.setMail(cliente.getCorreo());
            customer.setPassword(cliente.getContraseña());
            return customer;
        });
    }

    @Override
    public Customer save(Customer customer) {
        Cliente cliente = mapper.toCliente(customer);
        return mapper.toCustomer(clienteCrudRepository.save(cliente));
    }

    @Override
    public int updateEstado(String customerId, boolean estado) {
        Optional<Cliente> clienteOpt = clienteCrudRepository.findById(customerId);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setEstado(estado);
            clienteCrudRepository.save(cliente);
            return 1; // Devuelve 1 para indicar que la operación fue exitosa
        } else {
            return 0; // Devuelve 0 para indicar que no se encontró el Cliente
        }
    }

}
