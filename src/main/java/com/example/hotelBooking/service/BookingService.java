package com.example.hotelBooking.service;

import com.example.hotelBooking.entity.Booking;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();

    Booking getBookingById(Long id);

    Booking createBooking(Booking booking);

    Boolean deleteBooking(Long id);

    Boolean updateStatusById(Long id, String status);

    List<Booking> getAllCheckInToday(String today);

    List<Booking> getBookingByStatus(String status);
}
