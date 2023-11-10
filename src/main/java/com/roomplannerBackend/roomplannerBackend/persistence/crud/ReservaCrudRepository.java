package com.roomplannerBackend.roomplannerBackend.persistence.crud;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.persistence.entity.Reserva;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReservaCrudRepository extends CrudRepository<Reserva, Integer> {
    Optional<List<Reserva>> findByIdCliente(String idCliente);
}
