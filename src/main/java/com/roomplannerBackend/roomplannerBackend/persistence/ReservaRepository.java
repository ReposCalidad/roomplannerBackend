package com.roomplannerBackend.roomplannerBackend.persistence;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.domain.repository.BookingRepository;
import com.roomplannerBackend.roomplannerBackend.persistence.crud.ReservaCrudRepository;
import com.roomplannerBackend.roomplannerBackend.persistence.entity.Reserva;
import com.roomplannerBackend.roomplannerBackend.persistence.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ReservaRepository implements BookingRepository {
    @Autowired
    private ReservaCrudRepository reservaCrudRepository;
    @Autowired
    private BookingMapper bookingMapper;

    public List<Booking> getAll()
    {
        List<Reserva> reservas= (List<Reserva>) reservaCrudRepository.findAll();
        return reservas.stream()
                .map(bookingMapper::toBooking)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<List<Booking>> getByCustomer(String customerId) {
        return reservaCrudRepository.findByIdCliente(customerId).map(bookingMapper::toBooking);
    }

    @Override
    public Booking save(Booking booking, String customerId) {
        Reserva reserva = bookingMapper.toReserva(booking);
        return bookingMapper.toBooking(reservaCrudRepository.save(reserva));
    }

    @Override
    public Optional<Booking> getBooking(int bookingId) {
        return reservaCrudRepository.findById(bookingId).map(reserva -> bookingMapper.toBooking(reserva));
    }

    @Override
    public void delete(int bookingId) {
        reservaCrudRepository.deleteById(bookingId);
    }

}
