package com.example.hotelBooking.service.impl;

import com.example.hotelBooking.constant.BookingHotelConstant;
import com.example.hotelBooking.entity.Booking;
import com.example.hotelBooking.repository.BookingRepository;
import com.example.hotelBooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public Boolean deleteBooking(Long id) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateStatusById(Long id, String status) {
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if (optionalBooking.isPresent()) {
            bookingRepository.updateStatusById(id, status);
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getAllCheckInToday(String today) {
        return bookingRepository.getAllCheckInToday(today);
    }

    @Override
    public List<Booking> getBookingByStatus(String status) {
        return bookingRepository.getBookingByStatus(status);
    }
}
