package com.roomplannerBackend.roomplannerBackend.persistence.crud;

import com.roomplannerBackend.roomplannerBackend.domain.Customer;
import com.roomplannerBackend.roomplannerBackend.persistence.entity.Cliente;
import com.roomplannerBackend.roomplannerBackend.persistence.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
    Optional<Cliente> findByCorreoAndContraseña(String correo, String contraseña);
}
