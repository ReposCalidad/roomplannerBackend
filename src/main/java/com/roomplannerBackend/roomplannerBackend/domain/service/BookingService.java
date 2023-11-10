package com.roomplannerBackend.roomplannerBackend.domain.service;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.domain.repository.BookingRepository;
import com.roomplannerBackend.roomplannerBackend.persistence.crud.ReservaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAll(){
        return bookingRepository.getAll();
    };

    public Optional<List<Booking>> getByCustomer(String customerId)
    {
        return bookingRepository.getByCustomer(customerId);
    }

    public Booking save(Booking booking)
    {
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBooking(int bookingId)
    {
        return bookingRepository.getBooking(bookingId);
    }

    public boolean delete(int bookingId)
    {
        return getBooking(bookingId).map(booking -> {
            bookingRepository.delete(bookingId);
            return true;
        }).orElse(false);
    }
}
