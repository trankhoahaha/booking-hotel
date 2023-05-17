package com.example.hotelBooking.service;

import com.example.hotelBooking.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();

    Booking getBookingById(Long id);

    Booking createBooking(Booking booking);

    Booking updateBooking(Long id, Booking booking);

    Boolean deleteBooking(Long id);

    List<Booking> getListBookingByUser(Long userId);
}
