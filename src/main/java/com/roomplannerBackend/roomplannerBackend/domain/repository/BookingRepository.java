package com.roomplannerBackend.roomplannerBackend.domain.repository;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    List<Booking> getAll();
    Optional<List<Booking>> getByCustomer(String customerId);
    Booking save(Booking booking, String customerId);
    Optional<Booking> getBooking(int bookingId);
    void delete(int bookingId);
}
