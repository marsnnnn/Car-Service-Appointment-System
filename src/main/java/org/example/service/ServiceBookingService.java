package org.example.service;

import org.example.entity.ServiceBooking;
import org.example.repository.ServiceBookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBookingService {

    private final ServiceBookingRepository repository;

    public ServiceBookingService(ServiceBookingRepository repository) {
        this.repository = repository;
    }

    public List<ServiceBooking> getAllBookings() {
        return repository.findAll();
    }

    public ServiceBooking saveBooking(ServiceBooking booking) {
        if (booking.getStatus() == null || booking.getStatus().isBlank()) {
            booking.setStatus("NEW");
        }
        return repository.save(booking);
    }
}
