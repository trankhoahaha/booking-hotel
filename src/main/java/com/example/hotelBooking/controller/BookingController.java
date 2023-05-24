package com.example.hotelBooking.controller;

import com.example.hotelBooking.entity.Booking;
import com.example.hotelBooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bookings")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBooking();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id) {
        Booking booking = bookingService.getBookingById(id);
        if (booking != null) {
            return ResponseEntity.ok(booking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking createdBooking = bookingService.createBooking(booking);
        if (createdBooking != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Void> updateStatusById(@PathVariable("id") Long id, @RequestBody String status) {
        boolean updated = bookingService.updateStatusById(id, status);
        if (updated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<Void> deleteBooking(@PathVariable("id") Long id) {
        boolean deleted = bookingService.deleteBooking(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/check-in-today")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Booking>> getAllCheckInToday(@RequestParam("today") String today) {
        List<Booking> bookings = bookingService.getAllCheckInToday(today);
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/status/{status}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    public ResponseEntity<List<Booking>> getBookingByStatus(@PathVariable("status") String status) {
        List<Booking> bookings = bookingService.getBookingByStatus(status);
        return ResponseEntity.ok(bookings);
    }

}
