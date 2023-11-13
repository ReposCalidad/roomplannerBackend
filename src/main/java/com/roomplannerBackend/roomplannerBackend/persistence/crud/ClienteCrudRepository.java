package com.roomplannerBackend.roomplannerBackend.persistence.crud;

import com.roomplannerBackend.roomplannerBackend.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteCrudRepository extends CrudRepository<Cliente, String> {
    Optional<Cliente> findByCorreoAndContraseña(String correo, String contraseña);

    @Modifying
    @Query("UPDATE Cliente c SET c.estado = :newState WHERE c.id = :customerId")
    Optional<Cliente> updateByEstado(@Param("customerId") String customerId, @Param("newState") boolean newState);

    boolean existsByCorreo(String correo);
}
