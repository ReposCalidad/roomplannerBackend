package com.roomplannerBackend.roomplannerBackend.persistence.crud;

import com.roomplannerBackend.roomplannerBackend.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
    Optional<Cliente> findByIdAndEstado(String id, Boolean estado);
}
