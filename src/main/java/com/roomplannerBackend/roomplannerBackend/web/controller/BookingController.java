package com.roomplannerBackend.roomplannerBackend.web.controller;

import com.roomplannerBackend.roomplannerBackend.domain.Booking;
import com.roomplannerBackend.roomplannerBackend.domain.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/all")
    public List<Booking> getAll(){
        return bookingService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<List<Booking>> getByCustomer(@PathVariable("id") String customerId)
    {
        return bookingService.getByCustomer(customerId);
    }

    @PostMapping("/save")
    public Booking save(@RequestBody Booking booking, String customerId)
    {
        return bookingService.save(booking, customerId);
    }

    @GetMapping("/bookingid/{bookingId}")
    public Optional<Booking> getBooking(@PathVariable("bookingId") int bookingId)
    {
        return bookingService.getBooking(bookingId);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int bookingId)
    {
        return bookingService.delete(bookingId);
    }
}
