package org.example.controller;

import jakarta.validation.Valid;
import org.example.entity.ServiceBooking;
import org.example.service.ServiceBookingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class ServiceBookingController {

    private final ServiceBookingService service;

    public ServiceBookingController(ServiceBookingService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceBooking> getAllBookings() {
        return service.getAllBookings();
    }

    @PostMapping
    public ServiceBooking createBooking(@Valid @RequestBody ServiceBooking booking) {
        return service.saveBooking(booking);
    }
}
