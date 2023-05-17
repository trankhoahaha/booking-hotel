package com.example.hotelBooking.service.impl;

import com.example.hotelBooking.entity.Booking;
import com.example.hotelBooking.repository.BookingRepository;
import com.example.hotelBooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        return optionalBooking.orElse(null);
    }

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            Booking existingBooking = optionalBooking.get();
            existingBooking.setRoom(booking.getRoom());
            existingBooking.setUser(booking.getUser());
            existingBooking.setPrice(booking.getPrice());
            existingBooking.setCheckInDate(booking.getCheckInDate());
            existingBooking.setCheckOutDate(booking.getCheckOutDate());
            existingBooking.setAdultsNumber(booking.getAdultsNumber());
            existingBooking.setChildrenNumber(booking.getChildrenNumber());
            existingBooking.setPersonList(booking.getPersonList());
            return bookingRepository.save(existingBooking);
        }
        return null;
    }

    @Override
    public Boolean deleteBooking(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getListBookingByUser(Long userId) {
        return bookingRepository.findBookingByUser(userId);
    }
}
